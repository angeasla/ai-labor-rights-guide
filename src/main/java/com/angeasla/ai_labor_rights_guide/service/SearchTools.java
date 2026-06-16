package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Spring AI tools that let the LLM ground its answers in the guide: search first, then fetch the full
 * article. Registered on the ChatClient. Descriptions in Greek — preserve the "Χρησιμοποίησε ΠΑΝΤΑ" phrasing.
 *
 * <p>Backed by the {@link RagRetriever} selected via {@code app.rag.provider} (meili | chroma) — this is
 * the only switchable path. The user-facing {@code /api/search} box always uses Meilisearch directly.
 */
@Component
public class SearchTools {

    private final RagRetriever retriever;

    public SearchTools(RagRetriever retriever) {
        this.retriever = retriever;
    }

    @Tool(name = "search_articles", description = "Αναζητά άρθρα στη γνωσιακή βάση εργατικών δικαιωμάτων (υβριδική αναζήτηση λέξεων + νοήματος). Χρησιμοποίησε ΠΑΝΤΑ πρώτα αυτό το εργαλείο για κάθε νομική ερώτηση, ώστε να βρεις τα σχετικά άρθρα πριν απαντήσεις.")
    public List<SearchResult> searchArticles(
            @ToolParam(description = "Όροι αναζήτησης στα ελληνικά") String query,
            @ToolParam(description = "Μέγιστος αριθμός αποτελεσμάτων (1–10, προτείνεται 5)") int limit) {
        return retriever.search(query, limit <= 0 ? 5 : limit);
    }

    @Tool(name = "get_article", description = "Επιστρέφει το πλήρες κείμενο ενός άρθρου με βάση το slug (π.χ. 'misthos/oromisthio'). Χρησιμοποίησέ το μετά την αναζήτηση για να διαβάσεις το πλήρες άρθρο και να τεκμηριώσεις την απάντησή σου με παραπομπή.")
    public ArticleContent getArticle(
            @ToolParam(description = "Το slug του άρθρου από το πεδίο 'slug' του search_articles (π.χ. 'misthos/oromisthio')") String slug) {
        return retriever.getArticle(slug);
    }
}
