package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.springframework.stereotype.Component;

@Component
public class ThingMapper {
    public static ThingDTO toDto(Thing thing){
        return ThingDTO.builder()
                .id(thing.getId())
                .name(thing.getName())
                .weight(thing.getWeight())
                .colour(thing.getColour())
                .build();
    }

    public static Thing toEntity (ThingDTO thingDTO){
        return Thing.builder()
                .id(thingDTO.id())
                .name(thingDTO.name())
                .weight(thingDTO.weight())
                .colour(thingDTO.colour())
                .build();
    }
}
