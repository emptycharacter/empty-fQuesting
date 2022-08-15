package dev.empty.scripts.xmarksthespot.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking()
    {
        return true;
    }
}
