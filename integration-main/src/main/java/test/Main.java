package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws JsonProcessingException {

		// Filtering
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("filtering.xml");

		// Service Activator
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("serviceActivator.xml");
	
		// Routing basic
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");

		// Routing Advanced
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("routingAdvanced.xml");

		// Sql Database
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("sqlDatabase.xml");
	}
}
 