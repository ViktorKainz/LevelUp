package at.htlkaindorf.levelup.capability.experience;

import java.util.HashMap;
import java.util.Map;

public class Experience implements IExperience {

    private final Map<ExperienceType, Integer> experience = new HashMap<>();
    private final int baseLevel = 100;

    @Override
    public void add(ExperienceType type, int points) {
        experience.merge(type, points, (base, added) -> base + added);
    }

    @Override
    public void set(ExperienceType type, int points) {
        experience.put(type, points);
    }

    @Override
    public int getExperience(ExperienceType type) {
        return experience.get(type) == null ? 0 : experience.get(type);
    }

    @Override
    public int getLevel(ExperienceType type) {
        int l = 1;
        int e = baseLevel;
        while (getExperience(type) > e) {
            e += baseLevel * l;
            l++;
        }
        return l-1;
    }

    @Override
    public int getExperienceOfLevel(int level) {
        level++;
        int e = baseLevel;
        for(int i = 2; i < level; i++) {
            e += baseLevel * i;
        }
        return e;
    }
}