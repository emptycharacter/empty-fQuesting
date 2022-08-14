package dev.empty.scripts.witchspotion.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; }
}
