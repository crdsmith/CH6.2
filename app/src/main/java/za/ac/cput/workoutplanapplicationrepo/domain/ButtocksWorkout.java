package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class ButtocksWorkout implements Serializable {
    private String buttocksWName;
    private int buttocksWID;
    private String buttocksWInfo;
    private String buttocksWHint;
    private String buttocksWTarget;

    public String getButtocksWName() {
        return buttocksWName;
    }

    public void setButtocksWName(String buttocksWName) {
        this.buttocksWName = buttocksWName;
    }

    public int getButtocksWID() {
        return buttocksWID;
    }

    public void setButtocksWID(int buttocksWID) {
        this.buttocksWID = buttocksWID;
    }

    public String getButtocksWInfo() {
        return buttocksWInfo;
    }

    public void setButtocksWInfo(String buttocksWInfo) {
        this.buttocksWInfo = buttocksWInfo;
    }

    public String getButtocksWHint() {
        return buttocksWHint;
    }

    public void setButtocksWHint(String buttocksWHint) {
        this.buttocksWHint = buttocksWHint;
    }

    public String getButtocksWTarget() {
        return buttocksWTarget;
    }

    public void setButtocksWTarget(String buttocksWTarget) {
        this.buttocksWTarget = buttocksWTarget;
    }
}
