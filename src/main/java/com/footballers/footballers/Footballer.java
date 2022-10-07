package com.footballers.footballers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Footballer {

    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String nationality;
    public Integer scoreOutOfTen;
    public Boolean isReplacement;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    public Team team;

    public Footballer() {
    }
    
}


@RestController
class FootballerController {

    @Autowired
    private FootballerRepository FootballerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/footballer")
    public List<Footballer> getAllFootballers() {
        return FootballerRepository.findAll();
    }
}

interface FootballerRepository extends JpaRepository<Footballer, Integer> {
}
