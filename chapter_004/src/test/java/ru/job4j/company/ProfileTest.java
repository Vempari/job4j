package ru.job4j.company;


import org.junit.Test;
import ru.job4j.streamapi.company.Adress;
import ru.job4j.streamapi.company.Profile;
import ru.job4j.streamapi.company.Profiles;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProfileTest {
    @Test
    public void whenProfileInAddressOut() {
        Profiles profiles = new Profiles();
        List<Profile> list = new ArrayList<>();
        list.add(new Profile(new Adress("Vladivostok", "Svetlanskaya", 12, 19)));
        list.add(new Profile(new Adress("Moscow", "Petrovsko-Razumovskaya", 1, 555)));
        list.add(new Profile(new Adress("Khabarovsk", "Lenina", 11, 123)));
        list.add(new Profile(new Adress("Khabarovsk", "Lenina", 11, 123)));
        list.add(new Profile(new Adress("Shanghai", "Nanjing Road", 33, 22)));
        List<Adress> result = profiles.collect(list);
        assertThat(result.get(4).getCity(), is("Vladivostok"));


    }
}
