package org.apache.microwave.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.Loader;

import java.beans.PropertyChangeListener;

public class ProvidedLoader implements Loader {
    private final ClassLoader delegate;
    private Context context;

    public ProvidedLoader(final ClassLoader loader) {
        this.delegate = loader == null ? ClassLoader.getSystemClassLoader() : loader;
    }

    @Override
    public void backgroundProcess() {
        // no-op
    }

    @Override
    public ClassLoader getClassLoader() {
        return delegate;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void setContext(final Context context) {
        this.context = context;
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public boolean getDelegate() {
        return false;
    }

    @Override
    public void setDelegate(final boolean delegate) {
        // ignore
    }

    @Override
    public boolean getReloadable() {
        return false;
    }

    @Override
    public void setReloadable(final boolean reloadable) {
        // no-op
    }

    @Override
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        // no-op
    }

    @Override
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        // no-op
    }
}

