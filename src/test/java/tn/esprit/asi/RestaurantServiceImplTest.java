package tn.esprit.asi;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.asi.entities.CategorieResto;
import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.services.IRestaurantService;


public class RestaurantServiceImplTest {
	@Autowired
	IRestaurantService restaurantService;
	
	@Test
	public void testAddRestaurant() {
	
		Restaurant r = new Restaurant("capricio restaurant","hammamet",CategorieResto.TROISETOILES);		
		assertNotNull(r.getAdresse());	
		
		
	} 
	
	
}


