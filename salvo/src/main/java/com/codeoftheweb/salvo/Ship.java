package com.codeoftheweb.salvo;

import  org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_ID")
    private GamePlayer gamePlayer;

    private String shiptype;

    @ElementCollection
    @Column (name = "location")
    private Set<String> shipLocation;

    //Constructor

    public Ship() {
    }



    public long getId() {
        return id;
    }


    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public String getShiptype() {
        return shiptype;
    }

    public void setShiptype(String shiptype) {
        this.shiptype = shiptype;
    }

    public Set<String> getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(Set<String> shipLocation) {
        this.shipLocation = shipLocation;
    }


}
