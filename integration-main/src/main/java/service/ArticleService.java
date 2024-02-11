package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

                    Article discountArticle = new Article(article.getName(), article.getColor(), article.getSize(), discountPrice, false, 0.1F);
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
}
