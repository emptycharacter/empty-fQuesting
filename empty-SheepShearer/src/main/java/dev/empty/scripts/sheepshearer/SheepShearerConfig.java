package dev.empty.scripts.sheepshearer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("empty-SheepShearer")
public interface SheepShearerConfig extends Config
{
    @ConfigItem(
            keyName = "PathType",
            name = "Path Type",
            description = "desc",
            position = 0
    )
    default PathType pathType()
    {
        return PathType.BUY;
    }

}
