package ru.javawebinar.clients.repository;

import ru.javawebinar.clients.model.Client;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository {
    // null if updated meal do not belong to userId
    Client save(Client client);

    // false if meal do not belong to userId
    boolean delete(int id);

    // null if meal do not belong to userId
    Client get(int id);

    // ORDERED dateTime desc
    List<Client> getAll();

    // ORDERED dateTime desc
    List<Client> getBetween(LocalDateTime startDate, LocalDateTime endDate);
}
