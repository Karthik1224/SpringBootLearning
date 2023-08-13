package com.example.ConnectDB.Controllers;


import com.example.ConnectDB.Models.Department;
import com.example.ConnectDB.Services.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class departmentController {

    @Autowired
    private departmentService service;

    @PostMapping("/addDeptData")
    public String addDeptData(@RequestBody Department department)
    {
        return service.addDeptData(department);
    }


    @PostMapping("/assignDeptToStudent")
    public ResponseEntity assignDeptToStudent(@RequestParam Integer rollNo, @RequestParam Integer id)
    {
         try {
             String res = service.assignDeptToStudent(rollNo,id);
             return new ResponseEntity(res, HttpStatus.OK);
         }
         catch (Exception e)
         {
             return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
         }
    }

}
