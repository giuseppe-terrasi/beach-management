package it.terrasi.beachmanagement.repository;

import org.springframework.stereotype.Repository;

import it.terrasi.beachmanagement.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}