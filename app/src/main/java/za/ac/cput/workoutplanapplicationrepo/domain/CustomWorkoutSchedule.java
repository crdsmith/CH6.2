package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class CustomWorkoutSchedule implements Serializable {
    private int custNumberOfCycles;
    private boolean randomWorkout;
    private int custScheduleID;
    private int custCycleIteration;

    public int getCustNumberOfCycles() {
        return custNumberOfCycles;
    }

    public void setCustNumberOfCycles(int custNumberOfCycles) {
        this.custNumberOfCycles = custNumberOfCycles;
    }

    public boolean isRandomWorkout() {
        return randomWorkout;
    }

    public void setRandomWorkout(boolean randomWorkout) {
        this.randomWorkout = randomWorkout;
    }

    public int getCustScheduleID() {
        return custScheduleID;
    }

    public void setCustScheduleID(int custScheduleID) {
        this.custScheduleID = custScheduleID;
    }

    public int getCustCycleIteration() {
        return custCycleIteration;
    }

    public void setCustCycleIteration(int custCycleIteration) {
        this.custCycleIteration = custCycleIteration;
    }
}
