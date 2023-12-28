package com.example.springmvc.repository;


import com.example.springmvc.DataController.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer,Integer> {
    List<Programmer> findByplan(String pLan);
    @Query("from Programmer where pName= ?1")
    List<Programmer> findP(String pName);

}
