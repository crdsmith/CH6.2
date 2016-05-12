package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.domain.BackWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.BackWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class BackWorkoutServiceImpl extends IntentService implements BackWorkoutService {
    private static  BackWorkoutServiceImpl service = null;

    public static BackWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new BackWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private BackWorkoutServiceImpl() {
        super("BackWorkoutServiceImpl");

    }

    @Override
    public void addBackWorkout(Context context, BackWorkout backWorkout){
        Intent intent = new Intent(context, BackWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, backWorkout);
        context.startService(intent);
    }

    @Override
    public void updateBackWorkout(Context context, BackWorkout backWorkout){
        Intent intent = new Intent(context, BackWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, backWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final BackWorkout backWorkout = (BackWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final BackWorkout backWorkout = (BackWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}

