package tn.esprit.asi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.asi.entities.Client;
import tn.esprit.asi.entities.Reservation;
import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.repository.ClientRepository;
import tn.esprit.asi.repository.ReservationRepository;
import tn.esprit.asi.repository.RestaurantRepository;

@Service
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public void creerReservationParClient(Reservation reservation, Long idClient) {
		reservationRepository.save(reservation);
		Client c =clientRepository.findById(idClient).orElse(null);
	    System.out.print(c);
	    c.setReservation(reservation);
	    clientRepository.save(c);
		
		 
		
	}

	@Override
	public List<Reservation> listeReservationsParRestaurant(Long idRestaurant) {
		Restaurant restaurant =restaurantRepository.findById(idRestaurant).orElse(null);
		ArrayList<Reservation> reservations = new ArrayList<>();
		restaurant.getClients().stream().forEach(
        		c -> {
        			if (c.getReservation()!=null)
        			{
        		    reservations.add(c.getReservation());
        			}
  
        		}
        		);
       
		return reservations;
	}

}
