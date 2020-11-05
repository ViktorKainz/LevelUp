package at.htlkaindorf.levelup.capability.unlocked;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Unlocked implements IUnlocked{

    private List<String> unlocked = new ArrayList<>();

    @Override
    public void add(String resource) {
        unlocked.add(resource);
    }

    @Override
    public boolean isUnlocked(String resource) {
        return unlocked.contains(resource);
    }

    @Override
    public List<String> get() {
        return unlocked;
    }
}
