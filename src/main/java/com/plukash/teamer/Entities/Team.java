package com.plukash.teamer.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Getter
    @Column(name = "captain")
    private long captain;
    @Setter
    @Getter
    @Column(name = "p1")
    private long partOne;
    @Setter
    @Getter
    @Column(name = "p2")
    private long partTwo;
    @Setter
    @Getter
    @Column(name = "p3")
    private long partThree;
    @Setter
    @Getter
    @Column(name = "p4")
    private long partFour;

}
