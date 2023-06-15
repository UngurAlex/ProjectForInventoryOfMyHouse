package org.fasttrackit.ProjectForInventoryOfMyHouse.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Builder(toBuilder = true)
@With
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer area;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = LAZY)
    private List<Thing> things;

    @ManyToOne
    @JoinColumn(name = "house_id")
    @JsonIgnore
    private House house;

}
