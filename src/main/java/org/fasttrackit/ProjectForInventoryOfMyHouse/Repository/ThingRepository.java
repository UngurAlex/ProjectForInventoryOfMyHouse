package org.fasttrackit.ProjectForInventoryOfMyHouse.Repository;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {

}
