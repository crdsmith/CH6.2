package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class ShouldersWorkout implements Serializable {
    private String shouldersWName;
    private int shouldersWID;
    private String shouldersWInfo;
    private String shouldersWHint;
    private String shouldersWTarget;

    public String getShouldersWName() {
        return shouldersWName;
    }

    public void setShouldersWName(String shouldersWName) {
        this.shouldersWName = shouldersWName;
    }

    public int getShouldersWID() {
        return shouldersWID;
    }

    public void setShouldersWID(int shouldersWID) {
        this.shouldersWID = shouldersWID;
    }

    public String getShouldersWInfo() {
        return shouldersWInfo;
    }

    public void setShouldersWInfo(String shouldersWInfo) {
        this.shouldersWInfo = shouldersWInfo;
    }

    public String getShouldersWHint() {
        return shouldersWHint;
    }

    public void setShouldersWHint(String shouldersWHint) {
        this.shouldersWHint = shouldersWHint;
    }

    public String getShouldersWTarget() {
        return shouldersWTarget;
    }

    public void setShouldersWTarget(String shouldersWTarget) {
        this.shouldersWTarget = shouldersWTarget;
    }
}
