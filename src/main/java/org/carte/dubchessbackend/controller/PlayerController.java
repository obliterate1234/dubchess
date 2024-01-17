package org.carte.dubchessbackend.controller;

import org.carte.dubchessbackend.model.Player;
import org.carte.dubchessbackend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }
    @GetMapping("/players")
    public List<Player> getPlayers() {
        return service.getAllPlayers();
    }
    @PostMapping("/players/add")
    public void addPlayer(Player player) {
        service.addPlayer(player);
    }
    @PutMapping("/players/update")
    public void updatePlayer(Long id, Player player) {
        service.updatePlayer(id, player);
    }
    @DeleteMapping("/players/delete")
    public void deletePlayer(Long id) {
        service.deletePlayer(id);
    }
}

