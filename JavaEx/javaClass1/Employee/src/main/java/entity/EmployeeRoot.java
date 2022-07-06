package entity;

import java.util.Arrays;

public class EmployeeRoot {
    Engineer[] engineers;
    Worker[] workers;
    Staff[] staff;

    public EmployeeRoot(Engineer[] engineers, Worker[] workers, Staff[] staff) {
        this.engineers = engineers;
        this.workers = workers;
        this.staff = staff;
    }
    public EmployeeRoot(){}

    public Engineer[] getEngineers() {
        return engineers;
    }

    public void setEngineers(Engineer[] engineers) {
        this.engineers = engineers;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public Staff[] getStaff() {
        return staff;
    }

    public void setStaff(Staff[] staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "PersonnelRoot{" +
                "worker:" + Arrays.toString(workers) +
                ", engineer:" + Arrays.toString(engineers) +
                ", staff:" + Arrays.toString(staff) +
                '}';
    }
}
