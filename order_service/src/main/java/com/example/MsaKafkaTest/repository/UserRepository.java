package com.example.MsaKafkaTest.repository;

import com.example.MsaKafkaTest.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}