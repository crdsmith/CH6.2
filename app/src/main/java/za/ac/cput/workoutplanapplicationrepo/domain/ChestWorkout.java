package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class ChestWorkout implements Serializable {
    private String chestWName;
    private int chestWID;
    private String chestWInfo;
    private String chestWHint;
    private String chestWTarget;

    public String getChestWName() {
        return chestWName;
    }

    public void setChestWName(String chestWName) {
        this.chestWName = chestWName;
    }

    public int getChestWID() {
        return chestWID;
    }

    public void setChestWID(int chestWID) {
        this.chestWID = chestWID;
    }

    public String getChestWInfo() {
        return chestWInfo;
    }

    public void setChestWInfo(String chestWInfo) {
        this.chestWInfo = chestWInfo;
    }

    public String getChestWHint() {
        return chestWHint;
    }

    public void setChestWHint(String chestWHint) {
        this.chestWHint = chestWHint;
    }

    public String getChestWTarget() {
        return chestWTarget;
    }

    public void setChestWTarget(String chestWTarget) {
        this.chestWTarget = chestWTarget;
    }
}
