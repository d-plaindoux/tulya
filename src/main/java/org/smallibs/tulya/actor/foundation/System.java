package org.smallibs.tulya.actor.foundation;

import org.smallibs.tulya.actor.core.ActorCoordinator;
import org.smallibs.tulya.standard.Try;
import org.smallibs.tulya.standard.Unit;

final public class System {

    public static Try<Unit> register(ActorCoordinator coordinator) {
        return SystemBehavior.Companion.register(coordinator)
                .flatMap(__ -> DeadLetter.Companion.register(coordinator))
                .map(__ -> Unit.unit);
    }

}
