package org.fasttrackit.ProjectForInventoryOfMyHouse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder(toBuilder = true)
@With
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Thing{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer weight;

    @Column
    private String colour;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;

}
