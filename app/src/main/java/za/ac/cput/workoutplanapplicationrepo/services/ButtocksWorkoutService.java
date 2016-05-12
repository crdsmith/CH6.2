package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.ButtocksWorkout;

/**
 *
 */
public interface ButtocksWorkoutService {
    void addButtocksWorkout(Context context, ButtocksWorkout buttocksWorkout);
    void updateButtocksWorkout(Context context, ButtocksWorkout buttocksWorkout);
}
