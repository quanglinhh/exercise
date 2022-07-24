package com.example.studentspringboot.dto;

public class TblSubjectCount {
    private int sem;
    private long slg;

    public TblSubjectCount(int sem, long slg) {
        this.sem = sem;
        this.slg = slg;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public long getSlg() {
        return slg;
    }

    public void setSlg(long slg) {
        this.slg = slg;
    }
}
