package com.limaodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limaodev.dslist.DTO.GameMinDTO;
import com.limaodev.dslist.entities.Game;
import com.limaodev.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;


    public List<GameMinDTO> findAll(){
       List<Game> games = gameRepository.findAll();       
        return games.stream().map( game -> new GameMinDTO(game)).toList();
    }


}
