package net.maxwellclass.online.xdclass.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class GuavaCache {

    private Cache<Object, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初始大小，设置合理，后续会扩容
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //缓存过期时间，写入后10分钟过期
            .expireAfterWrite(600, TimeUnit.SECONDS)
            //统计缓存命中率
            .recordStats()
            .build();

    private Cache<Object, Object> oneHourCache = CacheBuilder.newBuilder()
            //设置缓存初始大小，设置合理，后续会扩容
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数
            .concurrencyLevel(5)
            //缓存过期时间，写入后60分钟过期
            .expireAfterWrite(60, TimeUnit.MINUTES)
            //统计缓存命中率
            .recordStats()
            .build();

    public Cache<Object, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<Object, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }

    public Cache<Object, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<Object, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}