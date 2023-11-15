package org.example.scheduler.abstractions;

@FunctionalInterface
public interface IRunNotSafeAction {
    public void executeNotSafeAction() throws Exception;
}
