package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.ShouldersWorkout;
/**
 *
 */
public interface ShouldersWorkoutRepository {
    void create(ShouldersWorkout shouldersWorkout);
    ShouldersWorkout find(int shouldersWID);
    void update (ShouldersWorkout shouldersWorkout);
    void delete (ShouldersWorkout shouldersWorkout);
}
