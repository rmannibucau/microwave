package org.apache.microwave.openwebbeans;

import org.apache.cxf.cdi.JAXRSCdiResourceExtension;
import org.apache.webbeans.service.DefaultLoaderService;
import org.apache.webbeans.spi.LoaderService;

import javax.enterprise.inject.spi.Extension;
import java.util.Iterator;
import java.util.List;

public class MicrowaveLoader implements LoaderService {
    private final LoaderService defaultService = new DefaultLoaderService();

    @Override
    public <T> List<T> load(final Class<T> serviceType) {
        return defaultService.load(serviceType);
    }

    @Override
    public <T> List<T> load(final Class<T> serviceType, final ClassLoader classLoader) {
        final List<T> load = defaultService.load(serviceType, classLoader);
        if (Extension.class == serviceType) {
            final Iterator<T> e = load.iterator();
            while (e.hasNext()) {
                if (JAXRSCdiResourceExtension.class == e.next().getClass()) {
                    e.remove();
                    break;
                }
            }
        }
        return load;
    }
}
