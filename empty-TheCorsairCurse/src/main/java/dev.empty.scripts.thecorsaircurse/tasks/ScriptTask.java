package dev.empty.scripts.thecorsaircurse.tasks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; }
}
