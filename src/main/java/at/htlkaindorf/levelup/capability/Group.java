package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class Group {

    public static List<Group> groups;

    private String name;
    private ExperienceType type;
    private int level;
    private List<ResourceLocation> items;

    public Group(String name, ExperienceType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    @Override
    public String toString() {
        String resources = "";
        for(ResourceLocation r : items) {
            resources += r.toString() + " ";
        }
        return String.format("Group: %s Type: %s Level: %d Items: %s",name,type.toString(),level,resources);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExperienceType getType() {
        return type;
    }

    public void setType(ExperienceType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<ResourceLocation> getItems() {
        return items;
    }

    public void setItems(List<ResourceLocation> items) {
        this.items = items;
    }
}
