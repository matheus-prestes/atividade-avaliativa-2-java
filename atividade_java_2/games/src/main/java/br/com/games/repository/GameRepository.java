package br.com.games.repository;

import br.com.games.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long>{
    
}
