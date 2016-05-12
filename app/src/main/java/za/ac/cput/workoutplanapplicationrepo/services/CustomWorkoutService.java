package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.CustomWorkoutSchedule;
/**
 *
 */
public interface CustomWorkoutService {
    void addCustomWorkoutSchedule(Context context, CustomWorkoutSchedule customWorkoutScedule);
    void updateCustomWorkoutSchedule(Context context, CustomWorkoutSchedule customWorkoutScedule);
}
