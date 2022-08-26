package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.ItemID;
import net.unethicalite.api.items.Inventory;

public class BuyWool implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return !Inventory.contains(ItemID.BALL_OF_WOOL);
    }

    @Override
    public int execute()
    {

        return 0;
    }
}
