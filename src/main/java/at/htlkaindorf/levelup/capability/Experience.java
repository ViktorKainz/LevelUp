package at.htlkaindorf.levelup.capability;

public class Experience implements IExperience {
    int experience = 0;
    int baseLevel = 100;
    float factor = 1.1f;

    @Override
    public void add(int points) {
        experience += points;
    }

    @Override
    public void set(int points) {
        experience = points;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getLevel() {
        int l = -1;
        int e;
        do {
            l++;
            e = baseLevel * (int)Math.pow(factor,l);
        } while(experience > e);
        return l;
    }
}
