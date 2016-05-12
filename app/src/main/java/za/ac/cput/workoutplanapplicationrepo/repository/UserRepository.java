package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.User;
/**
 *
 */
public interface UserRepository {
    void create(User user);
    User find(String screenName);
    void update (User user);
    void delete (User user);
}
