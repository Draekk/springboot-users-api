package com.draekk.springboot.springbootusersapi.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.draekk.springboot.springbootusersapi.models.User;

public class UserRepositoryImplTest {
    @Test
    void testFindByName() {

        UserRepositoryImpl repository = new UserRepositoryImpl();

        List<User> usersByName = repository.findByName("And");
        
        for (User user : usersByName) {
            System.out.println(user.getName());
            assertTrue(user.getName().contains("And"));
        }
    }
}
