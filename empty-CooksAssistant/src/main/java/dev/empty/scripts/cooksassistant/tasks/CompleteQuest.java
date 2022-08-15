package dev.empty.scripts.cooksassistant.tasks;

import net.runelite.api.*;
import net.runelite.api.coords.WorldArea;
import net.unethicalite.api.entities.NPCs;
import net.unethicalite.api.entities.Players;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;
import net.unethicalite.api.movement.Reachable;
import net.unethicalite.api.quests.Quests;
import net.unethicalite.api.widgets.Dialog;

public class CompleteQuest implements ScriptTask
{

    private static final WorldArea CooksQuest = new WorldArea(3207, 3215, 1,1, 0);


    @Override
    public boolean validate()
    {
//        return false;
        return Inventory.contains(ItemID.BUCKET_OF_MILK) && Inventory.contains(ItemID.EGG) && Inventory.contains(ItemID.POT_OF_FLOUR) && Quests.getState(Quest.COOKS_ASSISTANT) != QuestState.FINISHED;
    }

    @Override
    public int execute()
    {
        Player local = Players.getLocal();
        if (Movement.isWalking())
        {
            return 1000;
        }

        NPC cook = NPCs.getNearest("Cook");
        if (cook == null)
        {
            Movement.walkTo(CooksQuest);
            return 1000;
        }

        if (!Reachable.isInteractable(cook))
        {
            Movement.walkTo(cook);
            return 1000;
        }


        //starts quest
        Dialog.invokeDialog(DialogOption.NPC_CONTINUE,
                            DialogOption.CHAT_OPTION_ONE,
                            DialogOption.PLAYER_CONTINUE,
                            DialogOption.NPC_CONTINUE,
                            DialogOption.NPC_CONTINUE,
                            DialogOption.CHAT_OPTION_ONE,
                            DialogOption.PLAYER_CONTINUE
                            );
        // then u just continue some dialog then u complete the quest

        cook.interact("Talk-to");


        return 1000;
    }
}
