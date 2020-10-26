package at.htlkaindorf.levelup.capability.unlocked;

import java.util.List;

public interface IUnlocked {
    void add(String resource);
    boolean isUnlocked(String resource);
    List<String> get();
}
