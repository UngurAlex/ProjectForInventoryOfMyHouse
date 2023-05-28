package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.ThingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("things")
@RequiredArgsConstructor
@Slf4j
public class ThingController {
    private final ThingService thingService;

    @PostMapping
    public Thing postNewThing(Thing thing){
        return thingService.postNewThing(thing);
    }
}
