package com.example.ConnectDB.Controllers;


import com.example.ConnectDB.Models.Student;
import com.example.ConnectDB.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class studentController {

       @Autowired
       private studentService service;
       @PostMapping("/addStudentData")
       public String addStudentData(@RequestBody Student student)
       {
           return service.addStudentData(student);
       }

       @DeleteMapping("/deleteData")
       public String deleteData(@RequestParam Integer id)
       {
              return service.deleteData(id);
       }




}
