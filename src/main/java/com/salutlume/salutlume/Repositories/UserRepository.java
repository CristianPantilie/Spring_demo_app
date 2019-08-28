package com.salutlume.salutlume.Repositories;

//import com.salutlume.salutlume.UserStuff.User;
//import org.springframework.data.repository.CrudRepository;

import com.salutlume.salutlume.UserStuff.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
