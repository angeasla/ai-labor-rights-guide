package com.angeasla.ai_labor_rights_guide;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    // Prevent the app from connecting to real external services during tests.
    // ChromaDB and DeepSeek are not available in CI — beans are still created
    // but no actual connections are made until the first request.
    "spring.ai.deepseek.api-key=dummy-key-for-tests",
    "admin.secret=dummy-secret-for-tests",
    "spring.ai.vectorstore.chroma.client.host=http://localhost",
    "spring.ai.vectorstore.chroma.client.port=8000",
    "spring.ai.vectorstore.chroma.initialize-schema=false"
})
class AiLaborRightsGuideApplicationTests {

    @Test
    void contextLoads() {
        // Verifies the Spring context starts successfully with all beans wired correctly.
    }

}
