package tn.esprit.asi.services;

import java.util.List;

import tn.esprit.asi.entities.Restaurant;

public interface IRestaurantService {
Restaurant ajouterRestaurant(Restaurant restaurant);
List<Restaurant> getAllRestaurants();
}
