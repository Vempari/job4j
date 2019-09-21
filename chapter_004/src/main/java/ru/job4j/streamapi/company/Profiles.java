package ru.job4j.streamapi.company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Adress> collect(List<Profile> profiles) {
        return profiles.stream()
                .distinct()
                .sorted(Comparator.comparing(x -> x.getAdress().getCity()))
                .map(x -> x.getAdress())
                .collect(Collectors.toList());
    }

}
