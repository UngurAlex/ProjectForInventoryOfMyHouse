package org.fasttrackit.ProjectForInventoryOfMyHouse.Service;

import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Repository.ThingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ThingService {
    public final ThingRepository thingRepository;

    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    public List<Thing> getAllThings() {
        log.info("Here are all your things");
        return thingRepository.findAll();
    }
}
