package com.limaodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.limaodev.dslist.DTO.GameDTO;
import com.limaodev.dslist.DTO.GameMinDTO;
import com.limaodev.dslist.entities.Game;
import com.limaodev.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    //Find game by id
    @Transactional( readOnly = true)
    public GameDTO findById( Long id){
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }


    //Find all games in the abridged version 
    @Transactional( readOnly = true)
    public List<GameMinDTO> findAll(){
       List<Game> games = gameRepository.findAll();       
        return games.stream().map( dto -> new GameMinDTO(dto)).toList();
    }


}
