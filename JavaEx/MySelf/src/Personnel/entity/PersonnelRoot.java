package Personnel.entity;

import java.util.Arrays;

public class PersonnelRoot {
    Worker[] worker;
    Engineer[] engineer;
    Staff[] staff;

    public PersonnelRoot(Worker[] worker, Engineer[] engineer, Staff[] staff) {
        this.worker = worker;
        this.engineer = engineer;
        this.staff = staff;
    }

    public PersonnelRoot() {

    }

    public Worker[] getWorker() {
        return worker;
    }

    public void setWorker(Worker[] worker) {
        this.worker = worker;
    }

    public Engineer[] getEngineer() {
        return engineer;
    }

    public void setEngineer(Engineer[] engineer) {
        this.engineer = engineer;
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
                "worker:" + Arrays.toString(worker) +
                ", engineer:" + Arrays.toString(engineer) +
                ", staff:" + Arrays.toString(staff) +
                '}';
    }
}
