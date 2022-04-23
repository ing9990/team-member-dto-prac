package com.example.dtoprac.service;

import com.example.dtoprac.domain.Gender;
import com.example.dtoprac.domain.Members;
import com.example.dtoprac.repository.MembersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author TaeWK
 */

@SpringBootApplication
class MemberServiceTest {

    @Autowired
    private MembersRepository membersRepository;


    @Test
    @DisplayName("User Gender Test")
    void test01(){
        Members p = new Members();
        p.setName("Teawoo");
        p.setAge(20);
        p.setGender(Gender.MALE);

        membersRepository.save(p);
        System.out.println(p);
    }
}