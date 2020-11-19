package at.htlkaindorf.levelup.config;

import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {

    public static Map<String,Group> groups;

    private String name;
    private ExperienceType type;
    private int level;
    private List<ResourceLocation> items = new ArrayList<>();
    private Map<ResourceLocation,Integer> amounts = new HashMap<>();

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

    public boolean isUnlocked(EntityPlayer player) {
        return player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null).getLevel(type) >= level;
    }

    public static Map<String, Group> getGroups() {
        return groups;
    }

    public static void setGroups(Map<String, Group> groups) {
        Group.groups = groups;
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

    public Map<ResourceLocation, Integer> getAmounts() {
        return amounts;
    }

    public void setAmounts(Map<ResourceLocation, Integer> amount) {
        this.amounts = amount;
    }
}