package com.jason.baseballmanager.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamOne;
    private String teamTwo;
    private String ballpark;
    private String homePitcher;
    private String visitingPitcher;
    private int attendance;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "players_schedules",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

    public Schedule() {}


    public Schedule(String teamOne, String teamTwo, String ballpark, String homePitcher, String visitingPitcher, int attendance, List<Player> players) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.ballpark = ballpark;
        this.homePitcher = homePitcher;
        this.visitingPitcher = visitingPitcher;
        this.attendance = attendance;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getBallpark() {
        return ballpark;
    }

    public void setBallpark(String ballpark) {
        this.ballpark = ballpark;
    }

    public String getHomePitcher() {
        return homePitcher;
    }

    public void setHomePitcher(String homePitcher) {
        this.homePitcher = homePitcher;
    }

    public String getVisitingPitcher() {
        return visitingPitcher;
    }

    public void setVisitingPitcher(String visitingPitcher) {
        this.visitingPitcher = visitingPitcher;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
