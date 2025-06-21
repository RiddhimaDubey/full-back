package com.example.testing.testing.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testing.testing.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    Optional<Person> findByEmail(String email);
    Optional<Person> findByReferralCode(String referralCode);
    List<Person> findByReferredBy(String referralCode);
}
