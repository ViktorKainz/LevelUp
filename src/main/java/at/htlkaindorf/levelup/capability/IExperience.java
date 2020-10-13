package at.htlkaindorf.levelup.capability;

public interface IExperience {
    void add(int points);
    void set(int points);
    int getExperience();
    int getLevel();
}