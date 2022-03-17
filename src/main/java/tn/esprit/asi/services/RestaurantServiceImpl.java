package tn.esprit.asi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

	@Autowired
	RestaurantRepository restaurantRepository;
	@Override
	public Restaurant ajouterRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return restaurant;
	}
	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return (List<Restaurant>) restaurantRepository.findAll();
	}
	
	

}
