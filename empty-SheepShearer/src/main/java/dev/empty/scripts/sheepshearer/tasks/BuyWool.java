package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.*;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.quests.Quests;


public class BuyWool implements ScriptTask
{

    @Override
    public boolean validate()
    {
        return !Inventory.contains(1760) && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {
        // stuck in between buying and withdrawing wool, needs better validation statements
        if (Inventory.contains(ItemID.COINS_995))
        {
            GrandExchange.buy(ItemID.BALL_OF_WOOL, 20, GrandExchange.getPrice());
            return 3000;
        }
        GrandExchange.openBank();

        return 3000;
    }


}
