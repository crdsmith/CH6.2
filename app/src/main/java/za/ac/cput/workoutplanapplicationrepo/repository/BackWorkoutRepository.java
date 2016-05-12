package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.BackWorkout;
/**
 *
 */
public interface BackWorkoutRepository {
    void create(BackWorkout backWorkout);
    BackWorkout find(int backWID);
    void update (BackWorkout backWorkout);
    void delete (BackWorkout backWorkout);
}
