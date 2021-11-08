package home_work_5;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    //https://dius.github.io/java-faker/
    static Faker faker = new Faker(new Locale("ru"));

    public static String firstName = "My firtsname";
    public static String lastName = "My lastname";
    public static String email = "someemail@some.net";
    public static String address = faker.address().streetAddress();
    public static String phoneNumber = "0123456789";
}
