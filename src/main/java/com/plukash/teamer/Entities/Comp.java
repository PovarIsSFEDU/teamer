package com.plukash.teamer.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "comp")
@NoArgsConstructor
@AllArgsConstructor
public class Comp implements Serializable {
    @Id
    @Getter
    @Setter
    private Long id;
    @Column(name = "name")
    @Getter
    @Setter
    private String op;
    @Transient
    @ManyToMany(mappedBy = "comp")
    @Getter
    @Setter
    private Set<User> users;

    public String getOp() {
        return op;
    }
}
