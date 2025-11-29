package org.smallibs.tulya.actor.core.impl;

import org.smallibs.tulya.actor.core.ActorRuntime;
import org.smallibs.tulya.actor.core.ActorRuntimeContext;

import java.util.concurrent.ExecutorService;

public class ActorRuntimeImpl implements ActorRuntime {

    private final ActorRuntimeContext runtimeContext;
    private final ExecutorService executor;

    public ActorRuntimeImpl(ActorRuntimeContext runtimeContext, ExecutorService executor) {
        this.runtimeContext = runtimeContext;
        this.executor = executor;
    }

    @Override
    public ActorRuntimeContext context() {
        return runtimeContext;
    }

    @Override
    public void close() {
        executor.shutdownNow();
    }

    @Override
    public void perform(Runnable runnable) {
        this.executor.execute(runnable);
    }
}
