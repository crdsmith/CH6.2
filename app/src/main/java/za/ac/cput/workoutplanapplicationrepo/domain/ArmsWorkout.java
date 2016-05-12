package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class ArmsWorkout implements Serializable {
    private String armsWName;
    private int armsWID;
    private String armsWInfo;
    private String armsWHint;
    private String armsWTarget;

    public String getArmsWName() {
        return armsWName;
    }

    public void setArmsWName(String armsWName) {
        this.armsWName = armsWName;
    }

    public int getArmsWID() {
        return armsWID;
    }

    public void setArmsWID(int armsWID) {
        this.armsWID = armsWID;
    }

    public String getArmsWInfo() {
        return armsWInfo;
    }

    public void setArmsWInfo(String armsWInfo) {
        this.armsWInfo = armsWInfo;
    }

    public String getArmsWHint() {
        return armsWHint;
    }

    public void setArmsWHint(String armsWHint) {
        this.armsWHint = armsWHint;
    }

    public String getArmsWTarget() {
        return armsWTarget;
    }

    public void setArmsWTarget(String armsWTarget) {
        this.armsWTarget = armsWTarget;
    }
}
