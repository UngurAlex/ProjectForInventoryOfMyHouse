package org.fasttrackit.ProjectForInventoryOfMyHouse.Service;

import jakarta.transaction.Transactional;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.House;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAllHouses(){
        return houseRepository.findAll();
    }


    public House postNewHouse(House house) {
        return houseRepository.save(house);
    }

    public List<House> getAllHousesWithRoomsAndThings() {
        List<House> houses = houseRepository.findAll();
        for (House house : houses) {
            List<Room> rooms = house.getRoom();
            for (Room room : rooms) {
                List<Thing> things = room.getThing();
                room.getThing().addAll(things);
            }
            house.getRoom().addAll(rooms);
        }
        return houses;
    }

}
