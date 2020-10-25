package at.htlkaindorf.levelup.capability.skillpoint;

import at.htlkaindorf.levelup.capability.experience.ExperienceType;

public interface ISkillPoint {
    void add(ExperienceType type, int points);
    void set(ExperienceType type, int points);
    int get(ExperienceType type);
}