package za.ac.cput.workoutplanapplicationrepo.repository;
import za.ac.cput.workoutplanapplicationrepo.domain.GeneratedWorkoutSchedule;
/**
 *
 */
public interface GeneratedWorkoutRepository {
    void create(GeneratedWorkoutSchedule generatedWorkout);
    GeneratedWorkoutSchedule find(int genScheduleID);
    void update (GeneratedWorkoutSchedule generatedWorkout);
    void delete (GeneratedWorkoutSchedule generatedWorkout);
}
