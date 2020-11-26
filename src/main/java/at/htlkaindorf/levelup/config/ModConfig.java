package at.htlkaindorf.levelup.config;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Config(modid = LevelUp.MODID, name = "levelup")
public class ModConfig {

    @Config.Comment({
            "Group attributes are split by a , and Groups are split by a new line",
            "Types: Mining, Crafting, Farming, Building, Fighting, Enchanting",
            "Name,Type,Level"
    })
    public static String[] groups = {
            "Stone Tools,Crafting,1",
            "Iron Tools,Crafting,2",
            "Better Wood,Crafting,1"
    };

    @Config.Comment({
            "Line starts with the group name.",
            "The resource locations of the Items are split by a ,",
            "and Groups are split by a new line",
            "Name,resource location,resource location,..."
    })
    public static String[] groupsRecipes = {
            "Stone Tools,minecraft:stone_axe,minecraft:stone_pickaxe,minecraft:stone_hoe,minecraft:stone_shovel",
            "Iron Tools,minecraft:iron_axe,minecraft:iron_pickaxe,minecraft:iron_hoe,minecraft:iron_shovel"
    };

    @Config.Comment({
            "Line starts with the group name.",
            "The resource locations and the amount of the Items are split by a ,",
            "and Groups are split by a new line",
            "Name,resource location,resource location,..."
    })
    public static String[] groupsRecipesAmount = {
            "Better Wood,minecraft:oak_planks,6"
    };

    public static void init() {
        Map<String, Group> groupMap = new HashMap<>();
        for (int i = 0; i < groups.length; i++) {
            String[] group = groups[i].split(",");
            groupMap.put(group[0], new Group(group[0], ExperienceType.valueOf(group[1]), Integer.parseInt(group[2])));
        }
        for (int i = 0; i < groupsRecipes.length; i++) {
            List<ResourceLocation> resources = new ArrayList<>();
            String[] group = groupsRecipes[i].split(",");
            for (int j = 1; j < group.length; j++) {
                resources.add(new ResourceLocation(group[j]));
            }
            groupMap.get(group[0]).setItems(resources);
        }
        for (int i = 0; i < groupsRecipesAmount.length; i++) {
            Map<ResourceLocation, Double> amounts = new HashMap<>();
            String[] group = groupsRecipesAmount[i].split(",");
            for (int j = 1; j < group.length; j += 2) {
                amounts.put(new ResourceLocation(group[j]), Double.parseDouble(group[j + 1]));
            }
            groupMap.get(group[0]).setAmounts(amounts);
        }
        Group.groups = groupMap;
    }
}
