package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> getWhiskyByYear(int year);
    List<Whisky> getWhiskyByRegion(String region);
    List<Whisky> getWhiskyFromDistilleryByAge(Long distilleryId, int age);
}
