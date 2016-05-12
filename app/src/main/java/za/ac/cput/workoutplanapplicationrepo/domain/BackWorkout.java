package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class BackWorkout implements Serializable {
    private String backWName;
    private int backWID;
    private String backWInfo;
    private String backWHint;
    private String backWTarget;

    public String getBackWName() {
        return backWName;
    }

    public void setBackWName(String backWName) {
        this.backWName = backWName;
    }

    public int getBackWID() {
        return backWID;
    }

    public void setBackWID(int backWID) {
        this.backWID = backWID;
    }

    public String getBackWInfo() {
        return backWInfo;
    }

    public void setBackWInfo(String backWInfo) {
        this.backWInfo = backWInfo;
    }

    public String getBackWHint() {
        return backWHint;
    }

    public void setBackWHint(String backWHint) {
        this.backWHint = backWHint;
    }

    public String getBackWTarget() {
        return backWTarget;
    }

    public void setBackWTarget(String backWTarget) {
        this.backWTarget = backWTarget;
    }
}
