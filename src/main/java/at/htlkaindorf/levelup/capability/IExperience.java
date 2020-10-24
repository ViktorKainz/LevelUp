package at.htlkaindorf.levelup.capability;

public interface IExperience {
    void add(ExperienceType type, int points);
    void set(ExperienceType type, int points);
    int getExperience(ExperienceType type);
    int getLevel(ExperienceType type);
}