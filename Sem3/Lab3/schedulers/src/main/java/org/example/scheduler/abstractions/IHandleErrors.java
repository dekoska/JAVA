package org.example.scheduler.abstractions;

@FunctionalInterface
public interface IHandleErrors {
    public void handle(Exception ex);
}
