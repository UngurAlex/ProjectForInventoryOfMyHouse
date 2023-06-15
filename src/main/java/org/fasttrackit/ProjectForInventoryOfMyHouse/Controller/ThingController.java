package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.ThingService;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.ThingDTO;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.ThingMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("things")
@RequiredArgsConstructor
@Slf4j
public class ThingController {
    private final ThingService thingService;

    @GetMapping("/all")
        public List<ThingDTO> things(){
            return thingService.getAllThings().stream().map(thing->ThingMapper.toDto(thing)).toList();
        }

}
