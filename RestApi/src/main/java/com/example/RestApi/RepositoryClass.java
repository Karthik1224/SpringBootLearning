package com.example.RestApi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class RepositoryClass {

     HashMap<Integer, List<Travel>> travelHashMap = new HashMap<>();

     public String addTravelItem(Travel item)
     {
          int pk = item.getId();

          List<Travel> travelItem = travelHashMap.getOrDefault(pk,new ArrayList<>());
          travelItem.add(item);
          travelHashMap.put(pk,travelItem);
          return "item added successfully";
     }
     public List<Travel> getTravelList(Integer id)
     {
          return travelHashMap.getOrDefault(id,new ArrayList<>());
     }

}
