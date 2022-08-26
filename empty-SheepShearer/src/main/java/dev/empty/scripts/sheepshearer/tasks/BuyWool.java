package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.http.api.ge.GrandExchangeClient;
import net.unethicalite.api.commons.Time;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.quests.Quests;

public class BuyWool implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return Inventory.contains(ItemID.COINS_995) && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {

        if (!Bank.isOpen() && !Inventory.contains(ItemID.COINS_995))
        {
            GrandExchange.openBank();
            return 1000;
        }

        Item gold = Inventory.getFirst(ItemID.COINS_995);
        if (gold == null)
        {
            Bank.withdraw(ItemID.COINS_995, 5000, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        if (!GrandExchange.isOpen())
        {
            GrandExchange.buy(ItemID.BALL_OF_WOOL, 20, GrandExchange.getPrice());
            return 1000;
        }

        if (Bank.isOpen() && Inventory.contains(1760))
        {
            GrandExchange.open();

        }



//            GrandExchange.openBank();
//            Time.sleep(4000);
//            Bank.withdraw(ItemID.COINS_995, 5000, Bank.WithdrawMode.DEFAULT);

            GrandExchange.buy(ItemID.BALL_OF_WOOL, 20, GrandExchange.getPrice());

//            Time.sleep(12_000);
//
//        GrandExchange.openBank();
//        Time.sleep(4000);
//
//        Bank.depositInventory();
//        Time.sleep(4000);
//
//        Bank.withdraw(ItemID.BALL_OF_WOOL, 20, Bank.WithdrawMode.ITEM);




        return 2000;
    }
}
