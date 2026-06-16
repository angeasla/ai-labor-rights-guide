package com.angeasla.ai_labor_rights_guide.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.angeasla.ai_labor_rights_guide.config.EmbeddingModelLocationPostProcessor.toLocalUriIfPresent;
import static org.junit.jupiter.api.Assertions.*;

/** Local-first resolution logic for the embedder's model/tokenizer locations. */
class EmbeddingModelLocationPostProcessorTest {

    @Test
    void bundledTokenizerResolvesToClasspath() {
        // tokenizer.json ships inside the spring-ai-transformers jar (on the test classpath).
        assertEquals("classpath:/onnx/all-MiniLM-L6-v2/tokenizer.json",
                toLocalUriIfPresent("classpath:/onnx/all-MiniLM-L6-v2/tokenizer.json"));
    }

    @Test
    void missingClasspathResourceReturnsNull() {
        assertNull(toLocalUriIfPresent("classpath:/onnx/does-not-exist.bin"));
    }

    @Test
    void existingFileResolvesToAbsoluteFileUri(@TempDir Path dir) throws Exception {
        Path f = Files.writeString(dir.resolve("model.onnx"), "stub");
        String uri = toLocalUriIfPresent(f.toString());
        assertNotNull(uri);
        assertTrue(uri.startsWith("file:"), uri);
        assertTrue(uri.endsWith("model.onnx"), uri);
    }

    @Test
    void missingFileReturnsNull() {
        assertNull(toLocalUriIfPresent("models/definitely/missing-model.onnx"));
    }

    @Test
    void remoteCandidateIsNotConsideredLocal() {
        assertNull(toLocalUriIfPresent("https://example.com/model.onnx"));
        assertNull(toLocalUriIfPresent("http://example.com/model.onnx"));
    }

    @Test
    void blankOrNullReturnsNull() {
        assertNull(toLocalUriIfPresent(""));
        assertNull(toLocalUriIfPresent(null));
    }
}
