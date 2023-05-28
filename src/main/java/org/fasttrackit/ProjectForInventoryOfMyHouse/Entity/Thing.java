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
public class Thing {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Integer weight;

    @Column
    private String colour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;
}
