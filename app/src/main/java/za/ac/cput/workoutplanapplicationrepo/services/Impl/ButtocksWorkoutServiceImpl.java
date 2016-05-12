package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.domain.ButtocksWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.ButtocksWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class ButtocksWorkoutServiceImpl extends IntentService implements ButtocksWorkoutService {
    private static  ButtocksWorkoutServiceImpl service = null;

    public static ButtocksWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new ButtocksWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private ButtocksWorkoutServiceImpl() {
        super("ButtocksWorkoutServiceImpl");

    }

    @Override
    public void addButtocksWorkout(Context context, ButtocksWorkout buttocksWorkout){
        Intent intent = new Intent(context, ButtocksWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, buttocksWorkout);
        context.startService(intent);
    }

    @Override
    public void updateButtocksWorkout(Context context, ButtocksWorkout buttocksWorkout){
        Intent intent = new Intent(context, ButtocksWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, buttocksWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final ButtocksWorkout buttocksWorkout = (ButtocksWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final ButtocksWorkout buttocksWorkout = (ButtocksWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
