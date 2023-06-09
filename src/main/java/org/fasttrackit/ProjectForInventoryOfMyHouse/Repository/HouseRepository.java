package org.fasttrackit.ProjectForInventoryOfMyHouse.Repository;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    House findByName(String name);

}

