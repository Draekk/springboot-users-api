package com.draekk.springboot.springbootusersapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
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
        assertEquals(4, repository.count());
    }

    @Test
    void testEdit() {
        UserDto user = new UserDto();
        user.setUser(repository.findById(3L));
        user.setIndex(repository.findAll().indexOf(user.getUser()));
        user.getUser().setName("Fernando");
        repository.edit(user);
        assertTrue(repository.findById(user.getUser().getId()).getName().equals("Fernando"));
    }

    @Test
    void testCount() {
        User user = new User(repository.nextId(), "123456-3", "José", "Arias", new Account(5L, "astoranth", "sgehet313."), "asggro@vrejrr.cl", new Address(5L, "FFFWREG", "FWGRG", "fWERGWRG"));
        repository.save(user);
        assertEquals(6, repository.findAll().size());
    }
}
