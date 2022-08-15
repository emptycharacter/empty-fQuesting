package dev.empty.scripts.cooksassistant.tasks;

import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.entities.TileItems;
import net.unethicalite.api.entities.TileObjects;
import net.unethicalite.api.items.Bank;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.unethicalite.api.movement.pathfinder.model.Teleport;
import net.unethicalite.api.movement.pathfinder.model.TeleportSpell;

public class GetIngredients implements ScriptTask
{

    private static final WorldPoint LumbyBank = new WorldPoint(3208, 3221, 2);
    private static final WorldArea CowGateArea = new WorldArea(3252, 3266, 1,1, 0);
    private static final WorldPoint CowGate = new WorldPoint(3252, 3266,0);

    private static final WorldArea CowPatchArea = new WorldArea(3253, 3272, 1,1, 0);
    private static final WorldPoint CowPatch = new WorldPoint(3253, 3272, 0);
    private static final WorldArea ChickenPatchArea = new WorldArea(3230, 3298, 1,1,0);
    private static final WorldArea WheatArea = new WorldArea(3162, 3292, 1,1,0);
    private static final WorldArea Miller = new WorldArea(3167, 3308, 1,1,2);
    private static final WorldArea FlourBin = new WorldArea(3165, 3306, 1,1,0);

    private boolean wheatPicked = false;
    private boolean hopperFilled = false;
    private boolean leverPulled = false;



    @Override
    public boolean validate()
    {
//        return true;
        return !Inventory.contains(ItemID.BUCKET_OF_MILK) || !Inventory.contains(ItemID.EGG) || !Inventory.contains(ItemID.POT_OF_FLOUR);
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();

        TileObject booth = TileObjects.getFirstAt(LumbyBank, x -> x.hasAction("Bank", "Collect"));
        if (!Bank.isOpen() && !Inventory.contains(ItemID.BUCKET) && !Inventory.contains(ItemID.POT))
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

        Item bucket = Inventory.getFirst(ItemID.BUCKET);
        if (bucket == null && !Inventory.contains(ItemID.BUCKET_OF_MILK))
        {
            Bank.withdraw(ItemID.BUCKET, 1, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        Item pot = Inventory.getFirst(ItemID.POT);
        if (pot == null && !Inventory.contains(ItemID.BUCKET_OF_MILK))
        {
            Bank.withdraw(ItemID.POT, 1, Bank.WithdrawMode.ITEM);
            return 1000;
        }

        if (!CowPatchArea.contains(local) && !Inventory.contains(ItemID.BUCKET_OF_MILK))
        {
            Movement.walkTo(CowPatch);
            return 1000;
        }

        if (!Inventory.contains(ItemID.BUCKET_OF_MILK))
        {
            TileObject cow = TileObjects.getNearest("Dairy cow");
            cow.interact("Milk");
            return 5000;
        }

        if (!ChickenPatchArea.contains(local) && !Inventory.contains(ItemID.EGG))
        {
            Movement.walkTo(ChickenPatchArea);
            return 1000;
        }

        if (!Inventory.contains(ItemID.EGG))
        {
            TileItem egg = TileItems.getNearest("Egg");
            egg.pickup();
            return 2000;
        }

        if (!WheatArea.contains(local) && !Inventory.contains(ItemID.GRAIN) && wheatPicked == false)
        {
            Movement.walkTo(WheatArea);
            return 1000;
        }

        if (!Inventory.contains(ItemID.GRAIN) && wheatPicked ==  false)
        {
            TileObject wheat = TileObjects.getNearest("Wheat");
            wheat.interact("Pick");
            wheatPicked = true;
            return 2000;
        }

        if (!Miller.contains(local) && Inventory.contains(ItemID.GRAIN) && hopperFilled == false)
        {
            Movement.walkTo(Miller);
            return 1000;
        }

        if (Inventory.contains(ItemID.GRAIN) && hopperFilled == false)
        {
            TileObject hopper = TileObjects.getNearest("Hopper");
            hopper.interact("Fill");
            try
            {
                Thread.sleep(7000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            TileObject lever = TileObjects.getNearest("Hopper controls");
            lever.interact("Operate");
            hopperFilled = true;
            return 7000;
        }


        if (!FlourBin.contains(local))
        {
            Movement.walkTo(FlourBin);
            return 1000;
        }

        if (Inventory.contains(ItemID.POT))
        {
            TileObject bin = TileObjects.getNearest("Flour bin");
            bin.interact("Empty");
            return 1000;
        }

        wheatPicked = false;
        hopperFilled = false;
        leverPulled = false;






        return 1000;
    }
}
