package ru.javawebinar.clients.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.clients.model.Client;
import ru.javawebinar.clients.repository.MealRepository;
import ru.javawebinar.clients.util.Util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcClientRepositoryImpl implements MealRepository {

    private static final BeanPropertyRowMapper<Client> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Client.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertClient;

    @Autowired
    public JdbcClientRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insertClient = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("clients")
        .usingGeneratedKeyColumns("id");
    }


    @Override
    public Client save(Client client, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", client.getId())
                .addValue("firstName", client.getFirstName())
                .addValue("lastName", client.getLastName())
                .addValue("date_time", client.getDateTime())
                .addValue("status", client.getStatus())
                .addValue("satisfaction", client.getSatisfaction())
                .addValue("address", client.getAddress())
                .addValue("email", client.getEmail())
                .addValue("telephoneNumber", client.getTelephoneNumber())
                .addValue("user_id", userId);
        if (client.isNew()){
            Number newKey = insertClient.executeAndReturnKey(map);
            client.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update("UPDATE clients SET firstname=:firstName, lastname=:lastName, date_time=:date_time, status=:status, satisfaction=:satisfaction, address=:address, " +
                    "email=:email, telephonenumber=:telephoneNumber WHERE id=:id", map);
            return client;
        }
        return client;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM clients WHERE id=?", id) != 0;
    }

    @Override
    public Client get(int id, int userId) {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM clients WHERE id=?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(clients);
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM clients ORDER BY date_time", ROW_MAPPER);
        return clients;

    }

    @Override
    public List<Client> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return getAll().stream()
                .filter(m -> Util.isBetween(m.getDateTime(), startDate, endDate))
                .collect(Collectors.toList());
    }
}
