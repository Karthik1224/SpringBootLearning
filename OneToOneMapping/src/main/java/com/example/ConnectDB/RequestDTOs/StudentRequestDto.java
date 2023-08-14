package com.example.ConnectDB.RequestDTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRequestDto {

    private Integer rollNo;
    private String newName;
    private String newPlace;
}
