package tn.esprit.asi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.asi.entities.Client;
import tn.esprit.asi.entities.Reservation;
import tn.esprit.asi.services.IReservationService;

@RestController
public class ReservationController {

	@Autowired
	IReservationService reservationService;
	
	// http://localhost:8086/SpringMVC/creerReservationParClient/1
			@PostMapping("/creerReservationParClient/{idClient}")
			@ResponseBody
			public void creerReservationParClient(@RequestBody Reservation reservation,@PathVariable("idClient") 
			Long idClient) {
				reservationService.creerReservationParClient(reservation, idClient);
				
			}
			
			// http://localhost:8086/SpringMVC/listeReservationsParRestaurant/1
			@GetMapping("/listeReservationsParRestaurant/{id-restaurant}")
			@ResponseBody
			public List<Reservation> listeReservationsParRestaurant(@PathVariable("id-restaurant") Long idRestaurant){
				return reservationService.listeReservationsParRestaurant(idRestaurant);
			}
			
}
