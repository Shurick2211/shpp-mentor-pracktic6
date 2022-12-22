package com.nimko.shppmentorpracktic6.services;

import com.nimko.shppmentorpracktic6.Excepion.MyValidatorException;
import com.nimko.shppmentorpracktic6.model.Person;
import com.nimko.shppmentorpracktic6.model.Sex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ValidateServicesTest {
    @Autowired
    ValidateServices validateServices;

    @Autowired
    CheckIpnService checkIpnService;

    Person person = new Person(1, 2991108392L, "Olexandr",
            "Nimko", Sex.MALE);

    @Test
    void checkInPerson() {
        assertTrue(checkIpnService.checkInPerson(person));
    }

    @Test
    void isValid() {
        assertTrue(validateServices.isValid(person));
    }

    @Test
    void validate() {
        person.setSex(null);
        Exception e = assertThrows(MyValidatorException.class,()->{
            validateServices.validate(person);
        });
    }
}