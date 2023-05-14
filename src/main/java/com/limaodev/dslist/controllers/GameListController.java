package com.limaodev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaodev.dslist.DTO.GameListDTO;
import com.limaodev.dslist.DTO.GameMinDTO;
import com.limaodev.dslist.services.GameListService;
import com.limaodev.dslist.services.GameService;

@RestController
@RequestMapping( value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    //Get game lists
    @GetMapping
    public List<GameListDTO> getGameList(){
        return gameListService.findAll();
    }

    //Get games from lists
    @GetMapping( value = "/{listId}/games")
    public List<GameMinDTO> getByList(@PathVariable( value = "listId") Long listId){
        return gameService.findGamesByList(listId); 
    }





}
