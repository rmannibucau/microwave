package org.apache.microwave.cxf;

import org.apache.cxf.Bus;
import org.apache.johnzon.jaxrs.JohnzonProvider;
import org.apache.johnzon.jaxrs.JsrProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static java.util.Arrays.asList;

@ApplicationScoped
public class BusConfigurer {
    @Inject
    private Bus bus;

    public void setup(@Observes @Initialized(ApplicationScoped.class) final Object init) {
        // TODO: config with microwave.builder.properties
        if (bus.getProperty("org.apache.cxf.jaxrs.bus.providers") == null) {
            bus.setProperty("skip.default.json.provider.registration", "true");
            bus.setProperty("org.apache.cxf.jaxrs.bus.providers", asList(new JohnzonProvider<>(), new JsrProvider()));
        }
    }
}
