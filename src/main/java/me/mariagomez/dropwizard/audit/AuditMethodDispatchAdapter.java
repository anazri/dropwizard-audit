package me.mariagomez.dropwizard.audit;

import com.sun.jersey.spi.container.ResourceMethodDispatchAdapter;
import com.sun.jersey.spi.container.ResourceMethodDispatchProvider;

public class AuditMethodDispatchAdapter implements ResourceMethodDispatchAdapter {
    @Override
    public ResourceMethodDispatchProvider adapt(ResourceMethodDispatchProvider provider) {
        return new AuditMethodDispatchProvider(provider);
    }
}