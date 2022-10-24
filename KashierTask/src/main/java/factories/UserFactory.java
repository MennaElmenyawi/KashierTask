package factories;

import com.github.javafaker.Faker;
import models.User;
import utilities.TimestampBuilder;

public class UserFactory {
    private static final String DEFAULT_PASSWORD = "Abc@123456";
    private static final Faker faker;

    static {
        faker = new Faker();
    }

    public static User createDefault() {
        var user = new User();
        user.setemail(TimestampBuilder.buildUniqueTextByPrefix(faker.internet().safeEmailAddress()));
        user.setfullName(faker.name().fullName());
        user.setstoreName("Test");
        user.setphone(faker.phoneNumber().phoneNumber());

        user.setPassword(DEFAULT_PASSWORD);
        user.setPasswordConfirm(DEFAULT_PASSWORD);
        user.setregisterBusiness(true);
        return user;
    }
}
