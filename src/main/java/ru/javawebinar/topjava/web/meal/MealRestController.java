package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Client;
import ru.javawebinar.topjava.service.ClientService;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private final ClientService service;

    @Autowired
    public MealRestController(ClientService service) {
        this.service = service;
    }

    public Client get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
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
        service.update(client, userId);
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

        return service.getBetweenDates(startDate, endDate, userId);
    }
}