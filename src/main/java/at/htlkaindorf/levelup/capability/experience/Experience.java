package at.htlkaindorf.levelup.capability.experience;

import java.util.HashMap;
import java.util.Map;

public class Experience implements IExperience {

    private Map<ExperienceType, Integer> experience = new HashMap<>();
    private int baseLevel = 100;
    private float factor = 1.1f;

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
        int l = -1;
        int e;
        do {
            l++;
            e = baseLevel * (int)Math.pow(factor,l);
        } while(experience.get(type) > e);
        return l;
    }
}