package test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleService {
  
  public String processArticles(File articlesDataIn) throws IOException {

    ObjectMapper articleMapper = new ObjectMapper();
    List<Article> articlesIn = articleMapper.readValue(articlesDataIn, new TypeReference<List<Article>>() {});

    List<Article> soldArticles = new ArrayList<>();
    List<Article> unsoldArticles = new ArrayList<>();        

    for (Article article : articlesIn) {
      if (article.isSoldOut()) {
        soldArticles.add(article);
      } else {
        unsoldArticles.add(article);
      }
    }
    
    List<List<Article>> articlesList = new ArrayList<>();
    articlesList.add(soldArticles);
    articlesList.add(unsoldArticles);

    return articleMapper.writeValueAsString(articlesList);
  }
}
