package org.apache.microwave;

public class MicrowaveExplosion extends RuntimeException {
    public MicrowaveExplosion(final String msg, final Exception e) {
        super(msg, e);
    }
}
