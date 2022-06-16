package com.jason.baseballmanager.services;

import com.jason.baseballmanager.models.Team;
import com.jason.baseballmanager.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}
