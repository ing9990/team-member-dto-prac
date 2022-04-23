package com.example.dtoprac.service;

import com.example.dtoprac.domain.Gender;
import com.example.dtoprac.domain.Members;
import com.example.dtoprac.dto.PostPersonDto;
import com.example.dtoprac.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author TaeWK
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final MembersRepository membersRepository;


    @Transactional(readOnly = true)
    public List<Members> findAll() {
        System.out.println(membersRepository.findAll() + "\n");
        return membersRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Members findOneById(Long id) {

        if(membersRepository.findById(id) == null) {
            log.info(id + "가 존재하지 않습니다.");
            System.out.println(id + "가 존재하지 않습니다.\n");
            return null;
        }

        return membersRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(id+"가 없습니다."));

    }

    @Transactional(readOnly = true)
    public List<Members> findByAge(int age){
        int size = membersRepository.findByAge(age).size();
        log.info("나이가 " + age+ "세이신 회원을 " + size +"명 발견하였습니다.");
        return membersRepository.findByAge(age);
    }


    @Transactional
    public List<Members> addPerson(PostPersonDto postPersonDto) {
        Members p = new Members();

        p.setName(postPersonDto.getName());
        p.setAge(postPersonDto.getAge());
        p.setGender(postPersonDto.getGender());

        membersRepository.save(p);
        log.info(p.getName() + "님의 정보가 성공적으로 등록되었습니다.");

        return findAll();
    }

    @Transactional
    public List<Members> deleteById(Long id) {
        log.info(membersRepository.getById(id).getName() +"님의 회원 정보가 삭제됩니다.");
        System.out.println(membersRepository
                .getById(id).getName() +"님의 회원정보가 삭제됩니다.");
        membersRepository.deleteById(id);
        return membersRepository.findAll();
    }

    @Transactional
    public List<Members> deleteByName(String name) {

            log.info(name + "님의 회원정보가 삭제됩니다.");
            System.out.println(name + "님의 회원정보가 삭제됩니다.");
            membersRepository.deleteByName(name);

        return membersRepository.findAll();
    }


    public List<Members> findByAgePlus(int age) {
        log.info("나이가 " + age + "세 이상인 Member를 " + membersRepository.findMembersByAgeGreaterThan(age).size() + "명 조회했습니다.");
        return membersRepository.findMembersByAgeGreaterThan(age);
    }

    public List<Members> findByAgeMinus(int age) {
        log.info("나이가 " + age + "세 이하인 Member를 " + membersRepository.findMembersByAgeLessThan(age).size() + "명 조회했습니다.");
        return membersRepository.findMembersByAgeLessThan(age);
    }

    public List<Members> findMembersByGender(Gender gender) {
        return membersRepository.findMembersByGender(gender);
    }

   
}
