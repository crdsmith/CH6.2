package za.ac.cput.workoutplanapplicationrepo.domain;

import java.io.Serializable;

/**
 *
 */
public class GeneratedWorkoutSchedule implements Serializable {
    private int genNumberOfCycles;
    private int genScheduleID;
    private int genCycleIteration;

    public int getGenNumberOfCycles() {
        return genNumberOfCycles;
    }

    public void setGenNumberOfCycles(int genNumberOfCycles) {
        this.genNumberOfCycles = genNumberOfCycles;
    }

    public int getGenScheduleID() {
        return genScheduleID;
    }

    public void setGenScheduleID(int genScheduleID) {
        this.genScheduleID = genScheduleID;
    }

    public int getGenCycleIteration() {
        return genCycleIteration;
    }

    public void setGenCycleIteration(int genCycleIteration) {
        this.genCycleIteration = genCycleIteration;
    }

    public GeneratedWorkoutSchedule(Builder builder){
        this.genNumberOfCycles = builder.genNumberOfCycles;;
        this.genScheduleID = builder.genScheduleID;
        this.genCycleIteration = builder.genCycleIteration;
    }

    public static class Builder{
        private int genNumberOfCycles;
        private int genScheduleID;
        private int genCycleIteration;



        public Builder  genNumberOfCycles(int value) {
            this. genNumberOfCycles = value;
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


        public Builder copy(GeneratedWorkoutSchedule value) {
            this.genNumberOfCycles = value.genNumberOfCycles;
            this.genScheduleID = value.genScheduleID;
            this.genCycleIteration = value.genCycleIteration;
            return this;
        }

        public GeneratedWorkoutSchedule build(){
            return new GeneratedWorkoutSchedule(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneratedWorkoutSchedule generatedWorkoutSchedule = (GeneratedWorkoutSchedule ) o;

        return genScheduleID != 0 ? genScheduleID == (generatedWorkoutSchedule.genScheduleID) : generatedWorkoutSchedule.genScheduleID == 0;
    }

    @Override
    public int hashCode() {
        return genScheduleID != 0 ? genScheduleID.hashCode() : 0;
    }
}

