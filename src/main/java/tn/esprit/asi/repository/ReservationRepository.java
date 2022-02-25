package tn.esprit.asi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.asi.entities.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
