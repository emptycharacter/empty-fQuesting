package dev.empty.scripts.sheepshearer.tasks;

public interface ScriptTask
{

    boolean validate();

    int execute();

    default boolean blocking() { return true; }

}
