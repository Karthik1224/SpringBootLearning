package com.example.ConnectDB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClass extends CrudRepository<Student,Integer> {

    //public void addData(Student student);

}
