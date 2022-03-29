package com.OB_Spring_789_new.ObSpring789.Repository;

import com.OB_Spring_789_new.ObSpring789.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
