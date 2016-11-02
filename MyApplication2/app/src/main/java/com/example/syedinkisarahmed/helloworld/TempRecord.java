package com.example.syedinkisarahmed.helloworld;

/**
 * Created by Bakhtiyar on 10/31/2016.
 */
public class TempRecord {
    private String name;
    private String subName;
    private int totalMarks;
    private int gainMarks;
    String id;


    public TempRecord(String name, String subName, int totalMarks, int gainMarks, String id) {
        this.name = name;
        this.subName = subName;
        this.totalMarks = totalMarks;
        this.gainMarks = gainMarks;
        this.id = id;
    }

    public TempRecord(String name, String subName, int totalMarks, int gainMarks) {
        this.name = name;
        this.subName = subName;
        this.totalMarks = totalMarks;
        this.gainMarks = gainMarks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return subName;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public int getGainMarks() {
        return gainMarks;
    }
}
