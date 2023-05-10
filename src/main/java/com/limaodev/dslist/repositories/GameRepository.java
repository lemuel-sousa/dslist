package com.limaodev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limaodev.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
