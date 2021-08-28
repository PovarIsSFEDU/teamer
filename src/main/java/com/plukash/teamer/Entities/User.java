package com.plukash.teamer.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @Column(name = "telegram")
    private String TGusername;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_comp",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comp_id"))
    @Getter
    @Setter
    private Set<Comp> competentions;
    @Column(name = "teamed")
    @Getter
    @Setter
    private boolean teamed;

    public User(String TGusername) {
        this.TGusername = TGusername;
    }

    public User() {

    }


    public Set<Comp> getCompetentions() {
        return competentions;
    }

    public long getId() {
        return id;
    }

    public String getTGusername() {
        return TGusername;
    }
}
