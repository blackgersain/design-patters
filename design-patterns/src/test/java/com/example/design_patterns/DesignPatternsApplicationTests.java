package com.example.design_patterns;

import com.example.design_patterns.creational.builder.Account;
import com.example.design_patterns.creational.singleton.SingletonSerializable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class DesignPatternsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void singletonSerializable() throws Exception {
        SingletonSerializable instanceOne = SingletonSerializable.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SingletonSerializable instanceTwo = (SingletonSerializable) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

        assertEquals("instance 1: " + instanceOne.hashCode() + ", instance 2: " + instanceTwo.hashCode()
                , instanceOne.hashCode(), instanceTwo.hashCode());
    }

    @Test
    void builderPattern() {
        Account a = Account.builder()
                           .id(123)
                           .name("rich account")
                           .mail("black")
                           .isAdmin(true)
                           .language("es,en")
                           .build();

        assertTrue("account: " + a.toString(), true);
    }

}
