package at.htlkaindorf.levelup.config;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;

import java.util.*;

@Config(modid = LevelUp.MODID, name = "levelup")
public class ModConfig {

    @Config.Comment({
            "Group attributes are split by a , and Groups are split by a new line",
            "Types: Mining, Fighting, Farming, Building, Crafting,",
            "Name,Type,Level"
    })
    public static String[] groups = {
            "Stone Mining Tools,Mining,1",
            "Iron Mining Tools,Mining,2",
            "Gold Mining Tools,Mining,3",
            "Diamond Mining Tools,Mining,4",
            "Magma Mining Tools,Mining,5",
            "Emerald Mining Tools,Mining,6",
            "Ender Mining Tools,Mining,7",
            "Ruby Mining Tools,Mining,8",
            "Sapphire Mining Tools,Mining,9",
            "Wither Mining Tools,Mining,10",

            "Stone Fighting Tools,Fighting,1",
            "Iron Fighting Tools,Fighting,2",
            "Bow Fighting Tools,Fighting,3",
            "Gold Fighting Tools,Fighting,4",
            "Diamond Fighting Tools,Fighting,5",
            "Better Arrows Fighting,Fighting,6",
            "Magma Fighting Tools,Fighting,7",
            "Emerald Fighting Tools,Fighting,8",
            "Ender Fighting Tools,Fighting,9",
            "Ruby Fighting Tools,Fighting,10",
            "Sapphire Fighting Tools,Fighting,11",
            "Wither Fighting Tools,Fighting,12",
            "Even more Arrows,Fighting,15",

            "Stone Farming Tools,Farming,1",
            "Iron Farming Tools,Farming,2",
            "Gold Farming Tools,Farming,3",
            "Bone Meal Framing,Farming,4",
            "Diamond Farming Tools,Farming,5",
            "Magma Farming Tools,Farming,6",
            "Emerald Farming Tools,Farming,7",
            "Ender Farming Tools,Farming,8",
            "Ruby Farming Tools,Farming,9",
            "Sapphire Farming Tools,Farming,10",
            "Wither Farming Tools,Farming,11",
            "More Bone Meal,Farming,15",

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
            "Ender Eye Crafting,Building,16",

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
            "More Wither Ingot,Crafting,17"
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
            "Gold Mining Tools,minecraft:golden_pickaxe,minecraft:golden_shovel",
            "Diamond Mining Tools,minecraft:diamond_pickaxe,minecraft:diamond_shovel",
            "Emerald Mining Tools,levelup:emerald/emerald_pickaxe,levelup:emerald/emerald_shovel",
            "Magma Mining Tools,levelup:magma/magma_pickaxe,levelup:magma/magma_shovel",
            "Ruby Mining Tools,levelup:ruby/ruby_pickaxe,levelup:ruby/ruby_shovel",
            "Sapphire Mining Tools,levelup:sapphire/sapphire_pickaxe,levelup:sapphire/sapphire_shovel",
            "Wither Mining Tools,levelup:wither/wither_pickaxe,levelup:wither/wither_shovel",
            "Ender Mining Tools,levelup:ender/ender_pickaxe,levelup:ender/ender_shovel",

            "Stone Fighting Tools,minecraft:stone_sword,,minecraft:leather_boots,minecraft:leather_chestplate,minecraft:leather_helmet,minecraft:leather_leggings",
            "Iron Fighting Tools,minecraft:iron_sword,minecraft:iron_leggings,minecraft:iron_boots,minecraft:iron_chestplate,minecraft:iron_helmet",
            "Bow Fighting Tools,minecraft:bow,minecraft:arrow,minecraft:shield",
            "Gold Fighting Tools,minecraft:golden_sword,minecraft:gold_leggings,minecraft:gold_boots,minecraft:gold_chestplate,minecraft:gold_helmet",
            "Diamond Fighting Tools,minecraft:diamond_sword,minecraft:diamond_leggings,minecraft:diamond_boots,minecraft:diamond_chestplate,minecraft:diamond_helmet",
            "Better Arrows Fighting,minecraft:spectral_arrow",
            "Magma Fighting Tools,levelup:magma/magma_sword,levelup:magma/magma_leggings,levelup:magma/magma_boots,levelup:magma/magma_chestplate,levelup:magma/magma_helmet",
            "Emerald Fighting Tools,levelup:emerald/emerald_sword,levelup:emerald/emerald_leggings,levelup:emerald/emerald_boots,levelup:emerald/emerald_chestplate,levelup:emerald/emerald_helmet",
            "Ruby Fighting Tools,levelup:ruby/ruby_sword,levelup:ruby/ruby_leggings,levelup:ruby/ruby_boots,levelup:ruby/ruby_chestplate,levelup:ruby/ruby_helmet",
            "Sapphire Fighting Tools,levelup:sapphire/sapphire_sword,levelup:sapphire/sapphire_leggings,levelup:sapphire/sapphire_boots,levelup:sapphire/sapphire_chestplate,levelup:sapphire/sapphire_helmet",
            "Wither Fighting Tools,levelup:wither/wither_sword,levelup:wither/wither_leggings,levelup:wither/wither_boots,levelup:wither/wither_chestplate,levelup:wither/wither_helmet",
            "Ender Fighting Tools,levelup:ender/ender_sword,levelup:ender/ender_leggings,levelup:ender/ender_boots,levelup:ender/ender_chestplate,levelup:ender/ender_helmet",

            "Stone Farming Tools,minecraft:stone_hoe,minecraft:stone_axe",
            "Iron Farming Tools,minecraft:iron_hoe,minecraft:iron_axe",
            "Gold Farming Tools,minecraft:golden_hoe,minecraft:golden_axe",
            "Bone Meal Framing,minecraft:bone_meal_from_bone",
            "Diamond Farming Tools,minecraft:diamond_hoe,minecraft:diamond_axe",
            "Emerald Farming Tools,levelup:emerald/emerald_hoe,levelup:emerald/emerald_axe",
            "Magma Farming Tools,levelup:magma/magma_hoe,levelup:magma/magma_axe",
            "Ruby Farming Tools,levelup:ruby/ruby_hoe,levelup:ruby/ruby_axe",
            "Sapphire Farming Tools,levelup:sapphire/sapphire_hoe,levelup:sapphire/sapphire_axe",
            "Wither Farming Tools,levelup:wither/wither_hoe,levelup:wither/wither_axe",
            "Ender Farming Tools,levelup:ender/ender_hoe,levelup:ender/ender_axe",

            "Basic Wood Building," +
                    "minecraft:fence,minecraft:spruce_fence,minecraft:birch_fence,minecraft:jungle_fence,minecraft:dark_oak_fence,minecraft:acacia_fence," +
                    "minecraft:fence_gate,minecraft:spruce_fence_gate,minecraft:birch_fence_gate,minecraft:jungle_fence_gate,minecraft:dark_oak_fence_gate,minecraft:acacia_fence_gate," +
                    "minecraft:oak_door,minecraft:spruce_door,minecraft:birch_door,minecraft:jungle_door,minecraft:acacia_door,minecraft:dark_oak_door",
            "Wool Building," +
                    "minecraft:black_wool,minecraft:blue_wool,minecraft:brown_wool,minecraft:cyan_wool,minecraft:gray_wool,minecraft:green_wool,minecraft:light_blue_wool,minecraft:light_gray_wool,minecraft:lime_wool,minecraft:magenta_wool,minecraft:orange_wool,minecraft:pink_wool,minecraft:purple_wool,minecraft:red_wool,minecraft:string_to_wool,minecraft:yellow_wool" +
                    "minecraft:black_carpet,minecraft:blue_carpet,minecraft:brown_carpet,minecraft:cyan_carpet,minecraft:gray_carpet,minecraft:green_carpet,minecraft:light_blue_carpet,minecraft:light_gray_carpet,minecraft:lime_carpet,minecraft:magenta_carpet,minecraft:orange_carpet,minecraft:pink_carpet,minecraft:purple_carpet,minecraft:red_carpet,minecraft:white_carpet,minecraft:yellow_carpet" +
                    "minecraft:black_bed,minecraft:black_bed_from_white_bed,minecraft:blue_bed,minecraft:blue_bed_from_white_bed,minecraft:brown_bed,minecraft:brown_bed_from_white_bed,minecraft:cyan_bed,minecraft:cyan_bed_from_white_bed,minecraft:gray_bed,minecraft:gray_bed_from_white_bed,minecraft:green_bed,minecraft:green_bed_from_white_bed,minecraft:light_blue_bed,minecraft:light_blue_bed_from_white_bed,minecraft:light_gray_bed,minecraft:light_gray_bed_from_white_bed,minecraft:lime_bed,minecraft:lime_bed_from_white_bed,minecraft:magenta_bed,minecraft:magenta_bed_from_white_bed,minecraft:orange_bed,minecraft:orange_bed_from_white_bed,minecraft:pink_bed,minecraft:pink_bed_from_white_bed,minecraft:purple_bed,minecraft:purple_bed_from_white_bed,minecraft:red_bed,minecraft:red_bed_from_white_bed,minecraft:white_bed,minecraft:yellow_bed,minecraft:yellow_bed_from_white_bed",
            "Advanced Wood Building," +
                    "minecraft:oak_stairs,minecraft:spruce_stairs,minecraft:birch_stairs,minecraft:jungle_stairs,minecraft:acacia_stairs,minecraft:dark_oak_stairs" +
                    "minecraft:boat,minecraft:spruce_boat,minecraft:birch_boat,minecraft:jungle_boat,minecraft:acacia_boat,minecraft:dark_oak_boat"+
                    "minecraft:acacia_wooden_slab,minecraft:birch_wooden_slab,minecraft:dark_oak_wooden_slab,minecraft:jungle_wooden_slab,minecraft:oak_wooden_slab,minecraft:spruce_wooden_slab" +
                    "minecraft:sign,minecraft:ladder,minecraft:armor_stand,minecraft:trapdoor",
            "Basic Stone Building," +
                    "minecraft:cobblestone_wall,minecraft:mossy_cobblestone_wall," +
                    "minecraft:purpur_stairs,minecraft:quartz_stairs,minecraft:red_sandstone_stairs,minecraft:sandstone_stairs,minecraft:stone_brick_stairs,minecraft:stone_stairs," +
                    "minecraft:cobblestone_slab,minecraft:purpur_slab,minecraft:quartz_slab,minecraft:red_sandstone_slab,minecraft:sandstone_slab,minecraft:stone_brick_slab,minecraft:stone_slab",
            "Advanced Stone Building," +
                    "minecraft:mossy_cobblestone,minecraft:stonebrick," +
                    "minecraft:stone_brick_stairs,minecraft:sandstone_stairs,minecraft:red_sandstone_stairs",
            "Brick Building," +
                    "minecraft:brick_block,minecraft:brick_stairs," +
                    "minecraft:nether_brick,minecraft:nether_brick_stairs,minecraft:nether_brick_fence",
            "Iron and Glass Building," +
                    "minecraft:glass,minecraft:glass_pane,minecraft:iron_bars,minecraft:flint_and_steel," +
                    "minecraft:iron_trapdoor,minecraft:iron_door,minecraft:hopper",
            "Basic decoration Building,minecraft:item_frame,minecraft:book,minecraft:bookshelf",
            "Concrete Powder Building,minecraft:minecraft:black_concrete_powder,minecraft:blue_concrete_powder,minecraft:brown_concrete_powder,minecraft:cyan_concrete_powder,minecraft:gray_concrete_powder,minecraft:green_concrete_powder,minecraft:light_blue_concrete_powder,minecraft:light_gray_concrete_powder,minecraft:lime_concrete_powder,minecraft:magenta_concrete_powder,minecraft:orange_concrete_powder,minecraft:pink_concrete_powder,minecraft:purple_concrete_powder,minecraft:red_concrete_powder,minecraft:white_concrete_powder,minecraft:yellow_concrete_powder",
            "Enchanting Building,minecraft:anvil,minecraft:enchanting_table",
            "Brewing Building,minecraft:brewing_stand,minecraft:fermented_spider_eye",
            "Basic Redstone Building," +
                    "minecraft:lever,minecraft:stone_pressure_plate,minecraft:wooden_pressure_plate,minecraft:noteblock" +
                    "minecraft:heavy_weighted_pressure_plate,minecraft:light_weighted_pressure_plate," +
                    "minecraft:redstone_torch,minecraft:wooden_button,minecraft:stone_button,minecraft:piston",
            "Advanced decoration Building," +
                    "minecraft:banner,minecraft:painting,minecraft:flower_pot," +
                    "minecraft:stained_glass,minecraft:stained_glass_pane",
            "Advanced Redstone Building," +
                    "minecraft:sticky_piston,minecraft:dispenser,minecraft:tnt,minecraft:redstone_lamp," +
                    "minecraft:tripwire_hook,minecraft:trapped_chest,minecraft:daylight_detector," +
                    "minecraft:dropper,minecraft:repeater,minecraft:comparator,minecraft:observer",
            "Rails Building," +
                    "minecraft:rail,minecraft:activator_rail,minecraft:detector_rail,minecraft:golden_rail," +
                    "minecraft:minecart,minecraft:chest_minecraft,minecraft:furnace_minecart,minecraft:tnt_minecart,minecraft:hopper_minecart",
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

            "Better Arrows Fighting,minecraft:arrow,2",
            "Even more Arrows,minecraft:arrow,3",

            "More Bone Meal,minecraft:bone_meal_from_bone,2",

            "More Woods,minecraft:" +
                    "minecraft:acacia_planks,2,minecraft:birch_planks,2,minecraft:dark_oak_planks,2,minecraft:jungle_planks,2,minecraft:oak_planks,2,minecraft:spruce_planks,2," +
                    "minecraft:acacia_wooden_slab,2,minecraft:birch_wooden_slab,2,minecraft:dark_oak_wooden_slab,2,minecraft:jungle_wooden_slab,2,minecraft:oak_wooden_slab,2,minecraft:spruce_wooden_slab,2," +
                    "minecraft:oak_stairs,2,minecraft:spruce_stairs,2,minecraft:birch_stairs,2,minecraft:jungle_stairs,2,minecraft:acacia_stairs,2,minecraft:dark_oak_stairs,2",
            "More Woods 2,minecraft:" +
                    "minecraft:acacia_planks,3,minecraft:birch_planks,3,minecraft:dark_oak_planks,3,minecraft:jungle_planks,3,minecraft:oak_planks,3,minecraft:spruce_planks,3," +
                    "minecraft:acacia_wooden_slab,2.5,minecraft:birch_wooden_slab,2.5,minecraft:dark_oak_wooden_slab,2.5,minecraft:jungle_wooden_slab,2.5,minecraft:oak_wooden_slab,2.5,minecraft:spruce_wooden_slab,2.5," +
                    "minecraft:oak_stairs,2.5,minecraft:spruce_stairs,2.5,minecraft:birch_stairs,2.5,minecraft:jungle_stairs,2.5,minecraft:acacia_stairs,2.5,minecraft:dark_oak_stairs,2.5",
            "More Woods 3," +
                    "minecraft:acacia_planks,4,minecraft:birch_planks,4,minecraft:dark_oak_planks,4,minecraft:jungle_planks,4,minecraft:oak_planks,4,minecraft:spruce_planks,4," +
                    "minecraft:acacia_wooden_slab,3,minecraft:birch_wooden_slab,3,minecraft:dark_oak_wooden_slab,3,minecraft:jungle_wooden_slab,3,minecraft:oak_wooden_slab,3,minecraft:spruce_wooden_slab,3," +
                    "minecraft:oak_stairs,3,minecraft:spruce_stairs,3,minecraft:birch_stairs,3,minecraft:jungle_stairs,3,minecraft:acacia_stairs,3,minecraft:dark_oak_stairs,3",

            "More Stone," +
                    "minecraft:chiseled_stonebrick,2,minecraft:mossy_stonebrick,2,minecraft:stonebrick,2," +
                    "minecraft:minecraft:red_sandstone_stairs,2,minecraft:sandstone_stairs,2,minecraft:stone_stairs,2," +
                    "minecraft:cobblestone_slab,2,minecraft:red_sandstone_slab,2,minecraft:sandstone_slab,2,minecraft:stone_slab,2",
            "More Stone 2," +
                    "minecraft:chiseled_stonebrick,3,minecraft:mossy_stonebrick,3,minecraft:stonebrick,3," +
                    "minecraft:red_sandstone_stairs,3,minecraft:sandstone_stairs,3,minecraft:stone_stairs,3," +
                    "minecraft:cobblestone_slab,3,minecraft:red_sandstone_slab,3,minecraft:sandstone_slab,3,minecraft:stone_slab,3",

            "More Fence,minecraft:" +
                    "fence,2,minecraft:spruce_fence,2,minecraft:birch_fence,2,minecraft:jungle_fence,2," +
                    "minecraft:dark_oak_fence,2,minecraft:acacia_fence,2,minecraft:cobblestone_wall,2,minecraft:mossy_cobblestone_wall,2",
            "More Concrete,minecraft:black_concrete_powder,2,minecraft:blue_concrete_powder,2,minecraft:brown_concrete_powder,2,minecraft:cyan_concrete_powder,2,minecraft:gray_concrete_powder,2,minecraft:green_concrete_powder,2,minecraft:light_blue_concrete_powder,2,minecraft:light_gray_concrete_powder,2,minecraft:lime_concrete_powder,2,minecraft:magenta_concrete_powder,2,minecraft:orange_concrete_powder,2,minecraft:pink_concrete_powder,2,minecraft:purple_concrete_powder,2,minecraft:red_concrete_powder,2,minecraft:white_concrete_powder,2,minecraft:yellow_concrete_powder,2",
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
            "More Ender Diamond,levelup:ender/ender_diamond,2",
            "More Magma Ingot,levelup:magma/magma_ingot,2",
            "More Wither Ingot,levelup:wither/wither_ingot,2"
    };

    public static void init() {
        Map<String, Group> groupMap = new HashMap<>();
        for (int i = 0; i < groups.length; i++) {
            String[] group = groups[i].split(",");
            groupMap.put(group[0], new Group(group[0], ExperienceType.valueOf(group[1].toLowerCase()), Integer.parseInt(group[2])));
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
