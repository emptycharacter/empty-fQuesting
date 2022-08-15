package dev.empty.scripts.tutorialisland.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking()
    {
        return true;
    }
}
