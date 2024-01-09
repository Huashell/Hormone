package com.example.hormone.repository;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Favors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorsRepository extends JpaRepository<Favors, Integer> {
    // Add custom query methods if needed
}
