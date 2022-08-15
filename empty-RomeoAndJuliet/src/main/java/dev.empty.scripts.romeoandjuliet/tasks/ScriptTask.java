package dev.empty.scripts.romeoandjuliet.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking()
    {
        return true;
    }
}
