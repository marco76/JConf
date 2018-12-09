package io.javademo.micro.documents;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class CacheConfig {

    @Inject
    private CachingProvider cachingProvider;
    @Inject
    CacheManager cacheManager;

    @PostConstruct
    public void init() {

            MutableConfiguration<String, DocumentInfoBean> configuration =
                    new MutableConfiguration<String, DocumentInfoBean>()
                            .setTypes(String.class, DocumentInfoBean.class)
                            .setStoreByValue(false);

            cacheManager.createCache("documents", configuration);
    }

    @PreDestroy
    public void close() {
        cachingProvider.close();
    }
}
