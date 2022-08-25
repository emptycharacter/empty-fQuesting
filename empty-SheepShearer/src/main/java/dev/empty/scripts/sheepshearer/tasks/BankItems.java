package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.quests.Quests;

public class BankItems implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {


        if (!Bank.isOpen())
        {
            GrandExchange.openBank();
            return 1000;
        }

        Bank.depositInventory();

        return 3000;
    }
}
