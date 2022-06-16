package com.jason.baseballmanager.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters.")
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters.")
    private String lastName;
    @Min(value = 1, message = "The jersey number must be at least 1.")
    @Max(value = 99, message = "The jersey number must be no greater than 99.")
    private int jerseyNumber;


    private boolean hittingHand;


    private boolean throwingHand;


    private String position;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    //Many to Many relationship
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "players_schedules",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private List<Schedule> schedules;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //Constructor
    public Player() {}

    public Player(String firstName, String lastName, int jerseyNumber, boolean hittingHand, boolean throwingHand, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.hittingHand = hittingHand;
        this.throwingHand = throwingHand;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public boolean isHittingHand() {
        return hittingHand;
    }

    public void setHittingHand(boolean hittingHand) {
        this.hittingHand = hittingHand;
    }

    public boolean isThrowingHand() {
        return throwingHand;
    }

    public void setThrowingHand(boolean throwingHand) {
        this.throwingHand = throwingHand;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @PrePersist
    protected void onCreat() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
