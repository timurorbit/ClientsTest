package ru;

import ru.javawebinar.clients.model.Client;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTestData {

    public static final int CLIENT_ID = 100000;          // magic number lul

    public static final Client CLIENT1 = new Client(CLIENT_ID,"Tomioka", "Giyū", LocalDateTime.of(2015, Month.JANUARY, 2, 2, 0, 1),"status","satisfaction","address","@mail","telephone", "giyu tomioka.jpg");
    public static final Client CLIENT2 = new Client(CLIENT_ID + 1,"Kanroji", "Mitsuri", LocalDateTime.of(2015, Month.JANUARY, 3, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Mitsuri Kanroji.jpg");
    public static final Client CLIENT3 = new Client(CLIENT_ID + 2,"Iguro", "Obanai", LocalDateTime.of(2015, Month.JANUARY, 4, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Obanai Iguro.jpg");
    public static final Client CLIENT4 = new Client(CLIENT_ID + 3,"Shinazugawa", "Sanemi", LocalDateTime.of(2015, Month.JANUARY, 5, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Sanemi Shinazugawa.jpg");
    public static final Client CLIENT5 = new Client(CLIENT_ID + 4,"Himejima", "Gyōmei", LocalDateTime.of(2015, Month.JANUARY, 6, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Gyomei Himejima.jpg");
    public static final Client CLIENT6 = new Client(CLIENT_ID + 5,"Tokitō", "Muichirō", LocalDateTime.of(2015, Month.JANUARY, 7, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Muichiro Tokito.jpg");
    public static final Client CLIENT7 = new Client(CLIENT_ID + 6,"Kyojuro", "Rengoku", LocalDateTime.of(2015, Month.JANUARY, 7, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Kyojuro Rengoku.jpg");
    public static final Client CLIENT8 = new Client(CLIENT_ID + 7,"Tengen", "Uzui", LocalDateTime.of(2015, Month.JANUARY, 7, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Tengen Uzui.webp");
    public static final Client CLIENT9 = new Client(CLIENT_ID + 8,"Kochō", "Shinobu", LocalDateTime.of(2015, Month.JANUARY, 8, 2, 0,1),"status","satisfaction","address","@mail","telephone", "Shinobu Kocho.jpg");



/*    ('Tomioka', 'Giyū', '2015-01-02 02:00:01','status','satisfaction','address','@mail','telephone', 'giyu tomioka.jpg'),
            ('Kanroji ', 'Mitsuri', '2015-01-03 02:00:01','status','satisfaction','address','@mail','telephone', 'Mitsuri Kanroji.jpg'),
            ('Iguro', 'Obanai', '2015-01-04 02:00:01','status','satisfaction','address','@mail','telephone', 'Obanai Iguro.jpg'),
            ('Shinazugawa', 'Sanemi', '2015-01-05 02:00:01','status','satisfaction','address','@mail','telephone', 'Sanemi Shinazugawa.jpg'),
            ('Himejima', 'Gyōmei', '2015-01-06 02:00:01','status','satisfaction','address','@mail','telephone', 'Gyomei Himejima.jpg'),
            ('Tokitō', 'Muichirō', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Muichiro Tokito.jpg'),
            ('Kyojuro', 'Rengoku', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Kyojuro Rengoku.jpg'),
            ('Tengen', 'Uzui', '2015-01-07 02:00:01','status','satisfaction','address','@mail','telephone', 'Tengen Uzui.webp'),
            ('Kochō', 'Shinobu', '2015-01-08 02:00:01','status','satisfaction','address','@mail','telephone', 'Shinobu Kocho.jpg');                     CODE FROM SQL     */


    public static final List<Client> CLIENTS = Arrays.asList(CLIENT1, CLIENT2, CLIENT3, CLIENT4, CLIENT5, CLIENT6, CLIENT7, CLIENT8, CLIENT9);

    public static void assertMatch(Client actual, Client excepted){
     assertThat(actual).isEqualToComparingFieldByField(excepted);
    }

    public static void assertMatch(Iterable<Client> actual, Client... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Client> actual, Iterable<Client> expected) {
        assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }


}
