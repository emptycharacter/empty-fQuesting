package dev.empty.scripts.sheepshearer;

import com.google.inject.Inject;
import com.google.inject.Provides;
import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import dev.empty.scripts.sheepshearer.tasks.AttainWool;
import dev.empty.scripts.sheepshearer.tasks.CompleteQuest;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;

@PluginDescriptor(name = "Empty Sheep Shearer", enabledByDefault = false)
@Extension
public class SheepShearerPlugin extends Script
{

    private static final ScriptTask[] TASKS = new ScriptTask[] {
            new AttainWool(),
            new CompleteQuest(),
    };
    @Inject
    private SheepShearerConfig config;

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

    @Provides
    SheepShearerConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(SheepShearerConfig.class);
    }

}
