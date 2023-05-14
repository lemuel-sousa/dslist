package com.limaodev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaodev.dslist.DTO.GameDTO;
import com.limaodev.dslist.DTO.GameMinDTO;
import com.limaodev.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    //Get game by id
    @GetMapping( value = "/{id}")
    public GameDTO getById(@PathVariable( value = "id") Long id){
        return gameService.findById(id);
    }

    //Get all games in the abridged version
    @GetMapping
    public List<GameMinDTO> getGames(){
        return gameService.findAll();
    }

}
