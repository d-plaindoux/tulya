package org.smallibs.tulya.actor.core;

public interface Behavior<Protocol> {

    ActorReference<Protocol> self();

    default void activate() {
        // Do nothing by default
    }

    void ask(Protocol message);

    default void dispose() {
        // Do nothing by default
    }
}
