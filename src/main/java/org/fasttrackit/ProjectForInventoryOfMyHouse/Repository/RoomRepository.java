package org.fasttrackit.ProjectForInventoryOfMyHouse.Repository;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    Room findByName(String name);
}
