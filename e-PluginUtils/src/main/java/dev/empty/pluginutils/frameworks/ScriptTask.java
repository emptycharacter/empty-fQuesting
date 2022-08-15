package dev.empty.pluginutils.frameworks;

public interface ScriptTask
{
    boolean validate();

    int execute();

    default boolean blocking() { return true; };
}
