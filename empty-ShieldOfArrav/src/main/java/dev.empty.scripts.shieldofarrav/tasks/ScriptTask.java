package dev.empty.scripts.shieldofarrav.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; }
}
