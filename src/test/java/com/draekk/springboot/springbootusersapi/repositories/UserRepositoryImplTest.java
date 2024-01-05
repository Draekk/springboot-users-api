package com.draekk.springboot.springbootusersapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
import com.draekk.springboot.springbootusersapi.models.User;

public class UserRepositoryImplTest {

    private UserRepositoryImpl repository = new UserRepositoryImpl();

    @Test
    void testFindByStrList() {

        List<User> usersByName = repository.findByStrList("And");
        
        for (User user : usersByName) {
            System.out.println(user.getName());
            assertTrue(user.getName().contains("And"));
        }
    }

    @Test
    void testFindByStr() {
        User user = repository.findByStr("237624-1");
        assertTrue(user.getDni().equals("237624-1"));
    }

    @Test
    void testNextId() {
        Long nextId = repository.nextId();
        assertTrue(nextId.equals(6L));
    }

    @Test
    void testDelete() {
        User user = repository.findById(5L);
        repository.delete(user);
        assertEquals(4, repository.count());
    }

    @Test
    void testEdit() {
        User user = repository.findById(3L);
        user.setName("Fernando");
        repository.edit(user);
        assertTrue(repository.findById(user.getId()).getName().equals("Fernando"));
    }

    @Test
    void testCount() {
        User user = new User(repository.nextId(), "123456-3", "José", "Arias", new Account(5L, "astoranth", "sgehet313."), "asggro@vrejrr.cl", new Address(5L, "FFFWREG", "FWGRG", "fWERGWRG"));
        repository.save(user);
        assertEquals(6, repository.findAll().size());
    }
}
