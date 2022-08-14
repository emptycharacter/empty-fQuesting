package dev.empty.scripts.sheepshearer;

import dev.empty.scripts.sheepshearer.tasks.BuyItems;
import dev.empty.scripts.sheepshearer.tasks.CompleteQuest;
import dev.empty.scripts.sheepshearer.tasks.ScriptTask;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;

@PluginDescriptor(name = "Empty Sheep Shearer", enabledByDefault = false)
@Extension
public class SheepShearer extends Script
{
    private static final ScriptTask[] TASKS = new ScriptTask[] {
        new BuyItems(),
        new CompleteQuest()
    };

    @Override
    public void onStart(String... args)
    {
    }

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

}
