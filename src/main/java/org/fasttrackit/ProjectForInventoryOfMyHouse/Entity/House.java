package org.fasttrackit.ProjectForInventoryOfMyHouse.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Builder(toBuilder = true)
@With
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "house", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = LAZY)
    private List<Room> rooms;


}
