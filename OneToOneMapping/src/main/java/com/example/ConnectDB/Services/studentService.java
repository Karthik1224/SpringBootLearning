package com.example.ConnectDB.Services;

import com.example.ConnectDB.Models.Student;
import com.example.ConnectDB.Repositories.studentRepository;
import com.example.ConnectDB.RequestDTOs.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

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


    public String updateData(StudentRequestDto obj)throws Exception
    {
        Optional<Student>studentOptional = repository.findById(obj.getRollNo());
        if(!studentOptional.isPresent())
        {
            throw new Exception ("Invalid roll No");
        }

        Student studentObj = studentOptional.get();

        studentObj.setName(obj.getNewName());
        studentObj.setPlace(obj.getNewPlace());

        repository.save(studentObj);
        return "updated successfylly";
    }
}
