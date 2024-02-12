package service;

import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.messaging.Message;

import java.util.Collection;

public class ArticleCorrelationStrategy implements CorrelationStrategy {
    @Override
    public Object getCorrelationKey(Message<?> message) {
        return message.getHeaders().get("articleType");
    }

    public boolean aggregateSoldArticles(Collection<Article> articles) {
        // Compter le nombre d'articles non vendus
        long unsoldCount = articles.stream()
                .filter(article -> article.isSoldOut())
                .count();

        // Renvoyer true si le nombre d'articles non vendus est égal au nombre total d'articles
        return unsoldCount == articles.size();
    }
}
