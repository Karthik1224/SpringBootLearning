package com.example.ConnectDB.Services;

import com.example.ConnectDB.Models.Student;
import com.example.ConnectDB.Repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class studentService {


    @Autowired
    private studentRepository repository;

    public String addStudentData(Student student)
    {
         Integer rollNo = student.getRollNo();
         if(repository.existsById(rollNo))
         {
             return "student already exits";
         }
         else
         {
             repository.save(student);
             return "student added successfully";
         }
    }

    public String deleteData(Integer id)
    {
        if(!repository.existsById(id))
        {
            return "Invalid id";
        }
        else {

            repository.deleteById(id);
            return "deleted Successfully";
        }
    }
}
