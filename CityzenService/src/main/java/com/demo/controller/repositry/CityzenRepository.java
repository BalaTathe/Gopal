package com.demo.controller.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.controller.entity.Cityzen;

@Repository
public interface CityzenRepository extends JpaRepository<Cityzen, String> {
    public List<Cityzen> findByVaccine_Id(String vaccineId);
}
