package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class AbdomenWorkout implements Serializable {
    private String absWName;
    private int absWID;
    private String absWInfo;
    private String absWHint;
    private String absWTarget;

    public AbdomenWorkout(){}

    public String getAbsWName() {
        return absWName;
    }

    public void setAbsWName(String absWName) {
        this.absWName = absWName;
    }

    public int getAbsWID() {
        return absWID;
    }

    public void setAbsWID(int absWID) {
        this.absWID = absWID;
    }

    public String getAbsWInfo() {
        return absWInfo;
    }

    public void setAbsWInfo(String absWInfo) {
        this.absWInfo = absWInfo;
    }

    public String getAbsWHint() {
        return absWHint;
    }

    public void setAbsWHint(String absWHint) {
        this.absWHint = absWHint;
    }

    public String getAbsWTarget() {
        return absWTarget;
    }

    public void setAbsWTarget(String absWTarget) {
        this.absWTarget = absWTarget;
    }

    public AbdomenWorkout(Builder builder){
        this.absWName = builder.absWName;
        this.absWID = builder.absWID;
        this.absWInfo = builder.absWInfo;
        this.absWHint = builder.absWHint;
        this.absWTarget = builder.absWTarget;
    }

    public static class Builder{
        private String absWName;
        private int absWID;
        private String absWInfo;
        private String absWHint;
        private String absWTarget;


        public Builder absWName(String value) {
            this.absWName = value;
            return this;
        }

        public Builder absWID(int value) {
            this.absWID = value;
            return this;
        }

        public Builder absWInfo(String value) {
            this.absWInfo = value;
            return this;
        }

        public Builder absWHint(String value) {
            this.absWHint = value;
            return this;
        }

        public Builder absWTarget(String value) {
            this.absWTarget = value;
            return this;
        }

        public Builder copy(AbdomenWorkout value) {
            this.absWName = value.absWName;
            this.absWID = value.absWID;
            this.absWInfo = value.absWInfo;
            this.absWHint = value.absWHint;
            this.absWTarget = value.absWTarget;
            return this;
        }

        public AbdomenWorkout build(){
            return new AbdomenWorkout(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbdomenWorkout  abdomenWorkout = (AbdomenWorkout ) o;

        return absWID != 0 ? absWID == abdomenWorkout .absWID : abdomenWorkout .absWID == 0;
    }

    @Override
    public int hashCode() {
        return absWID != 0 ? (absWID).hashCode(): 0;
    }
}
