package org.carte.dubchessbackend.service;

import org.carte.dubchessbackend.model.Player;
import org.carte.dubchessbackend.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getAllPlayers() {
        return this.repository.findAll();
    }

    public void addPlayer(Player player) {
        this.repository.save(player);
    }

    public void updatePlayer(Long id, Player player) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player already exists in the database");
        this.repository.save(player);
    }

    public void deletePlayer(Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player with that id does not exist");
        this.repository.delete(repository.findById(id).orElseThrow());
    }
}
