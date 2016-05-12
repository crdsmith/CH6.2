package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;


import za.ac.cput.workoutplanapplicationrepo.domain.CustomWorkoutSchedule;
import za.ac.cput.workoutplanapplicationrepo.services.CustomWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class CustomWorkoutServiceImpl extends IntentService implements CustomWorkoutService {
    private static  CustomWorkoutServiceImpl service = null;

    public static CustomWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new CustomWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private CustomWorkoutServiceImpl() {
        super("CustomWorkoutServiceImpl");

    }

    @Override
    public void addCustomWorkoutSchedule(Context context, CustomWorkoutSchedule customWorkoutSchedule){
        Intent intent = new Intent(context, CustomWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, customWorkoutSchedule);
        context.startService(intent);
    }

    @Override
    public void updateCustomWorkoutSchedule(Context context, CustomWorkoutSchedule customWorkoutSchedule){
        Intent intent = new Intent(context, CustomWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, customWorkoutSchedule);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final CustomWorkoutSchedule customWorkoutSchedule = (CustomWorkoutSchedule) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final CustomWorkoutSchedule customWorkoutSchedule = (CustomWorkoutSchedule) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }
}
