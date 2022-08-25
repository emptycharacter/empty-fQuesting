package dev.empty.scripts.sheepshearer;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import dev.empty.scripts.sheepshearer.tasks.*;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;

@PluginDescriptor(name = "Empty Sheep Shearer", enabledByDefault = false)
@Extension
public class SheepShearerPlugin extends Script
{

    private static final ScriptTask[] TASKS = new ScriptTask[] {
//            new TraverseGE(),
            new WithdrawGold(),
            new BuyWool(),
            new BankItems(),
            new WithdrawWool(),
//            new TraverseQuestStart(),
//            new CompleteQuest(),
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
