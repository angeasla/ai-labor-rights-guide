package com.angeasla.ai_labor_rights_guide.config;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Marks the auto-configured Chroma {@link VectorStore} bean lazy so an unreachable ChromaDB does NOT
 * fail application startup in the default (meili) mode — the Chroma autoconfiguration otherwise connects
 * eagerly at boot (initialize-schema). The bean is then created on first use only: ingestion's
 * best-effort dual-write (when Chroma is up) or {@code ChromaRagRetriever} in chroma mode. In meili mode
 * nothing touches it, so the app boots even with no ChromaDB running.
 */
@Configuration
public class ChromaLazyConfig {

    @Bean
    static BeanFactoryPostProcessor lazyVectorStoreBeanDefinitions() {
        return beanFactory -> {
            // allowEagerInit=false: inspect bean-definition metadata without instantiating anything.
            for (String name : beanFactory.getBeanNamesForType(VectorStore.class, false, false)) {
                beanFactory.getBeanDefinition(name).setLazyInit(true);
            }
        };
    }
}
