package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleFilter {

    public void filterAndSaveBlueArticles(Message<File> message) throws JsonParseException, JsonMappingException, IOException {
        File articlesFile = message.getPayload();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Article> articles = objectMapper.readValue(articlesFile, new TypeReference<List<Article>>(){});

        // Filtrage des articles bleus
        List<Article> blueArticles = articles.stream()
                .filter(article -> "Blue".equals(article.getColor()))
                .collect(Collectors.toList());

        // Enregistrement de la liste d'articles bleus dans un fichier JSON
        saveArticlesToFile(blueArticles);
       
    }

    private void saveArticlesToFile(List<Article> articles) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("dataOut/blue_articles.json"), articles);
        } catch (IOException e) {
            e.printStackTrace(); // Gérez les erreurs d'entrée/sortie ici
        }
    }
}