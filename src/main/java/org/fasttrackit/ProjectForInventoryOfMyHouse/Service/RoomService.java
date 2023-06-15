package org.fasttrackit.ProjectForInventoryOfMyHouse.Service;

import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Exception.ResourceNotFoundException;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomService {
    private final RoomRepository roomRepository;


    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;

    }


    public List<Room> getAllRooms() {
        log.info("Here are all your rooms");
        return roomRepository.findAll();
    }

  /*  public Room postNewRoom(Room room) {
        String roomName = room.getName();
        Room existingRoom = roomRepository.findByName(roomName);

        if (existingRoom != null) {
            List<Thing> things = room.getThing();

            if (things != null) {
                existingRoom.getThing().addAll(things);
                things.forEach(thing -> thing.setRoom(existingRoom));
            }
            log.info("Things from room with name %s was updated".formatted(roomName));
            return roomRepository.save(existingRoom);
        } else {
            room.getThing().forEach(thing -> thing.setRoom(room));
            log.info("Room with name %s was created".formatted(roomName));
            return roomRepository.save(room);
        }

    }*/

    public Room getByName(String name) {
        return roomRepository.findByName(name);
    }


    /*public void deleteByRoomName(String name) {
        Room room = roomRepository.findByName(name);
        if (room == null)
            throw new ResourceNotFoundException("Room with name %s was not found".formatted(name));
        roomRepository.delete(room);
        log.info("Room with name %s was deleted".formatted(name));
    }*/


    /*public Room replaceRoomByName(String name, Room replaceRoom) {
        Room foundRoom = getByName(name);

        foundRoom.setName(replaceRoom.getName());
        foundRoom.setArea(replaceRoom.getArea());

        List<Thing> replaceThing = replaceRoom.getThing();

        if(replaceThing!=null){
            foundRoom.getThing().clear();
            foundRoom.getThing().addAll(replaceThing);
        }

        return roomRepository.save(foundRoom);
    }*/


}
