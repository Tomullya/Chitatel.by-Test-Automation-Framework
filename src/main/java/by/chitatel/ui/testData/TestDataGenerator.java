package by.chitatel.ui.testData;

import com.github.javafaker.*;

import java.util.*;

public class TestDataGenerator {

    private static final Faker RU_FAKER = new Faker(new Locale("ru"));
    private static final Faker EN_FAKER = new Faker(new Locale("en"));

    private TestDataGenerator() {
    }

    public static String randomEmail() {
        return "mail" + UUID.randomUUID() + "mail.com";
    }

    public static String randomPassword() {
        return EN_FAKER.internet().password(6, 8);
    }

    public static String randomRuWord() {
        return RU_FAKER.lorem().word();
    }

    public static String randomEnWord() {
        return EN_FAKER.lorem().word();
    }


}
