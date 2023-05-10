package com.limaodev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaodev.dslist.DTO.GameMinDTO;
import com.limaodev.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameMinDTO> getGames(){
        return gameService.findAll();
    }

}
