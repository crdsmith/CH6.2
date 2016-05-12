package za.ac.cput.workoutplanapplicationrepo.restapi.workout.resources;



import java.io.Serializable;


/**
 *
 */
public class AbdomenWorkoutResource implements Serializable{
    private String absWName;
    private int absWID;
    private String absWInfo;
    private String absWHint;
    private String absWTarget;

    public String getAbsWName() {
        return absWName;
    }

    public int getAbsWID() {
        return absWID;
    }

    public String getAbsWInfo() {
        return absWInfo;
    }

    public String getAbsWHint() {
        return absWHint;
    }

    public String getAbsWTarget() {
        return absWTarget;
    }

    public AbdomenWorkoutResource(Builder builder){
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

        public Builder copy(AbdomenWorkoutResource value) {
            this.absWName = value.absWName;
            this.absWID = value.absWID;
            this.absWInfo = value.absWInfo;
            this.absWHint = value.absWHint;
            this.absWTarget = value.absWTarget;
            return this;
        }

    public AbdomenWorkoutResource build(){
        return new AbdomenWorkoutResource(this);
    }
    }
}
