package com.example.ConnectDB.Repositories;

import com.example.ConnectDB.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface studentRepository extends JpaRepository<Student,Integer> {
}
