package com.example.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/travel")
public class ControllerClass {


    @Autowired
    private ServiceClass serviceClass;
    @PostMapping("/addTravelItem")
    public  String addTravelItem(@RequestBody Travel item)
    {
        String ans = serviceClass.addTravelItem(item);
        return ans;
    }

    @GetMapping("/getTravelList")
    public List<String> getTravelList(@RequestParam("id") Integer id)
    {

        return serviceClass.getTravelList(id);
    }
}
