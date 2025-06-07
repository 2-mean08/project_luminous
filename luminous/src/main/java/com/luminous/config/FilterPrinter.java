package com.luminous.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;

@Component
public class FilterPrinter {

    @Autowired
    @Qualifier("springSecurityFilterChain")
    private Filter springSecurityFilterChain;

    @PostConstruct
    public void printFilters() {
        FilterChainProxy proxy = (FilterChainProxy) springSecurityFilterChain;
        proxy.getFilterChains().forEach(chain ->
            chain.getFilters().forEach(filter ->
                System.out.println("Spring Security Filter: " + filter.getClass().getSimpleName())
            )
        );
    }
}
