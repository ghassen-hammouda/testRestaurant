package tn.esprit.asi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.asi.entities.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
