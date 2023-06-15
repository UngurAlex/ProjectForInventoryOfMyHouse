package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import lombok.*;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;

import java.util.List;

@Builder
public record HouseDTO(
    Long id,
    String name,
    List<Room> rooms
) {
}
