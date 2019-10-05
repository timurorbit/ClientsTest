package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Client;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.adjustEndDateTime;
import static ru.javawebinar.topjava.util.DateTimeUtil.adjustStartDateTime;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ClientService {

    private final MealRepository repository;

    @Autowired
    public ClientService(MealRepository repository) {
        this.repository = repository;
    }

    public Client get(int id, int userId) {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public List<Client> getBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate, int userId) {
        return getBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate), userId);
    }

    public List<Client> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

    public void update(Client client, int userId) {
        checkNotFoundWithId(repository.save(client, userId), client.getId());
    }

    public Client create(Client client, int userId) {
        return repository.save(client, userId);
    }
}