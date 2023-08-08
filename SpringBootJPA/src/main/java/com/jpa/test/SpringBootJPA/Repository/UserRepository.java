package com.jpa.test.SpringBootJPA.Repository;

import com.jpa.test.SpringBootJPA.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends  CrudRepository<User,Integer> {


}
