package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleFilter {

    // Function to check whether the item file contains blue items
    public boolean containsBlueArticles(Message<File> message) throws IOException {
        File articlesFile = message.getPayload();

        // Convert JSON file into object list Article
        ObjectMapper objectMapper = new ObjectMapper();
        List<Article> articles = objectMapper.readValue(articlesFile, new TypeReference<List<Article>>() {});

        // Checks if at least one item is "Blue"
        return articles.stream().anyMatch(article -> "Blue".equals(article.getColor()));
    }

    // Function that retrieves blue items from the input file and saves them in an output file
    public List<Article> saveBlueArticlesToFile(Message<File> message) throws IOException {
        File articlesFile = message.getPayload();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Article> articles = objectMapper.readValue(articlesFile, new TypeReference<List<Article>>() {});

        return articles.stream()
                .filter(article -> "Blue".equals(article.getColor()))
                .collect(Collectors.toList());
    }

    // Function to convert List<Article> to JSON string
    public String convertArticlesToJson(List<Article> articles) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(articles);
    }
}
