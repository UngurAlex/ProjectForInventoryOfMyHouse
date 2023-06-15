package org.fasttrackit.ProjectForInventoryOfMyHouse.dto;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomMapper {
    public static RoomDTO toDto(Room room){
       return RoomDTO.builder()
               .id(room.getId())
               .name(room.getName())
               .area(room.getArea())
               .thing(room.getThings())
               .build();
    }

    public static Room toEntity(RoomDTO roomDTO){
        return Room.builder()
                .name(roomDTO.name())
                .area(roomDTO.area())
                .things(roomDTO.thing())
                .build();
    }


}
