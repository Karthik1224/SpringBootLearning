package com.example.ConnectDB.Controllers;


import com.example.ConnectDB.Models.Student;
import com.example.ConnectDB.RequestDTOs.StudentRequestDto;
import com.example.ConnectDB.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


       @PutMapping("/updateData")
       public ResponseEntity updateData(@RequestBody StudentRequestDto obj)
       {
              try {
                     String res = service.updateData(obj);
                     return new ResponseEntity(res,HttpStatus.OK);
              }
              catch(Exception e)
              {
                     return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
              }
       }


}
