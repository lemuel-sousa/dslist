package com.limaodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limaodev.dslist.DTO.GameListDTO;
import com.limaodev.dslist.entities.GameList;
import com.limaodev.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    //Find all game lists
    public List<GameListDTO> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map( dto -> new GameListDTO(dto)).toList();
    }

}
