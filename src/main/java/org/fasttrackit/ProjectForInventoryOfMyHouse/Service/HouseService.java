package org.fasttrackit.ProjectForInventoryOfMyHouse.Service;


import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.House;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Exception.ResourceNotFoundException;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.HouseRepository;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.RoomRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final RoomRepository roomRepository;


    public HouseService( HouseRepository houseRepository, RoomRepository roomRepository) {
        this.houseRepository = houseRepository;
        this.roomRepository = roomRepository;
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House postNewHouse(House house) {
        House existingHouse = houseRepository.findByName(house.getName());

        if (existingHouse != null) {
            List<Room> rooms = house.getRooms();

            if (rooms != null) {
                for (Room room : rooms) {
                    Room existingRoom = findExistingRoomByName(existingHouse.getRooms(), room.getName());
                    if (existingRoom != null) {
                        List<Thing> things = room.getThings();
                        if (things != null) {
                            things.forEach(thing -> thing.setRoom(existingRoom));
                            existingRoom.getThings().addAll(things);
                        }
                    } else {
                        existingHouse.getRooms().add(room);
                        room.setHouse(existingHouse);
                        List<Thing> things = room.getThings();
                        if (things != null) {
                            things.forEach(thing -> thing.setRoom(room));
                        }
                    }
                }
            }
            return houseRepository.save(existingHouse);
        } else {
            house.getRooms().forEach(room -> {
                room.setHouse(house);
                List<Thing> things = room.getThings();
                if (things != null) {
                    things.forEach(thing -> thing.setRoom(room));
                }
            });
            return houseRepository.save(house);
        }
    }

    private Room findExistingRoomByName(List<Room> existingRooms, String roomName) {
        for (Room existingRoom : existingRooms) {
            if (existingRoom.getName().equals(roomName)) {
                return existingRoom;
            }
        }
        return null;
    }

    public void deleteHouseByName(String name) {
        House house = houseRepository.findByName(name);
        if (house == null) {
            throw new RuntimeException("House with name %s was not found".formatted(name));
        }
        houseRepository.delete(house);
    }




    public House updateHouse(String name, House replaceHouse) {
        House foundHouse = getHouseByName(name);
        deleteHouseByName(name);

        House updatedHouse = foundHouse.toBuilder()
                .id(foundHouse.getId())
                .name(replaceHouse.getName())
                .rooms(replaceHouse.getRooms())
                .build();

        // Aici fac o incarcare lenesa :) oarecum
        for (Room room : updatedHouse.getRooms()) {
            room.setHouse(updatedHouse);
            for(Thing thing : room.getThings()){
                thing.setRoom(room);
            }
        }

        houseRepository.save(updatedHouse);
        return updatedHouse;

    }

    public House getHouseByName(String name) {
        House existingHouse = houseRepository.findByName(name);
        if(existingHouse==null){
            throw new RuntimeException("House with name %s was not found".formatted(name));
        }
        return existingHouse;
    }

    public House getById(String id) {
        if (id == null) {
            throw new RuntimeException("House with id %s was not founded".formatted(id));
        }
        return houseRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("House with id %s was not found".formatted(id)));
    }

    public House deleteHouseById(String id){
        House houseToBeDeleted = getById(id);
        houseRepository.deleteById(Long.valueOf(id));
        return houseToBeDeleted;
    }


}
