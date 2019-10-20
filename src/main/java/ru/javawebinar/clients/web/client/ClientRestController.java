package ru.javawebinar.clients.web.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.clients.web.SecurityUtil;
import ru.javawebinar.clients.model.Client;
import ru.javawebinar.clients.service.ClientService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.clients.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.clients.util.ValidationUtil.checkNew;

@Controller
public class ClientRestController {
    private static final Logger log = LoggerFactory.getLogger(ClientRestController.class);

    private final ClientService service;

    @Autowired
    public ClientRestController(ClientService service) {
        this.service = service;
    }

    public Client get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get meal {} for user {}", id, userId);
        return service.get(id);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete meal {} for user {}", id, userId);
        service.delete(id);
    }

    public List<Client> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Client create(Client client) {
        int userId = SecurityUtil.authUserId();
        checkNew(client);
        log.info("create {} for user {}", client, userId);
        return service.create(client, userId);
    }

    public void update(Client client, int id) {
        int userId = SecurityUtil.authUserId();
        assureIdConsistent(client, id);
        log.info("update {} for user {}", client, userId);
        service.update(client);
    }

    /**
     * <ol>Filter separately
     * <li>by date</li>
     * <li>by time for every date</li>
     * </ol>
     */
    public List<Client> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = SecurityUtil.authUserId();
        log.info("getBetween dates({} - {}) time({} - {}) for user {}", startDate, endDate, startTime, endTime, userId);

        return service.getBetweenDates(startDate, endDate);
    }
}