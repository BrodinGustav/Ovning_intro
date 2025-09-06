package com.example.demo.repository;

import com.example.demo.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail (String email);
    Member findByName (String name);


}
