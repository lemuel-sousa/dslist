package com.limaodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.limaodev.dslist.DTO.GameListDTO;
import com.limaodev.dslist.entities.GameList;
import com.limaodev.dslist.projections.GameMinProjection;
import com.limaodev.dslist.repositories.GameListRepository;
import com.limaodev.dslist.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    //Find all game lists
    @Transactional( readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map( dto -> new GameListDTO(dto)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> gameList = gameRepository.searchByList(listId);
        
        GameMinProjection game = gameList.remove(sourceIndex);
        gameList.add(destinationIndex, game);     

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for( int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
        }

    }

}
