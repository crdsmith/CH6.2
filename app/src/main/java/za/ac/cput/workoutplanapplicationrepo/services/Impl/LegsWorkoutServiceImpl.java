package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.domain.LegsWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.LegsWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class LegsWorkoutServiceImpl extends IntentService implements LegsWorkoutService {
    private static  LegsWorkoutServiceImpl service = null;

    public static LegsWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new LegsWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private LegsWorkoutServiceImpl() {
        super("LegsWorkoutServiceImpl");

    }

    @Override
    public void addLegsWorkout(Context context, LegsWorkout legsWorkout){
        Intent intent = new Intent(context, LegsWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, legsWorkout);
        context.startService(intent);
    }

    @Override
    public void updateLegsWorkout(Context context, LegsWorkout legsWorkout){
        Intent intent = new Intent(context, LegsWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, legsWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final LegsWorkout legsWorkout = (LegsWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final LegsWorkout legsWorkout = (LegsWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
