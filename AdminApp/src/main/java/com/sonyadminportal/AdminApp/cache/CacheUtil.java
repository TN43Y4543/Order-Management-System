package com.sonyadminportal.AdminApp.cache;

import com.sonyadminportal.AdminApp.model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class CacheUtil {
    private Map<String, Customer> cacheMap;
    @PostConstruct
    public void init()
    {
        cacheMap=new ConcurrentHashMap<>();
    }
    public boolean isKeyPresent(String mobNumber)
    {

        return cacheMap.containsKey(mobNumber);
    }
    public Customer getValue(String mobNumber)
    {
        return cacheMap.get(mobNumber);
    }
    public void insertIntoCache(String mobNumber,Customer customer) {
        cacheMap.put(mobNumber,customer);
    }
}
