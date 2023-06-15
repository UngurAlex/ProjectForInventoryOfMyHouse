package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.HouseService;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.HouseDTO;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.HouseMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(value = "http://localhost:4200")
public class HouseController {
    private final HouseService houseService;

    @GetMapping("/all")
    public List<HouseDTO> getAllHouses() {
        return houseService.getAllHouses().stream().map(house -> HouseMapper.toDto(house)).toList();
    }

    @GetMapping("/{id}")
    public HouseDTO getHouseById(@PathVariable String id){
        return HouseMapper.toDto(houseService.getById(id));
    }
    @PostMapping("/post")
    public HouseDTO postNewHouse(@RequestBody HouseDTO newHouse) {
        return HouseMapper.toDto(houseService.postNewHouse(HouseMapper.toHouse(newHouse)));
    }

    @DeleteMapping("/delete/{name}")
    public void deleteHouse(@PathVariable String name ){
        houseService.deleteHouseByName(name);
    }

    @PutMapping("put/{name}")
    public HouseDTO updateHouse(@RequestBody HouseDTO house, @PathVariable String name){
        return HouseMapper.toDto(houseService.updateHouse(name, HouseMapper.toHouse(house)));
    }

    @GetMapping("/all/{name}")
    public HouseDTO getHouseByName(@PathVariable String name) {
        return HouseMapper.toDto(houseService.getHouseByName(name));
    }

}
