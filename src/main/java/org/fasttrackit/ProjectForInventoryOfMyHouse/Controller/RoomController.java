package org.fasttrackit.ProjectForInventoryOfMyHouse.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.fasttrackit.ProjectForInventoryOfMyHouse.Service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public Room postNewRoom(@RequestBody Room room)  {
        return roomService.postNewRoom(room);
    }

}
