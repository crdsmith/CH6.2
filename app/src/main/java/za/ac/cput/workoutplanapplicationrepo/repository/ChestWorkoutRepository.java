package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.ChestWorkout;
/**
 *
 */
public interface ChestWorkoutRepository {
    void create(ChestWorkout chestWorkout);
    ChestWorkout find(int chestWID);
    void update (ChestWorkout chestWorkout);
    void delete (ChestWorkout chestWorkout);
}
