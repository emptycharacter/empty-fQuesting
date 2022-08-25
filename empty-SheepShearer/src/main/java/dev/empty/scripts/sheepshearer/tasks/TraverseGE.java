package dev.empty.scripts.sheepshearer.tasks;

import dev.empty.scripts.sheepshearer.framework.ScriptTask;
import net.runelite.api.Player;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.pathfinder.model.BankLocation;
import net.unethicalite.api.quests.Quests;

public class TraverseGE implements ScriptTask
{
    @Override
    public boolean validate()
    {
        return Quests.getState(Quest.SHEEP_SHEARER) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {


        Player local = Players.getLocal();

        if (!BankLocation.GRAND_EXCHANGE_BANK.getArea().contains(local))
        {
            Movement.walkTo(BankLocation.GRAND_EXCHANGE_BANK.getArea());
            return 1000;
        }


        return 3000;
    }
}
