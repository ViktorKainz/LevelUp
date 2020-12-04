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
            "Types: Mining, Crafting, Farming, Building, Fighting",
            "Name,Type,Level"
    })
    public static String[] groups = {
            "Stone Mining Tools,Mining,1",
            "Iron Mining Tools,Mining,2",
            "Gold Mining Tools,Mining,3",
            "Diamond Mining Tools,Mining,4",
            "Magma Mining Tools,Mining,5",
            "Ruby Mining Tools,Mining,6",
            "Sapphire Mining Tools,Mining,7",
            "Wither Mining Tools,Mining,8",
            "Ender Mining Tools,Mining,9",

            "More Woods,Crafting,1",
            "More Stone,Crafting,2",
            "More Fence,Crafting,3",
            "More Concrete,Crafting,4",
            "More Chest,Crafting,5",
            "More Woods 2,Crafting,6",
            "More Redstone Stuff,Crafting,7",
            "More Rails,Crafting,8",
            "More Hopper,Crafting,9",
            "More Stone 2,Crafting,10",
            "More Ender Eye,Crafting,11",
            "More Woods 3,Crafting,12",
            "More Ender Chest,Crafting,13",
            "More Shulker Boxes,Crafting,14",
            "More Ender Diamond,Crafting,15",
            "More Magma Ingot,Crafting,16",
            "More Wither Ingot,Crafting,17",

            "Basic Wood Building,Building,1",
            "Wool Building,Building,2",
            "Advanced Wood Building,Building,3",
            "Basic Stone Building,Building,4",
            "Brick Building,Building,5",
            "Advanced Stone Building,Building,6",
            "Iron and Glass Building,Building,7",
            "Basic decoration Building,Building,8",
            "Concrete Powder Building,Building,9",
            "Enchanting Building,Building,10",
            "Brewing Building,Building,11",
            "Basic Redstone Building,Building,12",
            "Advanced decoration Building,Building,13",
            "Advanced Redstone Building,Building,14",
            "Rails Building,Building,15",
            "Ender Eye Crafting,Building,16"
    };

    @Config.Comment({
            "Line starts with the group name.",
            "The resource locations of the Items are split by a ,",
            "and Groups are split by a new line",
            "Name,resource location,resource location,..."
    })
    public static String[] groupsRecipes = {
            "Stone Mining Tools,minecraft:stone_pickaxe,minecraft:stone_shovel",
            "Iron Mining Tools,minecraft:iron_pickaxe,minecraft:iron_shovel,minecraft:torch,minecraft:furnace",
            "Gold Mining Tools,minecraft:gold_pickaxe,minecraft:gold_shovel",
            "Diamond Mining Tools,minecraft:diamond_pickaxe,minecraft:diamond_shovel",
            "Magma Mining Tools,levelup:magma_pickaxe,levelup:magma_shovel",
            "Ruby Mining Tools,levelup:ruby_pickaxe,levelup:ruby_shovel",
            "Sapphire Mining Tools,levelup:sapphire_pickaxe,levelup:sapphire_shovel",
            "Wither Mining Tools,levelup:wither_pickaxe,levelup:wither_shovel",
            "Ender Mining Tools,levelup:ender_pickaxe,levelup:ender_shovel",

            "Basic Wood Building," +
                    "minecraft:fence,minecraft:spruce_fence,minecraft:birch_fence,minecraft:jungle_fence,minecraft:dark_oak_fence,minecraft:acacia_fence," +
                    "minecraft:fence_gate,minecraft:spruce_fence_gate,minecraft:birch_fence_gate,minecraft:jungle_fence_gate,minecraft:dark_oak_fence_gate,minecraft:acacia_fence_gate," +
                    "minecraft:oak_door,minecraft:spruce_door,minecraft:birch_door,minecraft:jungle_door,minecraft:acacia_door,minecraft:dark_oak_door",
            "Wool Building,minecraft:wool,minecraft:carpet,minecraft:bed",
            "Advanced Wood Building," +
                    "minecraft:oak_stairs,minecraft:spruce_stairs,minecraft:birch_stairs,minecraft:jungle_stairs,minecraft:acacia_stairs,minecraft:dark_oak_stairs" +
                    "minecraft:boat,minecraft:spruce_boat,minecraft:birch_boat,minecraft:jungle_boat,minecraft:acacia_boat,minecraft:dark_oak_boat"+
                    "minecraft:wooden_slab,minecraft:sign,minecraft:ladder,minecraft_stand,minecraft:trapdoor",
            "Basic Stone Building,minecraft:cobblestone_wall,minecraft:stone_stairs,minecraft:stone_slab",
            "Advanced Stone Building," +
                    "minecraft:mossy_cobblestone,minecraft:stonebrick," +
                    "minecraft:stone_brick_stairs,minecraft:sandstone_stairs,minecraft:red_sandstone_stairs",
            "Brick Building," +
                    "minecraft:brick_block,minecraft:brick_stairs," +
                    "minecraft:nether_brick,minecraft:nether_brick_stairs,minecraft:nether_brick_fence",
            "Iron and Glass Building," +
                    "minecraft:glass,minecraft:glass_pane,minecraft:iron_bars,minecraft:flint_and_steel," +
                    "minecraft:iron_trapdoor,minecraft:iron_door,minecraft:hopper",
            "Basic decoration Building,minecraft:item_frame,minecraft:book, minecraft:bookshelf",
            "Concrete Powder Building,minecraft:concrete_powder",
            "Enchanting Building,minecraft:anvil,minecraft:enchanting_table",
            "Brewing Building,minecraft:brewing_stand,minecraft:fermented_spider_eye",
            "Basic Redstone Building," +
                    "minecraft:lever,minecraft:stone_pressure_plate,minecraft:wood_pressure_plate,minecraft:noteblock" +
                    "minecraft:heavy_weighted_pressure_plate,minecraft:light_weighted_pressure_plate," +
                    "minecraft:redstone_torch,minecraft:wood_button,minecraft:stone_button,minecraft:piston",
            "Advanced decoration Building," +
                    "minecraft:banner,minecraft:painting,minecraft:flower_pot," +
                    "minecraft:stained_glass,minecraft:stained_glass_pane",
            "Advanced Redstone Building," +
                    "minecraft:sticky_piston,minecraft:dispenser,minecraft:tnt,minecraft:redstone_lamp," +
                    "minecraft:tripwire_hook,minecraft:trapped_chest,minecraft:daylight_detector," +
                    "minecraft:dropper,minecraft:repeater,minecraft:comparator,minecraft:observer",
            "Rails Building," +
                    "minecraft:rail,minecraft:activator_rail,minecraft:detector_rail,minecraft:golden_rail," +
                    "minecraft:minecart,minecraft:chest_minecraft,minecraft:furnace_minecart," +
                    "minecraft:tnt_minecart,minecraft:hopper_minecart",
            "Ender Eye Crafting,minecraft:ender_eye,minecraft:ender_chest"

    };

    @Config.Comment({
            "Line starts with the group name.",
            "The resource locations and the amount of the Items are split by a ,",
            "and Groups are split by a new line",
            "Name,resource location,multiplier,resource location,multiplier,..."
    })
    public static String[] groupsRecipesAmount = {
            "Diamond Mining Tools,minecraft:torch,2",
            "Ruby Mining Tools,minecraft:torch,2.5",
            "Ender Mining Tools,minecraft:torch,3",

            "More Woods,minecraft:wood,2,minecraft:wooden_slab,2," +
                    "minecraft:oak_stairs,2,minecraft:spruce_stairs,2,minecraft:birch_stairs,2,minecraft:jungle_stairs,2,minecraft:acacia_stairs,2,minecraft:dark_oak_stairs,2",
            "More Woods 2,minecraft:wood,3,minecraft:wooden_slab,2.5," +
                    "minecraft:oak_stairs,2.5,minecraft:spruce_stairs,2.5,minecraft:birch_stairs,2.5,minecraft:jungle_stairs,2.5,minecraft:acacia_stairs,2.5,minecraft:dark_oak_stairs,2.5",
            "More Woods 3,minecraft:wood,4,minecraft:wooden_slab,3," +
                    "minecraft:oak_stairs,3,minecraft:spruce_stairs,3,minecraft:birch_stairs,3,minecraft:jungle_stairs,3,minecraft:acacia_stairs,3,minecraft:dark_oak_stairs,3",

            "More Stone,minecraft:stonebrick,2,minecraft:stone_stairs,2,minecraft:stone_slab,2",
            "More Stone 2,minecraft:stonebrick,3,minecraft:stone_stairs,3,minecraft:stone_slab,3",

            "More Fence,minecraft:" +
                    "fence,2,minecraft:spruce_fence,2,minecraft:birch_fence,2,minecraft:jungle_fence,2," +
                    "minecraft:dark_oak_fence,2,minecraft:acacia_fence,2,minecraft:cobblestone_wall,2",
            "More Concrete,minecraft:concrete_powder,2",
            "More Chest,minecraft:chest,2,minecraft:trapped_chest,2",
            "More Redstone Stuff," +
                    "minecraft:piston,2,minecraft:sticky_piston,2,minecraft:dispenser,2," +
                    "minecraft:daylight_detector,2,minecraft:dropper,2,minecraft:repeater,2," +
                    "minecraft:comparator,2,minecraft:observer,2",
            "More Rails,minecraft:rail,2,minecraft:activator_rail,2,minecraft:detector_rail,2,minecraft:golden_rail,2",
            "More Hopper,minecraft:hopper,2",
            "More Ender Eye,minecraft:ender_eye,2",
            "More Ender Chest,minecraft:ender_chest,2",
            "More Shulker Boxes,minecraft:purple_shulker_box,2",
            "More Ender Diamond,levelup:ender_diamond,2",
            "More Magma Ingot,levelup:magma_ingot,2",
            "More Wither Ingot,levelup:wither_ingot,2"
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
