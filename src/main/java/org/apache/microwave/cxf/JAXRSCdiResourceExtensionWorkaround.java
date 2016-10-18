package org.apache.microwave.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.cdi.JAXRSCdiResourceExtension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;

// just there to ensure we use a single bus even for ResourceUtils.createApplication
public class JAXRSCdiResourceExtensionWorkaround extends JAXRSCdiResourceExtension {
    @Override
    public void load(@Observes final AfterDeploymentValidation event, final BeanManager beanManager) {
        final Bus bus = Bus.class.cast(beanManager.getReference(beanManager.resolve(beanManager.getBeans(Bus.class)), Bus.class, null));
        BusFactory.setThreadDefaultBus(bus); // cause app class will rely on that and would create multiple bus and then deployment would be broken
        try {
            super.load(event, beanManager);
        } finally {
            BusFactory.clearDefaultBusForAnyThread(bus);
        }
    }
}
