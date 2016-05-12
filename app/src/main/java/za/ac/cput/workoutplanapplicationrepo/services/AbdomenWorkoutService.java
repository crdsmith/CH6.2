package za.ac.cput.workoutplanapplicationrepo.services;

import android.content.Context;

import za.ac.cput.workoutplanapplicationrepo.domain.AbdomenWorkout;

/**
 *
 */
public interface AbdomenWorkoutService {
    void addAbdomenWorkout(Context context, AbdomenWorkout abdomenWorkout);
    void updateAbdomenWorkout(Context context, AbdomenWorkout abdomenWorkout);
}
