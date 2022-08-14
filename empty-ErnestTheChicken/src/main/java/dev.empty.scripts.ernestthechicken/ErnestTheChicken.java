package dev.empty.scripts.ernestthechicken;

import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;
import tasks.CompleteQuest;
import tasks.ScriptTask;

@PluginDescriptor(name = "Empty Ernest The Chicken", enabledByDefault = false)
@Extension
public class ErnestTheChicken extends Script
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
