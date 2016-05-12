package za.ac.cput.workoutplanapplicationrepo.services.Impl;


import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import za.ac.cput.workoutplanapplicationrepo.config.util.App;
import za.ac.cput.workoutplanapplicationrepo.domain.AbdomenWorkout;
import za.ac.cput.workoutplanapplicationrepo.services.AbdomenWorkoutService;
import za.ac.cput.workoutplanapplicationrepo.repository.Impl.AbdomenWorkoutRepoImpl;
/**
 *
 */
/*Chose intent service because it will not be bound to any activity and needs to stop when it finished the work*/
public class AbdomenWorkoutServiceImpl extends IntentService implements AbdomenWorkoutService{
    //private final AbdomenWorkoutRepository abdomenWorkoutRepository;
    private static  AbdomenWorkoutServiceImpl service = null;

    public static AbdomenWorkoutServiceImpl getInstance(){
        if(service == null)
            service = new AbdomenWorkoutServiceImpl();
        return service;
    }

    private static final String ACTION_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.ADD";
    private static final String ACTION_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "za.ac.cput.workoutplanapplicationrepo.services.Impl.extra.UPDATE";



    private AbdomenWorkoutServiceImpl() {
        super("AbdomenWorkoutServiceImpl");

    }

    @Override
    public void addAbdomenWorkout(Context context, AbdomenWorkout abdomenWorkout){
        Intent intent = new Intent(context, AbdomenWorkoutServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, abdomenWorkout);
        context.startService(intent);
    }

    @Override
    public void updateAbdomenWorkout(Context context, AbdomenWorkout abdomenWorkout){
        Intent intent = new Intent(context, AbdomenWorkoutServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, abdomenWorkout);
        context.startService(intent);
    }

   @Override
   protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final AbdomenWorkout abdomenWorkout = (AbdomenWorkout) intent.getSerializableExtra(EXTRA_ADD);
            } else if (ACTION_UPDATE.equals(action)) {
                final AbdomenWorkout abdomenWorkout = (AbdomenWorkout) intent.getSerializableExtra(EXTRA_UPDATE);
            }
        }
    }

   /*@Override
   protected void onHandleIntent(Intent intent){
       AbdomenWorkoutResource abdomenWorkoutResource = (AbdomenWorkoutResource)intent.getSerializableExtra(EXTRA_ADD);
       AbdomenWorkout abdomenWorkout = new AbdomenWorkout.Builder()
               .absWName(abdomenWorkoutResource.getAbsWName())
                .absWID(abdomenWorkoutResource.getAbsWID())
                .absWInfo(abdomenWorkoutResource.getAbsWInfo())
                .absWHint(abdomenWorkoutResource.getAbsWHint())
                . absWTarget(abdomenWorkoutResource.getAbsWTarget())
                .build();
       abdomenWorkoutRepository.save(abdomenWorkout);
    }*/
}
