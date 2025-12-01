package org.smallibs.tulya.actor.core;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.smallibs.tulya.actor.core.impl.BehaviorImpl;
import org.smallibs.tulya.async.Promise;
import org.smallibs.tulya.async.Promises;
import org.smallibs.tulya.async.Solvable;
import org.smallibs.tulya.standard.Unit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.smallibs.tulya.actor.core.ActorAddress.Companion.address;

public abstract class BenchmarkCommon {

    static List<ActorReference<Solvable<Unit>>> createActors(ActorCoordinator coordinator, int nbActors) {
        return IntStream.range(0, nbActors).mapToObj(i -> {
            try {
                return coordinator.<Solvable<Unit>>register(
                        address("test" + i),
                        self -> new BehaviorImpl<>(self, r -> r.success(Unit.unit))
                ).orElseThrow();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    @SuppressWarnings("unchecked")
    void benchmark(List<ActorReference<Solvable<Unit>>> actors, int nbMessages, Blackhole blackhole) throws Throwable {
        var t0 = System.currentTimeMillis();

        var responses = IntStream.range(0, nbMessages).mapToObj(i ->
                actors.get(i % actors.size()).<Unit>ask(s -> s)
        ).toArray(Promise[]::new);

        Promises.forall(responses).await();

        blackhole.consume(responses);
    }
}
