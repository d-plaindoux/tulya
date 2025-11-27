package org.smallibs.tulya.actor.core;

import org.smallibs.tulya.async.Solvable;

import java.util.function.Function;

@FunctionalInterface
public interface BehaviorCall<Protocol, R> extends Function<Solvable<R>, Protocol> {
}
