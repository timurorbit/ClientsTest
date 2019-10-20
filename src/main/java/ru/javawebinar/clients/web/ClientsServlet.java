package ru.javawebinar.clients.web;


;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;
import ru.javawebinar.clients.web.client.ClientRestController;
import ru.javawebinar.clients.model.Client;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import static ru.javawebinar.clients.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.clients.util.DateTimeUtil.parseLocalTime;


@MultipartConfig
public class ClientsServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private ClientRestController mealController;
    private String filePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        mealController = springContext.getBean(ClientRestController.class);
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Client client = new Client(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("status"),
                request.getParameter("satisfaction"),
                request.getParameter("address"),
                request.getParameter("email"),
                request.getParameter("telephoneNumber")
        );
          if (request.getPart("file") != null) {
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            try (InputStream fileContent = filePart.getInputStream();
                 OutputStream os = new FileOutputStream(new File(filePath + fileName))) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileContent.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            }
            client.setImagePath(fileName);
        } else if (request.getParameter("imagePath") != null) {
            client.setImagePath("imagePath");
        } else {
            client.setImagePath("NoImage");
        }
        if (StringUtils.isEmpty(request.getParameter("id"))) {
            mealController.create(client);
        } else {
            mealController.update(client, getId(request));
        }
      File file = new File(filePath + client.getImagePath());
        response.setHeader("Content-Type", getServletContext().getMimeType(client.getImagePath()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + client.getImagePath() + "\"");                 /*  trying to create
        Files.copy(file.toPath(), response.getOutputStream());




        response.setContentType(getServletContext().getMimeType(client.getImagePath()));




    /*    String contentType = request.getContentType();
        if (contentType.indexOf("multipart/form-data") >= 0) {         //request.get image
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List fileItems = upload.parseRequest(request);

                Iterator i = fileItems.iterator();
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);
                        log("file Uploading");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            client.setImagePath("NoImage");
        }    */


        response.sendRedirect("clients");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                mealController.delete(id);
                response.sendRedirect("clients");
                break;
            case "create":
            case "update":
                final Client client = "create".equals(action) ?
                        new Client("firstName", "lastName", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "status", "good", "address", "email", "+79991776644", "NoImage.png") :
                        mealController.get(getId(request));
                request.setAttribute("image", (filePath + mealController.get(getId(request))));
                request.setAttribute("client", client);
                request.getRequestDispatcher("/clientForm.jsp").forward(request, response);
                break;
            case "filter":
                LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
                LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
                LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
                LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
                request.setAttribute("meals", mealController.getBetween(startDate, startTime, endDate, endTime));
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("clients", mealController.getAll());
                request.getRequestDispatcher("/clients.jsp").forward(request, response);
                break;
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
