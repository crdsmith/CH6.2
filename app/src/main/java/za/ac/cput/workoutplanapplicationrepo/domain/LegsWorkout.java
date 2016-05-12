package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class LegsWorkout implements Serializable {
    private String legsWName;
    private int legsWID;
    private String legsWInfo;
    private String legsWHint;
    private String legsWTarget;

    public String getLegsWName() {
        return legsWName;
    }

    public void setLegsWName(String legsWName) {
        this.legsWName = legsWName;
    }

    public int getLegsWID() {
        return legsWID;
    }

    public void setLegsWID(int legsWID) {
        this.legsWID = legsWID;
    }

    public String getLegsWInfo() {
        return legsWInfo;
    }

    public void setLegsWInfo(String legsWInfo) {
        this.legsWInfo = legsWInfo;
    }

    public String getLegsWHint() {
        return legsWHint;
    }

    public void setLegsWHint(String legsWHint) {
        this.legsWHint = legsWHint;
    }

    public String getLegsWTarget() {
        return legsWTarget;
    }

    public void setLegsWTarget(String legsWTarget) {
        this.legsWTarget = legsWTarget;
    }
}
