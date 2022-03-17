package com.example.application.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherStatRepo extends JpaRepository<WeatherStatService, Integer> {
  List<WeatherStat> findAll();
}
