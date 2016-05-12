package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.CustomWorkoutSchedule;
/**
 *
 */
public interface CustomWorkoutRepository {
    void create(CustomWorkoutSchedule customWorkout);
    CustomWorkoutSchedule find(int custScheduleID);
    void update (CustomWorkoutSchedule customWorkout);
    void delete (CustomWorkoutSchedule customWorkout);
}
