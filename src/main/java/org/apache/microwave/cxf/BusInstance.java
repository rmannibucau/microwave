package org.apache.microwave.cxf;

import lombok.experimental.Delegate;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.extension.ExtensionManagerBus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("cxf")
@ApplicationScoped
public class BusInstance implements Bus {
    @Delegate
    private Bus delegate = new ExtensionManagerBus();
}
