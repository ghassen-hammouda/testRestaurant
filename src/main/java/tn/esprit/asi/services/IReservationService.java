package tn.esprit.asi.services;

import java.util.List;

import tn.esprit.asi.entities.Reservation;

public interface IReservationService {
	void creerReservationParClient(Reservation reservation, Long idClient);

	List<Reservation> listeReservationsParRestaurant(Long idRestaurant);

}
