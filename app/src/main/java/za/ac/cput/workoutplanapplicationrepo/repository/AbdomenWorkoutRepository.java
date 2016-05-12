package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.AbdomenWorkout;
/**
 *
 */
public interface AbdomenWorkoutRepository {
    void create(AbdomenWorkout abdomenWorkout);
    AbdomenWorkout find(int absWID);
    void update (AbdomenWorkout abdomenWorkout);
    void delete (AbdomenWorkout abdomenWorkout);
}
