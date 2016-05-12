package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.BackWorkout;

/**
 *
 */
public interface BackWorkoutService {
    void addBackWorkout(Context context, BackWorkout backWorkout);
    void updateBackWorkout(Context context, BackWorkout backWorkout);
}
