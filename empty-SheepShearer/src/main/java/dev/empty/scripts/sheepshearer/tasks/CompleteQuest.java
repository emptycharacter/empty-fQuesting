package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.quests.Quests;

public class CompleteQuest implements ScriptTask
{

    private static WorldArea questStart = new WorldArea(3189, 3277, 1, 1, 0);

    @Override
    public boolean validate()
    {
        return Inventory.getFirst(ItemID.BALL_OF_WOOL).getQuantity() == 20 && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();

        Item wool = Inventory.getFirst(ItemID.BALL_OF_WOOL);
        if (wool == null || wool.getQuantity() != 20)
        {
            return 1000;
        }

        if (!questStart.contains(local))
        {
            Movement.walkTo(questStart);
        }

        return 1000;
    }
}
