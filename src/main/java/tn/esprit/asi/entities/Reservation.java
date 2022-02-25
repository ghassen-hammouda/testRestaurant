package tn.esprit.asi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateReservation;
	private float prixReservation;
	@OneToMany(mappedBy="reservation")
	@JsonIgnore
	private Set<Client> clientsReservation;
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public float getPrixReservation() {
		return prixReservation;
	}
	public void setPrixReservation(float prixReservation) {
		this.prixReservation = prixReservation;
	}
	public Set<Client> getClientsReservation() {
		return clientsReservation;
	}
	public void setClientsReservation(Set<Client> clientsReservation) {
		this.clientsReservation = clientsReservation;
	}
	public Reservation(Long idReservation, Date dateReservation, float prixReservation,
			Set<Client> clientsReservation) {
		super();
		this.idReservation = idReservation;
		this.dateReservation = dateReservation;
		this.prixReservation = prixReservation;
		this.clientsReservation = clientsReservation;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
