package ru.javawebinar.topjava;

import ru.javawebinar.clients.model.Client;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestData {

/*    public static final Client USER_ONE = new Client(START_SEQ + 2, LocalDateTime.of(2015,1,1,1,0,1)
            , "one", 201);

    public static final Client USER_TWO = new Client(START_SEQ + 3, LocalDateTime.of(2015,1,1,2,0,1)
            , "two", 202);

    public static final Client USER_THREE = new Client(START_SEQ + 4, LocalDateTime.of(2015,1,1,3,0,1)
            , "three", 203);

    public static final Client USER_FOUR = new Client(START_SEQ + 5, LocalDateTime.of(2015,1,2,4,0,1)
            , "for", 2004);

    public static final Client USER_FIVE = new Client(START_SEQ + 6, LocalDateTime.of(2015,1,2,5,0,1)
            , "five", 205);

    public static final Client USER_SIX = new Client(START_SEQ + 7, LocalDateTime.of(2015,1,2,6,0,1)
            , "six", 206);

    public static final List<Client> CLIENT_LIST = Arrays.asList(USER_ONE, USER_TWO, USER_THREE, USER_FOUR, USER_FIVE, USER_SIX);  */

    public static void assertMatch(Client actual, Client excepted){
     assertThat(actual).isEqualTo(excepted);
    }

    public static void assertMatch(Iterable<Client> actual, Client... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Client> actual, Iterable<Client> expected) {
        assertThat(actual).isEqualTo(expected);
    }

            /*
              ('2015-01-01 00:00:01', 'one', 201, 100000),
  ('2015-01-01 00:00:01', 'two', 202, 100000),
  ('2015-01-01 00:00:01', 'three', 203, 100000),
  ('2015-01-02 00:00:01', 'four', 2004, 100000),
  ('2015-01-02 00:00:01', 'five', 205, 100000),
  ('2015-01-02 00:00:01', 'six', 206, 100000),

  ('2015-01-02 00:00:01', 'admin1', 200, 100001),
  ('2015-01-02 00:00:01', 'admin2', 350, 100001),
  ('2015-01-02 00:00:01', 'admin3', 240, 100001),
  ('2015-01-03 00:00:01', 'admin4', 560, 100001),
  ('2015-01-03 00:00:01', 'admin5', 840, 100001),
  ('2015-01-03 00:00:01', 'admin6', 720, 100001);
             */
}
