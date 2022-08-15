package dev.empty.scripts.cooksassistant;

import dev.empty.scripts.cooksassistant.tasks.CompleteQuest;
import dev.empty.scripts.cooksassistant.tasks.GetIngredients;
import dev.empty.scripts.cooksassistant.tasks.ScriptTask;
import net.runelite.client.plugins.PluginDescriptor;
import net.unethicalite.api.plugins.Script;
import org.pf4j.Extension;

// This annotation is required in order for the client to detect it as a plugin/script.
@PluginDescriptor(name = "Empty Cooks Assistant", enabledByDefault = false)
@Extension
public class CooksAssistant extends Script
{
    private static final ScriptTask[] TASKS = new ScriptTask[] {
            new GetIngredients(),
            new CompleteQuest()
    };


    /**
     * Gets executed whenever a script starts.
     * Can be used to for example initialize script settings, or perform tasks before starting the loop logic.
     *
     * @param args any script arguments passed to the script, separated by spaces.
     */
    @Override
    public void onStart(String... args)
    {
    }

    /**
     * Any logic passed inside this method will be repeatedly executed by an internal loop that calls this method.
     *
     * @return the amount of milliseconds to sleep after each loop iteration.
     */
    @Override
    protected int loop()
    {
        // Here I use task-based logic. You can also just write the entire script logic
        for (ScriptTask task : TASKS)
        {
            if (task.validate())
            {
                // Perform the task and store the sleep value
                int sleep = task.execute();
                // If this task blocks the next task, return the sleep value and the internal loop will sleep for this amount of time
                if (task.blocking())
                {
                    return sleep;
                }
            }
        }

        return 1000;
    }
}
