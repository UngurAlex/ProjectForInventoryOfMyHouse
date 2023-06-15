package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import lombok.Builder;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;

import java.util.List;

@Builder
public record RoomDTO(
        Long id,
        String name,
        Integer area,
        List<Thing> thing
) {
}
