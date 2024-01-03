package com.draekk.springboot.springbootusersapi.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserDto;

public class UserRepositoryImplTest {

    private UserRepositoryImpl repository = new UserRepositoryImpl();

    @Test
    void testFindByName() {

        List<User> usersByName = repository.findByName("And");
        
        for (User user : usersByName) {
            System.out.println(user.getName());
            assertTrue(user.getName().contains("And"));
        }
    }

    @Test
    void testFindByDni() {
        User user = repository.findByDni("237624-1");
        assertTrue(user.getDni().equals("237624-1"));
    }

    @Test
    void testNextId() {
        Long nextId = repository.nextId();
        assertTrue(nextId.equals(6L));
    }

    @Test
    void testDelete() {
        UserDto user = new UserDto();
        user.setUser(repository.findById(5L));
        user.setIndex(repository.findAll().indexOf(user.getUser()));
        repository.delete(user);
        assertTrue(repository.count() == 4);
    }
}
