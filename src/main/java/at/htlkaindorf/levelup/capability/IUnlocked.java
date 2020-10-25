package at.htlkaindorf.levelup.capability;

import net.minecraft.util.ResourceLocation;

import java.util.List;

public interface IUnlocked {
    void add(ResourceLocation resource);
    boolean isUnlocked(ResourceLocation resource);
    List<ResourceLocation> get();
}
