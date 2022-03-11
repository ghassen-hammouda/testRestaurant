package tn.esprit.asi;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.asi.entities.CategorieResto;
import tn.esprit.asi.entities.Restaurant;
import tn.esprit.asi.services.IRestaurantService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceImplTest {
	@Autowired
	IRestaurantService restaurantService;
	
	@Test
	public void testAddRestaurant() {
	
		Restaurant r = new Restaurant("capricio restaurant","hammamet",CategorieResto.TROISETOILES);
		Restaurant savedResto= restaurantService.ajouterRestaurant(r);
		System.out.println("savedResto : "+savedResto.getAdresse());
		System.out.println("savedResto2 : "+savedResto.getAdresse());

		assertNotNull(savedResto.getAdresse());	
		
		
	} 
	
}


