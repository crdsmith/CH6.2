package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.ShouldersWorkout;

/**
 *
 */
public interface ShouldersWorkoutService {
    void addShouldersWorkout(Context context, ShouldersWorkout shouldersWorkout);
    void updateShouldersWorkout(Context context, ShouldersWorkout shouldersWorkout);
}
