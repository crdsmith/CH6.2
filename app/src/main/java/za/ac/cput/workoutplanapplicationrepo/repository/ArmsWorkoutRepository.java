package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.ArmsWorkout;
/**
 *
 */
public interface ArmsWorkoutRepository {
    void create(ArmsWorkout armsWorkout);
    ArmsWorkout find(int armsWID);
    void update (ArmsWorkout armsWorkout);
    void delete (ArmsWorkout armsWorkout);
}
