package at.htlkaindorf.levelup.capability.skillpoint;

import at.htlkaindorf.levelup.capability.experience.ExperienceType;

import java.util.HashMap;
import java.util.Map;

public class SkillPoint implements ISkillPoint {

    private Map<ExperienceType, Integer> experience = new HashMap<>();

    @Override
    public void add(ExperienceType type, int points) {
        experience.merge(type, points, (base, added) -> base + added);
    }

    @Override
    public void set(ExperienceType type, int points) {
        experience.put(type, points);
    }

    @Override
    public int get(ExperienceType type) {
        return experience.get(type) == null ? 0 : experience.get(type);
    }
}