package at.htlkaindorf.levelup.capability.unlocked;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Unlocked implements IUnlocked{

    private List<ResourceLocation> unlocked = new ArrayList<>();

    @Override
    public void add(ResourceLocation resource) {
        unlocked.add(resource);
    }

    @Override
    public boolean isUnlocked(ResourceLocation resource) {
        return unlocked.contains(resource);
    }

    @Override
    public List<ResourceLocation> get() {
        return unlocked;
    }
}
