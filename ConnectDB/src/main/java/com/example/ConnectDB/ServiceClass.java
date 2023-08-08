package com.example.ConnectDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceClass {

    @Autowired
    private RepositoryClass repostoryClass;
    public String addData(Student student)
    {
         repostoryClass.save(student);
        return "added successfully";
    }

    public Student getDataById(int id)
    {
        Optional<Student> res = repostoryClass.findById(id);
        Student ans = res.get();
        return ans;
    }

    public Iterable<Student> getAllStudentsData()
    {
        Iterable<Student> it = repostoryClass.findAll();
        return it;


    }

    public Student updateStudentData(Student student)
    {

        Student updateStudent = repostoryClass.findById(student.getId()).orElse(null);
        if(updateStudent != null)
        {
            updateStudent.setName(student.getName());
            updateStudent.setPlace(student.getPlace());
            return repostoryClass.save(updateStudent);
        }
        return null;
    }

    public String deleteUser(int id)
    {

           if(repostoryClass.existsById(id))
           {
               repostoryClass.deleteById(id);
               return "deleted";
           }
           else return "Not Found";
    }
}
