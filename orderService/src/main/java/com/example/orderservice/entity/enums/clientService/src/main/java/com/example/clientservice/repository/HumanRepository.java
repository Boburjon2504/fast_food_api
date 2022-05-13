package com.example.clientservice.repository;

import com.example.clientservice.entity.Human;
import com.example.clientservice.entity.enums.UserType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HumanRepository extends JpaRepository<Human,Long> {

    List<Human> findByUserType(UserType userType);

}
