package com.salutlume.salutlume.Repositories;

import com.salutlume.salutlume.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
