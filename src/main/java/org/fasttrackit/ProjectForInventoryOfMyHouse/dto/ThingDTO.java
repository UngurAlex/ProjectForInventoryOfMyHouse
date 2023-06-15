package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import lombok.Builder;

@Builder
public record ThingDTO(
        Long id,
        String name,
        Integer weight,
        String colour
) {
}
