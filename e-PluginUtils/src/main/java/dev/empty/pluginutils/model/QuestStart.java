package dev.empty.pluginutils.model;

import net.runelite.api.coords.WorldArea;

public enum QuestStart
{
    COOKS_ASSISTANT(new WorldArea(3208, 3213, 1, 1, 0)),
    SHEEP_SHEARER(new WorldArea(3190, 3273, 1, 1, 0)),
    X_MARKS_THE_SPOT(new WorldArea(3229, 3240, 1, 1, 0)),
    PIRATES_TREASURE(new WorldArea(3053, 3251, 1, 1, 0)),
    RUNE_MYSTERIES(new WorldArea(3210, 3222, 1, 1, 0)),
    ROMEO_AND_JULIET(new WorldArea(3211, 3424, 1, 1, 0)),
    THE_RESTLESS_GHOST(new WorldArea(3241, 3210, 1, 1, 0)),
    PRINCE_ALI_RESCUE(new WorldArea(3300, 3162, 1, 1, 0)),
    MISTHALIN_MYSTERY(new WorldArea(3236, 3157, 1, 1, 0)),
    IMP_CATCHER(new WorldArea(3104, 3163, 1, 1, 0)),
    ERNEST_THE_CHICKEN(new WorldArea(3110, 3328, 1, 1, 0)),
    VAMPYRE_SLAYER(new WorldArea(3098, 3267, 1, 1, 0)),
    DORICS_QUEST(new WorldArea(2951, 3450, 1, 1, 0)),
    BLACK_KNIGHTS_FORTRESS(new WorldArea(2959, 3366, 1, 1, 2)),
    SHIELD_OF_ARRAV(new WorldArea(3210, 3493, 1, 1, 0)),
    DEMON_SLAYER(new WorldArea(3204, 3424, 1, 1, 0)),
    BELOW_ICE_MOUNTAIN(new WorldArea(3000, 3435, 1, 1, 0)),
    THE_KNIGHTS_SWORD(new WorldArea(2977, 3341, 1, 1, 0)),
    WITCHS_POTION(new WorldArea(2968, 3204, 1, 1, 0)),
    THE_CORSAIR_CURSE(new WorldArea(3032, 3272, 1, 1, 0)),
    GOBLIN_DIPLOMACY(new WorldArea(2957, 3508, 1, 1, 0)),
    DRAGON_SLAYER_ONE(new WorldArea(3191, 3359, 1, 1, 0)),
    ;


    private final WorldArea area;


    QuestStart(WorldArea area)
    {
        this.area = area;
    }
}
