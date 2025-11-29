package org.smallibs.tulya.actor.foundation;

import org.smallibs.tulya.actor.core.ActorCoordinator;
import org.smallibs.tulya.actor.core.ActorReference;
import org.smallibs.tulya.actor.core.Behavior;
import org.smallibs.tulya.standard.Try;

import static org.smallibs.tulya.actor.core.ActorAddress.Companion.address;

public record DeadLetter(ActorReference<Object> self) implements Behavior<Object> {
    @Override
    public void ask(Object message) {
        // TODO
    }

    static class Companion {
        static Try<ActorReference<Object>> register(ActorCoordinator coordinator) {
            return coordinator.register(address("system").child("dead-letter"), DeadLetter::new);
        }
    }
}
