package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.domain.ShouldersWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.ShouldersWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class ShouldersWorkoutServiceImpl extends IntentService implements ShouldersWorkoutService {
    private static   ShouldersWorkoutServiceImpl service = null;

    public static  ShouldersWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new  ShouldersWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private  ShouldersWorkoutServiceImpl() {
        super(" ShouldersWorkoutServiceImpl");

    }

    @Override
    public void addShouldersWorkout(Context context,  ShouldersWorkout shouldersWorkout){
        Intent intent = new Intent(context,  ShouldersWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD,  shouldersWorkout);
        context.startService(intent);
    }

    @Override
    public void updateShouldersWorkout(Context context,  ShouldersWorkout  shouldersWorkout){
        Intent intent = new Intent(context,  ShouldersWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE,  shouldersWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final  ShouldersWorkout  shouldersWorkout = ( ShouldersWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final  ShouldersWorkout  shouldersWorkout = ( ShouldersWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
