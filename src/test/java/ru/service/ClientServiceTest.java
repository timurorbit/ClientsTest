package ru.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.clients.model.Client;
import ru.javawebinar.clients.service.ClientService;

import java.util.List;

import static ru.ClientTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ClientServiceTest {
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private ClientService service;

    @Test
    public void getAll() throws Exception{
        List<Client> all = service.getAll();
        assertMatch(all, CLIENTS);
    }

    @Test
    public void get() throws Exception{
        Client client = service.get(100000);
        assertMatch(client, CLIENT1);
    }
}
