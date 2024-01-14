package org.carte.dubchessbackend.repository;

import org.carte.dubchessbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
