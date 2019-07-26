package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void convertHashMap() {
        List<User> list = new ArrayList<>();
        User user1 = new User(1, "Vasya", "Vladivostok");
        User user2 = new User(2, "Jenya", "Moscow");
        User user3 = new User(3, "Kolya", "Khabarovsk");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        UserConvert convert = new UserConvert();
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result.get(2).getName(), is("Jenya"));

    }
}
