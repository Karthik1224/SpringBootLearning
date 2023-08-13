package com.example.ConnectDB.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Integer rollNo;
    private String name;
    private String place;


    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL)
    private Department department;
}
