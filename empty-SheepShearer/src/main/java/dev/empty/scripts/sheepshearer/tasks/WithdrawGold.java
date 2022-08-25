package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.quests.Quests;

public class WithdrawGold implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return !Inventory.contains(ItemID.COINS_995) && !Inventory.contains(ItemID.BALL_OF_WOOL) && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {

        if (!Bank.isOpen())
        {
            GrandExchange.openBank();
            return 3000;
        }

        Bank.withdraw(ItemID.COINS_995, 5000, Bank.WithdrawMode.ITEM);

        return 3000;
    }

}
