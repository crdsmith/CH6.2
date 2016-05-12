package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.ButtocksWorkout;
/**
 *
 */
public interface ButtocksWorkoutRepository {
    void create(ButtocksWorkout buttocksWorkout);
    ButtocksWorkout find(int buttocksWID);
    void update (ButtocksWorkout buttocksWorkout);
    void delete (ButtocksWorkout buttocksWorkout);
}
