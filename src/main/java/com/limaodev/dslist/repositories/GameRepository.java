package com.limaodev.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.limaodev.dslist.entities.Game;
import com.limaodev.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
    
    @Query( nativeQuery = true, value = """
            
            SELECT games.id, games.title, games.game_year AS gameYear, games.img_url AS imgUrl, 
                games.short_description AS shortDescription, belongings.position
            FROM games
            INNER JOIN belongings ON games.id = belongings.game_id
            WHERE belongings.game_list_id = :listId
            ORDER BY belongings.position
            """)

    List<GameMinProjection> searchByList( Long listId);


}
