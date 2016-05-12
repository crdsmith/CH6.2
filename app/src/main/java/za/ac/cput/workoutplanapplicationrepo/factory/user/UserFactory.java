package za.ac.cput.workoutplanapplicationrepo.factory.user;

import za.ac.cput.workoutplanapplicationrepo.domain.User;

/**
 *
 */
public class UserFactory {
    public static User getUser(String email, String screenName, String password){
        return new User.Builder()
                .email(email)
                .screenName(screenName)
                .password(password)
                .build();
    }
}
