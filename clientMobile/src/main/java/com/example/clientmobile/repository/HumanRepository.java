package com.example.clientmobile.repository;

import com.example.clientmobile.entity.Human;

import com.example.clientmobile.entity.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HumanRepository extends JpaRepository<Human,Long> {
    List<Human> findByUserType(UserType userType);
}
