package dev.empty.scripts.belowicemountain.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking()
    {
        return true;
    }
}
