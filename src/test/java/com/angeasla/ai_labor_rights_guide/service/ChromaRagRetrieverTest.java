package com.angeasla.ai_labor_rights_guide.service;

import com.angeasla.ai_labor_rights_guide.dto.ArticleContent;
import com.angeasla.ai_labor_rights_guide.dto.SearchResult;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/** Unit tests for the Chroma-backed RAG retriever's hit/metadata mapping (VectorStore mocked). */
class ChromaRagRetrieverTest {

    private static Document doc() {
        return Document.builder()
                .id("misthos-oromisthio")
                .text("Ωρομίσθιο\nπλήρες κείμενο")
                .metadata(Map.of(
                        "slug", "misthos/oromisthio",
                        "title", "Ωρομίσθιο",
                        "url", "#/misthos/oromisthio",
                        "category", "misthos",
                        "categoryLabel", "Μισθός & Δώρα",
                        "excerpt", "σύντομη περίληψη",
                        "body", "καθαρό κείμενο άρθρου"))
                .build();
    }

    @Test
    void search_mapsMetadataToSearchResult() {
        VectorStore vs = mock(VectorStore.class);
        when(vs.similaritySearch(any(SearchRequest.class))).thenReturn(List.of(doc()));

        List<SearchResult> out = new ChromaRagRetriever(vs).search("ωρομίσθιο", 5);

        assertEquals(1, out.size());
        SearchResult r = out.getFirst();
        assertEquals("Ωρομίσθιο", r.title());
        assertEquals("#/misthos/oromisthio", r.url());
        assertEquals("Μισθός & Δώρα", r.category());      // prefers categoryLabel
        assertEquals("σύντομη περίληψη", r.excerpt());
    }

    @Test
    void search_clampsLimitToTen() {
        VectorStore vs = mock(VectorStore.class);
        when(vs.similaritySearch(any(SearchRequest.class))).thenReturn(List.of());

        new ChromaRagRetriever(vs).search("q", 50);

        ArgumentCaptor<SearchRequest> cap = ArgumentCaptor.forClass(SearchRequest.class);
        verify(vs).similaritySearch(cap.capture());
        assertEquals(10, cap.getValue().getTopK());
    }

    @Test
    void search_fallsBackToCategoryWhenLabelMissing() {
        VectorStore vs = mock(VectorStore.class);
        Document d = Document.builder().id("x").text("t")
                .metadata(Map.of("title", "T", "url", "#/x", "category", "misthos", "excerpt", "e")).build();
        when(vs.similaritySearch(any(SearchRequest.class))).thenReturn(List.of(d));

        assertEquals("misthos", new ChromaRagRetriever(vs).search("q", 3).getFirst().category());
    }

    @Test
    void getArticle_returnsCleanBodyFromMetadataAndFiltersBySlug() {
        VectorStore vs = mock(VectorStore.class);
        when(vs.similaritySearch(any(SearchRequest.class))).thenReturn(List.of(doc()));

        ArticleContent a = new ChromaRagRetriever(vs).getArticle("misthos/oromisthio");

        assertNotNull(a);
        assertEquals("misthos/oromisthio", a.slug());
        assertEquals("Ωρομίσθιο", a.title());
        assertEquals("καθαρό κείμενο άρθρου", a.body()); // metadata body, not the embedded text+title

        ArgumentCaptor<SearchRequest> cap = ArgumentCaptor.forClass(SearchRequest.class);
        verify(vs).similaritySearch(cap.capture());
        assertEquals(1, cap.getValue().getTopK());
        assertNotNull(cap.getValue().getFilterExpression(), "get_article must filter by slug");
    }

    @Test
    void getArticle_returnsNullWhenNotFound() {
        VectorStore vs = mock(VectorStore.class);
        when(vs.similaritySearch(any(SearchRequest.class))).thenReturn(List.of());

        assertNull(new ChromaRagRetriever(vs).getArticle("nope/none"));
    }
}
