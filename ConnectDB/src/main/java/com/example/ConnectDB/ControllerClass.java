package com.example.ConnectDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerClass {

    @Autowired
   private ServiceClass serviceClass;
    @PostMapping("/addStudentData")
    public String addStudentData(@RequestBody Student student)
    {
       return serviceClass.addData(student);
    }

    @GetMapping("/getStudentData")
    public Student getDataById(@RequestParam Integer id)
    {
        return  serviceClass.getDataById(id);

    }

    @GetMapping("/getAllStudentsData")
    public Iterable<Student> getAllStudentData()
    {
        return serviceClass.getAllStudentsData();
    }

    @PutMapping("/updateUser")
    public Student updateStudentData(@RequestBody Student student)
    {

        return serviceClass.updateStudentData(student);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id)
    {
        return serviceClass.deleteUser(id);
    }
}
