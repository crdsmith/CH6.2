package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.domain.ChestWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.ChestWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class ChestWorkoutServiceImpl extends IntentService implements ChestWorkoutService {
    private static  ChestWorkoutServiceImpl service = null;

    public static ChestWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new ChestWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private ChestWorkoutServiceImpl() {
        super("ChestWorkoutServiceImpl");

    }

    @Override
    public void addChestWorkout(Context context, ChestWorkout chestWorkout){
        Intent intent = new Intent(context, ChestWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, chestWorkout);
        context.startService(intent);
    }

    @Override
    public void updateChestWorkout(Context context, ChestWorkout chestWorkout){
        Intent intent = new Intent(context, ChestWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, chestWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final ChestWorkout chestWorkout = (ChestWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final ChestWorkout chestWorkout = (ChestWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
