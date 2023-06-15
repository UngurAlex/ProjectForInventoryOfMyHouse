package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.House;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {
    public static HouseDTO toDto(House house){
        return HouseDTO.builder()
                .id(house.getId())
                .name(house.getName())
                .rooms(house.getRooms())
                .build();
    }

    public static House toHouse(HouseDTO houseDTO){
        return House.builder()
                .name(houseDTO.name())
                .rooms(houseDTO.rooms())
                .build();
    }
}
