package org.smallibs.tulya.async;

import org.smallibs.tulya.standard.Try;

@FunctionalInterface
public interface Solvable<R> {
    boolean solve(Try<R> value);

    default boolean success(R value) {
        return solve(Try.success(value));
    }

    default boolean failure(Throwable value) {
        return solve(Try.failure(value));
    }
}
