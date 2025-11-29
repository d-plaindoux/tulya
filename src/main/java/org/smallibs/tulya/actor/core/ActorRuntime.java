package org.smallibs.tulya.actor.core;

import org.smallibs.tulya.actor.core.impl.ActorRuntimeImpl;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;

public interface ActorRuntime extends Closeable {

    ActorRuntimeContext context();

    void perform(Runnable runnable);

    final class Companion {
        static ActorRuntime build(ActorRuntimeContext context, ExecutorService executor) {
            return new ActorRuntimeImpl(context, executor);
        }
    }

}
