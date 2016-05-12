package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.User;

/**
 *
 */
public interface UserService {
    String activateUserAccount(String email, String screenName, String password);
    boolean isUserAccountActivated();
    boolean deactivateUserAccount();
}
