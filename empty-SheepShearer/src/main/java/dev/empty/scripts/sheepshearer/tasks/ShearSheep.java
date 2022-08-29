package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.GrandExchange;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.unethicalite.api.quests.Quests;

public class ShearSheep implements ScriptTask
{

    private static final WorldPoint LumbyBank = new WorldPoint(3208, 3221, 2);
    private static final WorldPoint SheepPatchPoint = new WorldPoint(3208, 3260, 0);
    private static final WorldArea SheepPatchArea = new WorldArea(3208, 3260, 40, 40, 0);
    private static final WorldPoint Spinner = new WorldPoint(3209, 3213, 1);

    @Override
    public boolean validate()
    {
        return !Inventory.isFull() && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();

        TileObject booth = TileObjects.getFirstAt(LumbyBank, x -> x.hasAction("Bank", "Collect"));
        if (!Bank.isOpen() && !Inventory.contains(ItemID.SHEARS))
        {
            if (Movement.isWalking())
            {
                return 1000;
            }

            if (booth == null || booth.distanceTo(local) > 20 || !Reachable.isInteractable(booth))
            {
                Movement.walkTo(LumbyBank);
                return 1000;
            }
            booth.interact("Bank");
        }

        Item shears = Inventory.getFirst(ItemID.SHEARS);
        if (shears == null)
        {
            Bank.withdraw(ItemID.SHEARS, 1, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        if (SheepPatchPoint.distanceTo(local) > 20 && Inventory.getFreeSlots() != 4)
        {
            Movement.walkTo(SheepPatchPoint);
            return 1000;
        }

//24 4

        if (Inventory.getFreeSlots() != 4)
        {
            NPC sheep = NPCs.getNearest("Sheep");
            sheep.interact("Shear");
            return 500;
        }

        if (Spinner.distanceTo(local) != 0 && Inventory.contains(ItemID.WOOL))
        {
            Movement.walkTo(Spinner);
            return 1000;
        }

        if (Inventory.contains(ItemID.WOOL))
        {
            TileObject wheel = TileObjects.getNearest("Spinning wheel");
            wheel.interact("Spin");
            wheel.
            return 1000;
        }







        return 2000;
    }
}
