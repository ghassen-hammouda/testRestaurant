package tn.esprit.asi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.asi.entities.Client;
import tn.esprit.asi.services.IClientService;

@RestController
public class ClientController {
	@Autowired
	IClientService clientService;
	
	// http://localhost:8086/SpringMVC/ajouter-client
		@PostMapping("/ajouter-client")
		@ResponseBody
		public void ajouterEtudiant(@RequestBody Client client) {
			clientService.ajouterClient(client);
			
		}
		
		//http://localhost:8086/SpringMVC/affecterClientARestaurant/1/1
		@PutMapping("/affecterClientARestaurant/{idClient}/{idRestaurant}")
		@ResponseBody
		public void affecterClientARestaurant(@PathVariable("idClient") 
		Long idClient,@PathVariable("idRestaurant") Long idRestaurant) {
			clientService.affecterClientARestaurant(idClient, idRestaurant);
		}
		//http://localhost:8086/SpringMVC/nbClientsParRestaurant/1
		@GetMapping("/nbClientsParRestaurant/{idRestaurant}")
		public Long nbClientsParRestaurant(@PathVariable("idRestaurant") Long idRestaurant)
		{
			return clientService.nbClientsParRestaurant(idRestaurant);
		}
}
