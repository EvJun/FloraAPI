package com.evanl.springidp;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository exposes code to database operations
@Repository
public interface FloralRepository extends JpaRepository<Floral, Long>{

}
