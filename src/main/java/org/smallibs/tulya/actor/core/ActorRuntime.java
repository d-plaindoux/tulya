package org.smallibs.tulya.actor.core;

import org.smallibs.tulya.actor.core.impl.ActorRuntimeImpl;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;

public interface ActorRuntime extends Closeable {

    void perform(Runnable runnable);

    final class Companion {
        static ActorRuntime build(ExecutorService executor) {
            return new ActorRuntimeImpl(executor);
        }
    }

}
