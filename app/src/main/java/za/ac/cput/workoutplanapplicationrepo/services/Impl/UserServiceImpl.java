package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;

import za.ac.cput.workoutplanapplicationrepo.config.util.App;
import za.ac.cput.workoutplanapplicationrepo.config.util.DomainState;
import za.ac.cput.workoutplanapplicationrepo.domain.User;
import za.ac.cput.workoutplanapplicationrepo.factory.user.UserFactory;
import za.ac.cput.workoutplanapplicationrepo.repository.Impl.UserRepositoryImpl;
import za.ac.cput.workoutplanapplicationrepo.repository.UserRepository;
import za.ac.cput.workoutplanapplicationrepo.services.UserService;

/**
 *
 */
/*Chose bound service because the state of the User profile needed to be returned*/
public class UserServiceImpl extends Service implements UserService {
    final private UserRepository userRepository;

    private static UserServiceImpl service = null;

    public static UserServiceImpl getInstance(){
        if(service == null)
            service = new UserServiceImpl();
        return service;
    }

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private UserRepository repo;

    private UserServiceImpl(){
        userRepository = new UserRepositoryImpl(App.getAppContext());
    }

    public IBinder onBind(Intent intent)
    {
        return localBinder;
    }



    public class ActivateServiceLocalBinder extends Binder{
        public UserServiceImpl getService(){
            return UserServiceImpl.this;
        }
    }

    @Override
    public String activateUserAccount(String email, String screenName, String password){
        if(true) {
            User user = UserFactory.getUser(email, screenName, password);
            return DomainState.ACTIVATED.name();
        }else{
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public boolean isUserAccountActivated() {
        return repo.findAll().size() > 0;
    }

    @Override
    public boolean deactivateUserAccount() {
        int rows = repo.deleteAll();
        return rows > 0;
    }

        private User createUser(User user) {
        repo = new UserRepositoryImpl(App.getAppContext());
            return repo.save(user);
        }





}
