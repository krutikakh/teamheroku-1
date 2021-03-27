package com.example.intern.repository;


import com.example.intern.members.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepo extends CrudRepository<Team, Long>{
    List<Team> findAll();
}