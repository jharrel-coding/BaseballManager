package com.jason.baseballmanager.repositories;

import com.jason.baseballmanager.models.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findAll();

}
