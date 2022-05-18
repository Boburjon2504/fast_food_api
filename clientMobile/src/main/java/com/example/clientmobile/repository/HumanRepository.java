package com.example.clientmobile.repository;

import com.example.clientmobile.entity.Human;

import com.example.clientmobile.entity.enums.ClientStatus;
import com.example.clientmobile.entity.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HumanRepository extends JpaRepository<Human,Long> {
    List<Human> findByUserType(UserType userType);


    Optional<Human> findByStatusIsNotAndId(ClientStatus status, Long id);
}
