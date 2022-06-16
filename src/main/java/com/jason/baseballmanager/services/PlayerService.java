package com.jason.baseballmanager.services;

import com.jason.baseballmanager.models.Player;
import com.jason.baseballmanager.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player create(Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    public Player getById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player update(Player editPlayer) {
        return playerRepository.save(editPlayer);
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
