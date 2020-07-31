package com.tangwh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
   public void contextLoads() {

        for (int i = 0; i <10 ; i++) {
            System.out.println(passwordEncoder.encode("123"));
        }


    }

}
