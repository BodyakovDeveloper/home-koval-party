package com.koval.homedemo.repository;

import com.koval.homedemo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByCountryName(String countryName);

    List<City> searchCitiesByNameContaining(String name);
}
