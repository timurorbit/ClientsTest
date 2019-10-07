package ru.javawebinar.topjava.service;


import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

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
/*
    @Autowired
    private ClientService service;

    @Test
    public void getAll() throws Exception{
        List<Client> all = service.getAll(USER_ID);
        assertMatch(all, CLIENT_LIST);
    }

    @Test(expected = NotFoundException.class)
    public void deleteWithFalseMealID() throws Exception{
        service.delete(9999,USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void deleteOtherUserMeal() throws Exception{
       service.delete(USER_ONE.getId(), ADMIN_ID);
    }

    @Test
    public void delete() throws Exception{
        service.delete(MealTestData.USER_ONE.getId(), USER_ID);
        List<Client> actual = service.getAll(USER_ID);
        List<Client> expected = CLIENT_LIST.subList(1, CLIENT_LIST.size());
        assertMatch(actual, expected);
    }

    @Test
    public void create() throws Exception{
        Client newClient = new Client(LocalDateTime.now(),"testNewMeal",1000);
        Client created = service.create(newClient, USER_ID);
        newClient.setId(created.getId());
    }

    @Test
    public void get() throws Exception{
      Client actual = service.get(USER_ONE.getId(), USER_ID);
      assertMatch(actual, USER_ONE);
    }

    @Test
    public void save() throws Exception{
        List<Client> expected = new ArrayList<>(CLIENT_LIST);
        expected.add(new Client(START_SEQ + 14, LocalDateTime.of(2015, Month.MAY, 5, 5, 5),"test add", 666));    //14 cuz we have admin meals too
        service.create(new Client(LocalDateTime.of(2015, Month.MAY, 5, 5, 5),"test add", 666), USER_ID);
        List<Client> actual = service.getAll(USER_ID);
        assertMatch(actual, expected);
    }

    @Test
    public void getBetweenTimes() throws Exception{
        List<Client> expected = Arrays.asList(USER_ONE, USER_TWO, USER_THREE);
        List<Client> actual = service.getBetweenDates(LocalDate.of(2015,1,1),LocalDate.of(2015,1,1),USER_ID);
        assertMatch(expected, actual);
    }

    @Test
    public void getBetweenDateTimes() throws Exception{
        List<Client> expected = Arrays.asList(USER_FOUR);
        List<Client> actual = service.getBetweenDateTimes(LocalDateTime.of(2015,1,2,4,0,1),
                LocalDateTime.of(2015,1,2,5,0,0),
                USER_ID);
        assertMatch(expected, actual);
    }
*/

}
