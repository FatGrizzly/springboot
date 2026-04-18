package com.example.reactdemo;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection="students")
public class Student {
    @Id
    private String id;
    private String name;

    private String idNumber;

    private String address;

    private String phone;

    private String purpose;

    private String personToMeet;

    private int entryHour;

    private int entryMinute;

    private int exitHour;

    private int exitMinute;
}
