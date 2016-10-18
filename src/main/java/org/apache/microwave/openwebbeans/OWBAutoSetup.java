package org.apache.microwave.openwebbeans;

import org.apache.microwave.Microwave;
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
        final Microwave.Builder builder = Microwave.Builder.class.cast(ctx.getAttribute("microwave.configuration"));
        if (builder.properties() != null && "true".equalsIgnoreCase(builder.properties().getProperty("microwave.cdi.conversation.support", "false"))) {
            final FilterRegistration.Dynamic filter = ctx.addFilter("owb-conversation", WebConversationFilter.class);
            filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
        }
        ctx.addListener(WebBeansConfigurationListener.class);
    }
}
