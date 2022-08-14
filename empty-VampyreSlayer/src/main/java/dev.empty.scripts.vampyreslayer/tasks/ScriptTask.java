package dev.empty.scripts.vampyreslayer.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; }
}
