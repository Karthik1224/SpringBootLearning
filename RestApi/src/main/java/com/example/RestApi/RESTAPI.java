package com.example.RestApi;
import java.util.*;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RESTAPI {

    @GetMapping("/restapi")
    public String fun()
    {
        return "Welcome to the springboot";
    }

    HashMap<Integer,User> userDB = new HashMap<>();
    @PostMapping("/signUP")
    public String userData(@RequestBody User user)
    {
        int pk = user.getUserId();
        userDB.put(pk,user);
        return "User with name"+user.getName()+"has been added to DB";
    }

    @GetMapping("/getUserById")
    public User findUserById(@RequestParam("userId")Integer userId)
    {
        User user = userDB.get(userId);
        return user;
    }


    @GetMapping("/getUsersList/{country}")
    public List<User> getListOfUsers(@PathVariable ("country")String country)
    {
        List<User> usersList = new ArrayList<>();

        for(User user:userDB.values())
        {
            if(user.getCountry().equals(country))
            {
                usersList.add(user);
            }
        }
        return usersList;

    }

    @PutMapping("/updateUser")
    public String updateUserInfo(@RequestBody User userDetails,@RequestParam("userId")Integer userId)
    {
        int pk = userDetails.getUserId();
        userDB.put(pk,userDetails);
        return "Updated Successfully";
    }

    @DeleteMapping("/deleteUser/{name}")
    public String deleteUserDetails(@PathVariable("name")String name)
    {

        for(int key:userDB.keySet())
        {
           User user = userDB.get(key);
           if(user.getName().equals(name))
           {
               userDB.remove(key);
           }
        }

        return "Deleted Successfully with user name "+name;
    }
}
