package com.limaodev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limaodev.dslist.DTO.GameListDTO;
import com.limaodev.dslist.services.GameListService;

@RestController
@RequestMapping( value = "/lists")
public class GameListController {
    
    @Autowired
    private GameListService gameListService;

    //Get game lists
    @GetMapping
    public List<GameListDTO> getGameList(){
        return gameListService.findAll();
    }

}
