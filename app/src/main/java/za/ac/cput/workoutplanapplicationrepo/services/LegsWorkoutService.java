package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.LegsWorkout;

/**
 *
 */
public interface LegsWorkoutService {
    void addLegsWorkout(Context context, LegsWorkout legsWorkout);
    void updateLegsWorkout(Context context, LegsWorkout legsWorkout);
}
