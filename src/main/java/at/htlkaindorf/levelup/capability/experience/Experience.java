package at.htlkaindorf.levelup.capability.experience;

import java.util.HashMap;
import java.util.Map;

public class Experience implements IExperience {

    private final Map<ExperienceType, Integer> experience = new HashMap<>();
    private final int baseLevel = 100;
    private final double factor = 1.1;

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
        int l = 0;
        int e = baseLevel;
        while (getExperience(type) > e) {
            e += baseLevel * Math.pow(factor, l);
            l++;
        }
        return l;
    }

    @Override
    public int getExperienceOfLevel(int level) {
        int e = baseLevel;
        for(int i = 0; i < level; i++) {
            e += baseLevel * Math.pow(factor, i);
        }
        return e;
    }
}