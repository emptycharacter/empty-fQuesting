package dev.empty.scripts.romeoandjuliet;

import dev.empty.scripts.romeoandjuliet.tasks.CompleteQuest;
import dev.empty.scripts.romeoandjuliet.tasks.ScriptTask;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;

@PluginDescriptor(name = "Empty Romeo And Juliet", enabledByDefault = false)
@Extension
public class RomeoAndJuliet extends Script
{
    private static final ScriptTask[] TASKS = new ScriptTask[] {
            new CompleteQuest()
    };

    @Override
    protected int loop()
    {
        for (ScriptTask task : TASKS)
        {
            if (task.validate())
            {
                int sleep = task.execute();

                if (task.blocking())
                {
                    return sleep;
                }
            }
        }

        return 1000;
    }

    @Override
    public void onStart(String... args)
    {

    }
}
