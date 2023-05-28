package org.fasttrackit.ProjectForInventoryOfMyHouse.Repository;

import org.fasttrackit.ProjectForInventoryOfMyHouse.Entity.Thing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThingRepository extends JpaRepository<Thing, Long> {
}
