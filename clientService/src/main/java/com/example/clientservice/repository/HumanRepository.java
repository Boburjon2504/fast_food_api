package com.example.clientservice.repository;

import com.example.clientservice.entity.Human;
import com.example.clientservice.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HumanRepository extends JpaRepository<Human,Long> {
    List<Human> findByUserType(UserType userType);
}
