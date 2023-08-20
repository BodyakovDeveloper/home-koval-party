package com.koval.homedemo.repository;

import com.koval.homedemo.model.City;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c JOIN FETCH c.country")
    List<City> findCitiesWithCountry(Pageable pageable);

    @Query("SELECT c FROM City c JOIN FETCH c.country WHERE c.country.name = :countryName")
    List<City> findAllByCountryNameWithCountry(@Param("countryName") String countryName);

    @Query("SELECT c FROM City c JOIN FETCH c.country WHERE c.name LIKE %:nameContaining%")
    List<City> searchCitiesByNameContainingWithCountry(@Param("nameContaining") String nameContaining);
}
