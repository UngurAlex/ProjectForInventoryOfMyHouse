package org.fasttrackit.ProjectForInventoryOfMyHouse.Service;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.ThingRepository;
import org.springframework.stereotype.Service;

@Service
public class ThingService {
    private final ThingRepository thingRepository;

    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public Thing postNewThing(Thing thing){
        return thingRepository.save(thing);
    }
}
