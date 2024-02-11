package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Article;
import service.ArticleService;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws JsonProcessingException {

		// ApplicationContext: On retrouve bien le contenu de chaque fichier dans la console
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Filtrage
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("filtering.xml");

		// ServiceActivator: prend le json en entrée puis applique des discounts sur les articles en non soldout et ressort le resultat dans dataout avec les modification appliquées
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("serviceActivator.xml");
	
		// Routing basic
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("routing.xml");

		// Routing Advanced
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("routingAdvanced.xml");


	}

}
 