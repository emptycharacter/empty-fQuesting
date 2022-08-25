package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.ItemID;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.quests.Quests;

public class WithdrawWool implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {

        Bank.withdraw(ItemID.BALL_OF_WOOL, 20, Bank.WithdrawMode.ITEM);

        return 3000;
    }
}
