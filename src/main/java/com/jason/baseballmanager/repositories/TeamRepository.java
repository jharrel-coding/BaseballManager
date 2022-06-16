package com.jason.baseballmanager.repositories;

import com.jason.baseballmanager.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findAll();
}
