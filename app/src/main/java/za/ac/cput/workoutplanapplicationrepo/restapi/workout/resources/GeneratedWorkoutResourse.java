package za.ac.cput.workoutplanapplicationrepo.restapi.workout.resources;

import java.io.Serializable;

/**
 *
 */
public class GeneratedWorkoutResourse implements Serializable {
    private int genNumberOfCycles;
    private int genScheduleID;
    private int genCycleIteration;

    public int getGenNumberOfCycles() {
        return genNumberOfCycles;
    }

    public int getGenScheduleID() {
        return genScheduleID;
    }

    public int getGenCycleIteration() {
        return genCycleIteration;
    }

    public GeneratedWorkoutResourse(Builder builder) {
        this.genNumberOfCycles = builder.genNumberOfCycles;
        ;
        this.genScheduleID = builder.genScheduleID;
        this.genCycleIteration = builder.genCycleIteration;
    }

    public static class Builder {
        private int genNumberOfCycles;
        private int genScheduleID;
        private int genCycleIteration;


        public Builder genNumberOfCycles(int value) {
            this.genNumberOfCycles = value;
            return this;
        }

        public Builder genScheduleID(int value) {
            this.genScheduleID = value;
            return this;
        }

        public Builder genCycleIteration(int value) {
            this.genCycleIteration = value;
            return this;
        }


        public Builder copy(GeneratedWorkoutResourse value) {
            this.genNumberOfCycles = value.genNumberOfCycles;
            this.genScheduleID = value.genScheduleID;
            this.genCycleIteration = value.genCycleIteration;
            return this;
        }

        public GeneratedWorkoutResourse build() {
            return new GeneratedWorkoutResourse(this);
        }

    }
}



