package dev.empty.scripts.demonslayer.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; }
}
