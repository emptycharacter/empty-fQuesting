package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.ItemID;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.quests.Quests;


public class BuyWool implements ScriptTask
{

    @Override
    public boolean validate()
    {
        return Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {
        GrandExchange.buy(ItemID.BALL_OF_WOOL, 20, GrandExchange.getPrice());

        return 3000;
    }


}
