package test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		// ApplicationContext: On retrouve bien le contenu de chaque fichier dans la console
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Filtrage
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("filtering.xml");

		// ServiceActivator: Comme trois fichiers en entrée, alors trois fichiers crées en sortie et chacun contient le contenu de la chaine de caractères. 
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("serviceActivator.xml");
	
		// Routing basic
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");

		// Routing Advanced
		ApplicationContext ctx = new ClassPathXmlApplicationContext("routingAdvanced.xml");
	}

}
 