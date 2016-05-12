package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.GeneratedWorkoutSchedule;
/**
 *
 */
public interface GeneratedWorkoutService {
    void addGeneratedWorkoutSchedule(Context context, GeneratedWorkoutSchedule generatedWorkoutSchedule);
    void resetGeneratedWorkoutSchedule(Context context);
}
