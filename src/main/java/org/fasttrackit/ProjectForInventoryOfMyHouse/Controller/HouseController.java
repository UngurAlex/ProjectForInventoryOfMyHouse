package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.House;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
@RequiredArgsConstructor
@Slf4j
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/all")
    public List<House> getAllHousesWithRoomsAndThings() {
        return houseService.getAllHousesWithRoomsAndThings();
    }


    @PostMapping
    public House postNewHouse(@RequestBody House house) {
        return houseService.postNewHouse(house);
    }

}