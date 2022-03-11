package tn.esprit.asi.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.entities.Client;
import tn.esprit.asi.entities.Reservation;
import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.repository.ClientRepository;
import tn.esprit.asi.repository.RestaurantRepository;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired 
	ClientRepository clientRepository;
	@Autowired
	RestaurantRepository restaurantRepository;
	@Override
	public void ajouterClient(Client client) {
		clientRepository.save(client);
		
	}

	public void affecterClientARestaurant(Long idClient, Long idRestaurant) {
		Client c =clientRepository.findById(idClient).orElse(null);
		Restaurant r=restaurantRepository.findById(idRestaurant).orElse(null);
		r.getClients().add(c);
		restaurantRepository.save(r);
		
	}
	@Override
	public Long nbClientsParRestaurant(Long idRestaurant) {
		Restaurant r=restaurantRepository.findById(idRestaurant).orElse(null);
		return (long) r.getClients().size();
	}
	

}
