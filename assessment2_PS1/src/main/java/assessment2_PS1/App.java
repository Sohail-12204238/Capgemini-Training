package assessment2_PS1;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager(); 
		
		try {
			em.getTransaction().begin();
			
			Customer customer = new Customer("sohail","sohail.rcom6@gmail.com");
			
			Order order = new Order(LocalDate.of(2025, 12, 5),7000);
			order.setCustomer(customer);
			
			OrderItem orderItem1 = new OrderItem("headphone",5,5000);
			OrderItem orderItem2 = new OrderItem("mouse",10,300);
			OrderItem orderItem3 = new OrderItem("monitor",7,3000);
			OrderItem orderItem4 = new OrderItem("keyboard",4,1000);
			OrderItem orderItem5 = new OrderItem("microphone",1,200);
			
			orderItem1.setOrder(order);
			orderItem2.setOrder(order);
			
			order.setOrderItems(Arrays.asList(orderItem1,orderItem2));
			customer.setOrdersList(Arrays.asList(order));
			
			em.persist(customer);
			
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}
}
