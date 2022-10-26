package tn.esprit.asi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.services.IRestaurantService;

@Controller
public class RestaurantController {
	
	@Autowired 
	IRestaurantService restaurantService;
	
	// http://localhost:8086/SpringMVC/ajouter-restaurant
		@PostMapping("/ajouter-restaurant")
		@ResponseBody
		public void ajouterEtudiant(@RequestBody Restaurant restaurant) {
			restaurantService.ajouterRestaurant(restaurant);
			
		}
	// http://localhost:8086/SpringMVC/getAllRestaurants
		@GetMapping("/getAllRestaurants")
		public List<Restaurant> listeRestaurants() {
		return	restaurantService.getAllRestaurants();
			
		}
	

}
