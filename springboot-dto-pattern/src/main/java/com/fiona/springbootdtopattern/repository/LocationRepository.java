package com.fiona.springbootdtopattern.repository;

import com.fiona.springbootdtopattern.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
