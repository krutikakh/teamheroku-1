package com.example.intern.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.intern.members.Team;
import com.example.intern.members.TeamUI;
import com.example.intern.repository.TeamRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    TeamRepo repository;

    @GetMapping("/bulkcreate")
    public String bulkcreate(){
        // save a list of Teams
        repository.saveAll(Arrays.asList(new Team("Akshita", "Samant")
                , new Team("Krutika", "Khandelwal")
                , new Team("Ketki", "Hatwar")));

        return "Teams are created";
    }
    
    @GetMapping("/findall")
    public List<TeamUI> findAll(){

        List<Team> Teams = repository.findAll();
        List<TeamUI> TeamUI = new ArrayList<>();

        for (Team Team : Teams) {
            TeamUI.add(new TeamUI(Team.getFirstName(),Team.getLastName()));
        }
        System.out.println(TeamUI);
        return TeamUI;
    }
}