package dev.empty.scripts.runemysteries.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking()
    {
        return true;
    }
}
