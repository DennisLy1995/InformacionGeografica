package com.RIG.RIG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RIG.RIG.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, String> {

}
