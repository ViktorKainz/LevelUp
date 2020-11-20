package at.htlkaindorf.levelup.capability.experience;

public interface IExperience {
    void add(ExperienceType type, int points);

    void set(ExperienceType type, int points);

    int getExperience(ExperienceType type);

    int getLevel(ExperienceType type);

    int getExperienceOfLevel(int level);
}