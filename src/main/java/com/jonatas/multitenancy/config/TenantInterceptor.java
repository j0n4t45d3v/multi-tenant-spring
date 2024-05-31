package com.jonatas.multitenancy.config;

import com.jonatas.multitenancy.tenant.TenantIdentifierResolver;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TenantInterceptor.class);
    private final TenantIdentifierResolver resolver;

    @Autowired
    public TenantInterceptor(TenantIdentifierResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler
    ) throws Exception {
        var tenant = request.getHeader("TENANT");
        this.resolver.setTenantSchema(tenant);
        log.info("Tenant resolve {}", tenant);
        return true;
    }
}
