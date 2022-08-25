package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldArea;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.quests.Quests;

public class TraverseQuestStart implements ScriptTask
{
    private static WorldArea questStart = new WorldArea(3190, 3273, 1, 1, 0);
    @Override
    public boolean validate()
    {
        return Inventory.contains(ItemID.BALL_OF_WOOL) && Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {

        Player local = Players.getLocal();

        if (!questStart.contains(local))
        {
            Movement.walkTo(questStart);
            return 1000;
        }

        return 3000;
    }
}
