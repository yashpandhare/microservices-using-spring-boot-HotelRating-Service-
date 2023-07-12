// to perform database operations on entity
package com.lcwd.user.service.repositories;

import com.lcwd.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {  //User is ENTITY here and String is type of primary key/id
    //if you want to implement any custom method or query
    //write here

}
