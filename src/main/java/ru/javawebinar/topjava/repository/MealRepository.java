package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Client;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository {
    // null if updated meal do not belong to userId
    Client save(Client client, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    Client get(int id, int userId);

    // ORDERED dateTime desc
    List<Client> getAll();

    // ORDERED dateTime desc
    List<Client> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
