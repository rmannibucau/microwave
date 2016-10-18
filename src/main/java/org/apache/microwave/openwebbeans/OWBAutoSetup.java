package org.apache.microwave.openwebbeans;

import org.apache.webbeans.servlet.WebBeansConfigurationHttpSessionListener;
import org.apache.webbeans.servlet.WebBeansConfigurationListener;
import org.apache.webbeans.web.context.WebConversationFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;
import java.util.Set;

public class OWBAutoSetup implements ServletContainerInitializer {
    @Override
    public void onStartup(final Set<Class<?>> c, final ServletContext ctx) throws ServletException {
        // TODO: config exclusions
        final FilterRegistration.Dynamic filter = ctx.addFilter("owb-conversation", WebConversationFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

        ctx.addListener(WebBeansConfigurationListener.class);
        ctx.addListener(WebBeansConfigurationHttpSessionListener.class);
    }
}
