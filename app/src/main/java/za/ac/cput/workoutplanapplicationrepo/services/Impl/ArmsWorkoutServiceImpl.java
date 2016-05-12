package za.ac.cput.workoutplanapplicationrepo.services.Impl;


import android.app.IntentService;
import android.content.Intent;
import android.content.Context;


import za.ac.cput.workoutplanapplicationrepo.domain.ArmsWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.ArmsWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class ArmsWorkoutServiceImpl extends IntentService implements ArmsWorkoutService {
    private static  ArmsWorkoutServiceImpl service = null;

    public static ArmsWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new ArmsWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private ArmsWorkoutServiceImpl() {
        super("ArmsWorkoutServiceImpl");

    }

    @Override
    public void addArmsWorkout(Context context, ArmsWorkout armsWorkout){
        Intent intent = new Intent(context, ArmsWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, armsWorkout);
        context.startService(intent);
    }

    @Override
    public void updateArmsWorkout(Context context, ArmsWorkout armsWorkout){
        Intent intent = new Intent(context, ArmsWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, armsWorkout);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final ArmsWorkout armsWorkout = (ArmsWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final ArmsWorkout armsWorkout = (ArmsWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
