package br.com.games.controller;

import br.com.games.model.Game;
import br.com.games.repository.GameRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/gerenciarGames")
    public String listarGames(Model model) {
        model.addAttribute("listaGames", gameRepository.findAll());
        return "gerenciar_games";
    }

    @GetMapping("/novoGame")
    public String novoGame(Model model) {
        model.addAttribute("game", new Game());
        return "editar_game";
    }

    @GetMapping("/editarGame/{id}")
    public String editarGame(@PathVariable("id") long idGame, Model model) {
        Optional<Game> game = gameRepository.findById(idGame);
        model.addAttribute("game", game.get());
        return "editar_game";
    }

    @PostMapping("/salvarGame")
    public String salvarGame(Game game, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_game";
        }
        gameRepository.save(game);
        return "redirect:/gerenciarGames";
    }

    @GetMapping("/excluirGame/{id}")
    public String excluirGame(@PathVariable("id") long idGame) {
        gameRepository.deleteById(idGame);
        return "redirect:/gerenciarGames";
    }
}
