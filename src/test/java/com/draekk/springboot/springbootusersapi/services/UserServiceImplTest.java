package com.draekk.springboot.springbootusersapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
import com.draekk.springboot.springbootusersapi.models.User;

public class UserServiceImplTest {

    
    private UserServiceImpl service = new UserServiceImpl();

    @Test
    void testCount() {
        User user = new User(service.nextId(), "123456-3", "José", "Arias", new Account(5L, "astoranth", "sgehet313."), "asggro@vrejrr.cl", new Address(5L, "FFFWREG", "FWGRG", "fWERGWRG"));
        service.save(user);
        assertEquals(6, service.findAll().size());
    }

    @Test
    void testCreateDto() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testEdit() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindByDni() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByName() {

    }

    @Test
    void testNextId() {

    }

    @Test
    void testSave() {

    }
}
