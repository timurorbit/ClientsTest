package ru.javawebinar.clients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.javawebinar.clients.repository.MealRepository;
import ru.javawebinar.clients.model.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.clients.util.DateTimeUtil.adjustEndDateTime;
import static ru.javawebinar.clients.util.DateTimeUtil.adjustStartDateTime;
import static ru.javawebinar.clients.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ClientService {

    private final MealRepository repository;

    @Autowired
    public ClientService(MealRepository repository) {
        this.repository = repository;
    }

    public Client get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Client> getBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return getBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate));
    }

    public List<Client> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return repository.getBetween(startDateTime, endDateTime);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

    public void update(Client client) {
        checkNotFoundWithId(repository.save(client), client.getId());
    }

    public Client create(Client client, int userId) {
        return repository.save(client);
    }
}