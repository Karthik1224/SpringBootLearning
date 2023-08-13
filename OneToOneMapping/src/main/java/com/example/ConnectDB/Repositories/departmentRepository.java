package com.example.ConnectDB.Repositories;

import com.example.ConnectDB.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepository extends JpaRepository<Department,Integer> {
}
