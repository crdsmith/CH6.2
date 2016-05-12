package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.ArmsWorkout;

/**
 *
 */
public interface ArmsWorkoutService {
    void addArmsWorkout(Context context, ArmsWorkout armsWorkout);
    void updateArmsWorkout(Context context, ArmsWorkout armsWorkout);
}
