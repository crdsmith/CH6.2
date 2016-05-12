package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.ChestWorkout;

/**
 *
 */
public interface ChestWorkoutService {
    void addChestWorkout(Context context, ChestWorkout chestWorkout);
    void updateChestWorkout(Context context, ChestWorkout chestWorkout);
}
