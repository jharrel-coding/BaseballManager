package com.jason.baseballmanager.services;

import com.jason.baseballmanager.models.Schedule;
import com.jason.baseballmanager.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> findScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
