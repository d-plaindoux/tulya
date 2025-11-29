package org.smallibs.tulya.actor.core.impl;

import org.smallibs.tulya.actor.core.ActorReference;
import org.smallibs.tulya.actor.core.Behavior;

import java.util.function.Consumer;

public record BehaviorImpl<Protocol>(
        ActorReference<Protocol> self,
        Consumer<Protocol> behavior
) implements Behavior<Protocol> {
    @Override
    public void ask(Protocol message) {
        behavior.accept(message);
    }
}
