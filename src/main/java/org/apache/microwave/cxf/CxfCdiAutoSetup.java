package org.apache.microwave.cxf;

import org.apache.cxf.cdi.CXFCdiServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class CxfCdiAutoSetup implements ServletContainerInitializer {
    @Override
    public void onStartup(final Set<Class<?>> c, final ServletContext ctx) throws ServletException {
        final ServletRegistration.Dynamic jaxrs = ctx.addServlet("cxf-cdi", CXFCdiServlet.class);
        jaxrs.setLoadOnStartup(1);
        jaxrs.setAsyncSupported(true);
        jaxrs.addMapping("/*"); // TODO: config
    }
}
