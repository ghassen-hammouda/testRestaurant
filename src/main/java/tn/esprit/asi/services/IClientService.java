package tn.esprit.asi.services;

import tn.esprit.asi.entities.Client;
import tn.esprit.asi.entities.Reservation;

public interface IClientService {
void ajouterClient(Client client);
void affecterClientARestaurant(Long idClient, Long idRestaurant);
Long nbClientsParRestaurant(Long idRestaurant);

}
