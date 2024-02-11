package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    public String changeArticleDiscount(File articlesDataIn) {
        try {
            ObjectMapper articleMapper = new ObjectMapper();
            List<Article> articlesIn = articleMapper.readValue(articlesDataIn, new TypeReference<List<Article>>() {
            });
            List<Article> articlesOut = new ArrayList<>();

            for (Article article : articlesIn) {
                if (!article.isSoldOut()) {
                    double currentPrice = article.getPrice();
                    double discountPrice = currentPrice * 0.9;

                    Article discountArticle = new Article(article.getId(), article.getName(), article.getColor(), article.getSize(), discountPrice, false, 0.1F);
                    articlesOut.add(discountArticle);

                } else {
                    articlesOut.add(article);
                }
            }

            // Convertir la liste d'articlesOut en JSON
            return articleMapper.writeValueAsString(articlesOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Message<List<Article>>> processArticles(Message<File> message) throws IOException {
        // Retrieve item data from file
        File articlesDataIn = message.getPayload();

        // Convert JSON data stored in a file into a list of Article objects
        ObjectMapper articleMapper = new ObjectMapper();
        List<Article> articlesIn = articleMapper.readValue(articlesDataIn, new TypeReference<List<Article>>() {
        });

        // Initialize lists to store sold and unsold articles
        List<Article> soldArticles = new ArrayList<>();
        List<Article> unsoldArticles = new ArrayList<>();

        // Split articles into sold and unsold lists
        for (Article article : articlesIn) {
            if (article.isSoldOut()) {
                soldArticles.add(article);
            } else {
                unsoldArticles.add(article);
            }
        }

        // Create messages to distinguish between sold and unsold articles
        Message<List<Article>> soldMessage = MessageBuilder.withPayload(soldArticles)
                .setHeader("articleType", "sold")
                .build();

        Message<List<Article>> unsoldMessage = MessageBuilder.withPayload(unsoldArticles)
                .setHeader("articleType", "unsold")
                .build();

        List<Message<List<Article>>> resultList = new ArrayList<>();
        resultList.add(soldMessage);
        resultList.add(unsoldMessage);

        return resultList;
    
}
}
