package ru.job4j.pseudo;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   ^   ");
        pic.append("\n");
        pic.append("  ^ ^  ");
        pic.append("\n");
        pic.append(" ^ ^ ^ ");
        pic.append("\n");
        pic.append("^ ^ ^ ^ ");
        return pic.toString();
    }
}
