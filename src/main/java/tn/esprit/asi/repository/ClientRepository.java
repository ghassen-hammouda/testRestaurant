package tn.esprit.asi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.asi.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
