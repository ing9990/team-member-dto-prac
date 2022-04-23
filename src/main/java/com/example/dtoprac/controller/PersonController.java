package com.example.dtoprac.controller;

import com.example.dtoprac.domain.Gender;
import com.example.dtoprac.domain.Members;
import com.example.dtoprac.dto.PostPersonDto;
import com.example.dtoprac.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TaeWK
 */

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    @GetMapping()
    public List<Members> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Members findOneById(@PathVariable Long id) {
        return personService.findOneById(id);
    }


    @GetMapping("/age/{age}")
    public List<Members> findByAge(@PathVariable int age) {
        return personService.findByAge(age);
    }


    @GetMapping("/age-/{age}")
    public List<Members> findByAgePlus(@PathVariable int age) {
        return personService.findByAgePlus(age);
    }

    @GetMapping("/-age/{age}")
    public List<Members> findByAgeMinus(@PathVariable int age) {
        return personService.findByAgeMinus(age);
    }



    @GetMapping("/gender/{gender}")
    public List<Members> findMembersGender(@PathVariable Gender gender){
        return personService.findMembersByGender(gender);
    }

    @PostMapping()
    public List<Members> addPerson(@RequestBody PostPersonDto postPersonDto) {
        return personService.addPerson(postPersonDto);
    }


    @DeleteMapping("/{id}")
    public List<Members> deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    @DeleteMapping("/{name}")
    public List<Members> deleteByName(@PathVariable String name) {
        return personService.deleteByName(name);
    }


}
