package at.htlkaindorf.levelup.capability;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;

import java.util.ArrayList;
import java.util.List;

@Config(modid = LevelUp.MODID, name = "levelup")
public class ModConfig {
    @Config.Comment({
            "Group attributes are split by a ',' and Groups are split by a new line",
            "Types: Mining, Crafting, Farming, Building, Fighting, Enchanting",
            "Name,Type,Level",
            "Name,Type,Level"
    })
    public static String groups = "Stone Tools,Crafting,1\n" +
            "Iron Tools,Crafting,2";
    @Config.Comment({
            "Line starts with the group name.",
            "The resource locations of the Items are split by a ','",
            "and Groups are split by a new line",
            "Name,resource location,resource location,...",
            "Name,resource location,resource location,..."
    })
    public static String groupsContent = "Stone Tools,minecraft:stone_axe,minecraft:stone_pickaxe,minecraft:stone_hoe,minecraft:stone_shovel\n" +
            "Iron Tools,minecraft:iron_axe,minecraft:iron_pickaxe,minecraft:iron_hoe,minecraft:iron_shovel";

    public static void init() {
        List<Group> groupList = new ArrayList<>();
        String[] groupArray = groups.split("\n");
        String[] groupContentArray = groupsContent.split("\n");
        for (int i = 0; i < groupArray.length; i++) {
            String[] group = groupArray[i].split(",");
            groupList.add(new Group(group[0], ExperienceType.valueOf(group[1]), Integer.parseInt(group[2])));
        }
        for (int i = 0; i < groupContentArray.length; i++) {
            List<ResourceLocation> resources = new ArrayList<>();
            String[] group = groupContentArray[i].split(",");
            for (int j = 1; j < group.length; j++) {
                resources.add(new ResourceLocation(group[j]));
            }
            for (int j = 0; j < groupList.size(); j++) {
                if (groupList.get(j).getName().equals(group[0])) {
                    groupList.get(j).setItems(resources);
                }
            }
        }
        Group.groups = groupList;
    }
}
