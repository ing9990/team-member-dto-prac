package com.example.dtoprac.repository;

import com.example.dtoprac.domain.Gender;
import com.example.dtoprac.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TaeWK
 */
@Repository
public interface MembersRepository extends JpaRepository<Members,Long> {
    Members deleteByName(String name);

    List<Members> findByAge(int age);

    List<Members> findMembersByAgeGreaterThan(int age);

    List<Members> findMembersByAgeLessThan(int age);

    List<Members> findMembersByGender(Gender gender);
}

