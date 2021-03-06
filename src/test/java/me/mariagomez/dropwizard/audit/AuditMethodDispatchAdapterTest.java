package me.mariagomez.dropwizard.audit;

import com.sun.jersey.spi.container.ResourceMethodDispatchAdapter;
import com.sun.jersey.spi.container.ResourceMethodDispatchProvider;
import me.mariagomez.dropwizard.audit.providers.PrincipalProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class AuditMethodDispatchAdapterTest {

    private AuditMethodDispatchAdapter adapter;
    @Mock
    private AuditWriter auditWriter;
    @Mock
    private PrincipalProvider principalProvider;

    @Before
    public void setUp() {
        initMocks(this);
        adapter = new AuditMethodDispatchAdapter(auditWriter, principalProvider);
    }

    @Test
    public void shouldBeAnInstanceOfResourceMethodDispatcherAdapter() {
        assertThat(adapter, instanceOf(ResourceMethodDispatchAdapter.class));
    }

    @Test
    public void shouldReturnAnInstanceOfAuditProvider() {
        ResourceMethodDispatchProvider providerToAdapt = mock(ResourceMethodDispatchProvider.class);
        AuditMethodDispatchProvider expected = new AuditMethodDispatchProvider(providerToAdapt, auditWriter, principalProvider);
        ResourceMethodDispatchProvider provider = adapter.adapt(providerToAdapt);

        assertReflectionEquals(expected, provider);
    }

}