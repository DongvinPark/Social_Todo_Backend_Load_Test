package com.example.socialtodogrinder.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {

}
