package service;

import org.springframework.stereotype.Component;

@Component
public class ArticleUpdated {

    public Article modifySoldOut(Article article) {
        // Créer un nouvel objet Article
        Article updatedArticle = new Article();

        // Copier tous les éléments de l'article existant dans le nouvel article
        updatedArticle.setName(article.getName());
        updatedArticle.setColor(article.getColor());
        updatedArticle.setSize(article.getSize());
        updatedArticle.setPrice(article.getPrice());
        updatedArticle.setSoldOut(false); // Mettre soldOut à false
        updatedArticle.setDiscount(article.getDiscount());

        // Retourner l'article mis à jour
        return updatedArticle;
    }
}
