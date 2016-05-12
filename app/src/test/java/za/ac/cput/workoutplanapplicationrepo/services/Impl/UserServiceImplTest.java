package za.ac.cput.workoutplanapplicationrepo.services.Impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import za.ac.cput.workoutplanapplicationrepo.config.util.App;

import static org.junit.Assert.*;

/**
 *
 */
public class UserServiceImplTest extends AndroidTestCase{
    private UserServiceImpl userService;
    private boolean isBound;


public void setUp() throws Exception{
   super.setUp();
    Intent intent = new Intent(App.getAppContext(), UserServiceImpl.class);
    App.getAppContext().bindService(intent, connect, Context.BIND_AUTO_CREATE);
}

    private ServiceConnection connect = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName name, IBinder service){
            UserServiceImpl.ActivateServiceLocalBinder binder = (UserServiceImpl.ActivateServiceLocalBinder) service;

            userService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name){
            isBound = false;
        }
    };

    public void testActivateUserAccount() throws Exception{

    }

    public void testIsUserAccountActivated() throws Exception{
        Boolean activatedAcc = userService.isUserAccountActivated();
        Assert.assertTrue("ACTIVATED",activatedAcc);
    }

    public void testDeactivateUserAccount() throws Exception{
        Boolean activatedAcc = userService.deactivateUserAccount();
        Assert.assertTrue("DEACTIVATED",activatedAcc);
    }

}