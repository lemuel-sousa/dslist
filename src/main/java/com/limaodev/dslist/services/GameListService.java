package com.limaodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.limaodev.dslist.DTO.GameListDTO;
import com.limaodev.dslist.entities.GameList;
import com.limaodev.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    //Find all game lists
    @Transactional( readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map( dto -> new GameListDTO(dto)).toList();
    }

}
