package com.example.ConnectDB.Services;

import com.example.ConnectDB.Models.Department;
import com.example.ConnectDB.Models.Student;
import com.example.ConnectDB.Repositories.departmentRepository;
import com.example.ConnectDB.Repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class departmentService {

    @Autowired
    private departmentRepository repository;


    @Autowired
    private studentRepository repo;

    public String addDeptData(Department department)
    {
        Integer id = department.getDeptId();
        if(repository.existsById(id))
        {
            return "department data already exits";
        }
        else
        {
            repository.save(department);
            return "department added successfully";
        }
    }

    public String assignDeptToStudent(Integer rollNo,Integer id) throws Exception
    {
         if(!repo.existsById(rollNo))
         {
             return "Invalid rollNo";
         }

         if(!repository.existsById(id))
         {
             return "Invalid deptId";
         }

        Optional<Student> student = repo.findById(rollNo);

        Optional<Department> department = repository.findById(id);

        Student studentObj = student.get();
        Department departmentObj = department.get();

        departmentObj.setStudent(studentObj);
        studentObj.setDepartment(departmentObj);

        repo.save(studentObj);
        return "assigned successfully";


    }

}
