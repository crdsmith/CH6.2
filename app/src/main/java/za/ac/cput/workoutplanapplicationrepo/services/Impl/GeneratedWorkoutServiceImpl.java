package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.config.util.App;
import za.ac.cput.workoutplanapplicationrepo.domain.GeneratedWorkoutSchedule;
import za.ac.cput.workoutplanapplicationrepo.repository.GeneratedWorkoutRepository;
import za.ac.cput.workoutplanapplicationrepo.repository.Impl.CustomWorkoutRepoImpl;
import za.ac.cput.workoutplanapplicationrepo.repository.Impl.GeneratedWorkoutRepoImpl;
import za.ac.cput.workoutplanapplicationrepo.restapi.workout.resources.GeneratedWorkoutResourse;
import za.ac.cput.workoutplanapplicationrepo.services.GeneratedWorkoutService;

/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class GeneratedWorkoutServiceImpl extends IntentService implements GeneratedWorkoutService {
    private final GeneratedWorkoutRepository repository;
    private static  GeneratedWorkoutServiceImpl service = null;

    public static GeneratedWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new GeneratedWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_RESET = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";




    private GeneratedWorkoutServiceImpl() {
        super("GeneratedWorkoutServiceImpl");
        repository = new GeneratedWorkoutRepoImpl(App.getAppContext());
    }

    @Override
    public void addGeneratedWorkoutSchedule(Context context, GeneratedWorkoutSchedule generatedWorkoutSchedule){
        Intent intent = new Intent(context, GeneratedWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, generatedWorkoutSchedule);
        context.startService(intent);
    }

    @Override
    public void resetGeneratedWorkoutSchedule(Context context){
        Intent intent = new Intent(context, GeneratedWorkoutServiceImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final GeneratedWorkoutResourse generatedWorkoutResourse = (GeneratedWorkoutResourse) intent.getSerializableExtra(EXTRA_ADD);
                saveGeneratedWorkoutSchedule(generatedWorkoutResourse);
            } else if (ACTION_RESET.equals(action)) {
                resetGeneratedWorkoutSchedule();
            }
        }
    }

    private void  resetGeneratedWorkoutSchedule(){
        repository.deleteAll();
    }

    private void saveGeneratedWorkoutSchedule(GeneratedWorkoutResourse generatedWorkoutResourse){
        GeneratedWorkoutSchedule generatedWorkoutSchedule = new GeneratedWorkoutSchedule.Builder()
                .genNumberOfCycles(generatedWorkoutResourse.getGenNumberOfCycles())
                .genScheduleID(generatedWorkoutResourse.getGenScheduleID())
                .genCycleIteration(generatedWorkoutResourse.getGenCycleIteration())
                .build();
        GeneratedWorkoutSchedule saveGeneratedWorkoutSchedule = repository.save(generatedWorkoutSchedule);

    }
}
