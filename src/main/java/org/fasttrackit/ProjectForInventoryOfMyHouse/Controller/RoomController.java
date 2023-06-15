package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.RoomService;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.RoomDTO;
import org.fasttrackit.ProjectForInventoryOfMyHouse.dto.RoomMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/all")
    public List<RoomDTO> getAllRooms(){
       return roomService.getAllRooms().stream().map(room -> RoomMapper.toDto(room)).toList();
    }

    /*@PostMapping("/post")
    public RoomDTO postNewRoom(@RequestBody RoomDTO newRoom)  {
        return RoomMapper.toDto(roomService.postNewRoom(RoomMapper.toEntity(newRoom)));
    }*/

    /*@DeleteMapping("/delete/{name}")
    public void deleteByRoomName(@PathVariable String name){
        roomService.deleteByRoomName(name);
    }*/

   /* @PutMapping("/put/{name}")
    public RoomDTO replaceRoomByName(@PathVariable String name, @RequestBody RoomDTO replaceRoom) {
        return RoomMapper.toDto(roomService.replaceRoomByName(name, RoomMapper.toEntity(replaceRoom)));
    }*/

}
