package dev.empty.scripts.blackknightsfortress;

import dev.empty.scripts.blackknightsfortress.tasks.CompleteQuest;
import dev.empty.scripts.blackknightsfortress.tasks.ScriptTask;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;

@PluginDescriptor(name = "Empty Black Knights Fortress", enabledByDefault = false)
public class BlackKnightsFortress extends Script
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
