package com.example.syedinkisarahmed.helloworld;

/**
 * Created by Bakhtiyar on 11/1/2016.
 */
public class RecordForRead {
    String name;
    String subName;
    int totalMarks;
    int gainMarks;
    String id;

    public RecordForRead(String id,String name, String subName, int totalMarks, int gainMarks) {
        this.id =id;
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

    public String getMarks(){


        return gainMarks +" / "+totalMarks;
    }
}
