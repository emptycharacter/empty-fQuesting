package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.pluginutils.bank.Banks;
import com.google.inject.Inject;
import dev.empty.scripts.sheepshearer.SheepShearerConfig;
import dev.empty.scripts.sheepshearer.enums.PathType;
import net.runelite.api.Item;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;


public class AttainWool implements ScriptTask
{
    @Inject
    private SheepShearerConfig config;

    @Override
    public boolean validate()
    {
        return !Inventory.contains(ItemID.BALL_OF_WOOL);
    }

    @Override
    public int execute()
    {


        Player local = Players.getLocal();

        if (config.pathType() == PathType.BUY)
        {
            if (!Banks.GrandExchangeBank.contains(local))
            {
                Movement.walkTo(Banks.GrandExchangeBank);
                return 1000;
            }
        }

        if (!Bank.isOpen() && !Inventory.contains(ItemID.COINS_995))
        {
            Item wool = Bank.getFirst(ItemID.BALL_OF_WOOL);
            if (wool.getQuantity() >= 20)
            {
                Bank.withdraw(ItemID.BALL_OF_WOOL, 20, Bank.WithdrawMode.ITEM);
            }
            GrandExchange.openBank();
            return 1000;
        }

        if (!Inventory.contains(ItemID.COINS_995))
        {
            Bank.withdrawAll(ItemID.COINS_995, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        if (!GrandExchange.isOpen() && !Inventory.contains(1760))
        {
            GrandExchange.open();
            return 2000;
        }

        if (!Inventory.contains(1760))
        {
//            GrandExchange.buy(ItemID.BALL_OF_WOOL, 20, GrandExchange.getPrice(), true, true);
            GrandExchange.buy(ItemID.BALL_OF_WOOL,20, GrandExchange.getPrice());
            return 3000;
        }


        if (!Bank.isOpen())
        {
            GrandExchange.openBank();

            return 3000;
        }

        if (Inventory.contains(ItemID.COINS_995))
        {
            Bank.depositInventory();
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Bank.withdraw(ItemID.BALL_OF_WOOL, 20, Bank.WithdrawMode.ITEM);
            return 3000;
        }

        // This
        // check back at ge if we have at leaste 20 balls of wool
        // if not then buy it off of GE and



        return 3000;
    }
}
