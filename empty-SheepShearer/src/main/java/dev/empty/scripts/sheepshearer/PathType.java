package dev.empty.scripts.sheepshearer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public enum PathType
{
    BUY("Buy"),
    SHEAR("Shear");
    private final String name;
}
