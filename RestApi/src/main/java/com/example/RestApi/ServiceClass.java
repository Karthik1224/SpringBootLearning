package com.example.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClass {

    @Autowired
    private RepositoryClass repositoryClass;
    public String addTravelItem(Travel item)
    {
        return repositoryClass.addTravelItem(item);
    }

    public List<String> getTravelList(Integer id)
    {
        List<Travel> travelList = repositoryClass.getTravelList(id);

        List<String>places = new ArrayList<>();
        for(Travel travel:travelList)
        {
            places.add(travel.getPlace());
        }
        return places;



    }
}
