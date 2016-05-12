package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.LegsWorkout;
/**
 *
 */
public interface LegsWorkoutRepository {
    void create(LegsWorkout legsWorkout);
    LegsWorkout find(int legsWID);
    void update (LegsWorkout legsWorkout);
    void delete (LegsWorkout legsWorkout);
}
