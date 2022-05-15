package com.example.clientmobile.repository;

import com.example.clientmobile.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Human,Long> {
}
