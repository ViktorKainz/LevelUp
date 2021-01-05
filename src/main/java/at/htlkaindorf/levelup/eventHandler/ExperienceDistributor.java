package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExperienceDistributor {

    public static final Map<Block,Integer> MINING_EXPERIENCE = Stream.of(new Object[][] {
            {Block.getBlockFromName("minecraft:coal_ore"), 2},
            {Block.getBlockFromName("minecraft:iron_ore"), 3},
            {Block.getBlockFromName("minecraft:gold_ore"), 4},
            {Block.getBlockFromName("minecraft:redstone_ore"), 5},
            {Block.getBlockFromName("minecraft:lapis_ore"), 5},
            {Block.getBlockFromName("minecraft:diamond_ore"), 10},
            {Block.getBlockFromName("minecraft:emerald_ore"), 15},
            {Block.getBlockFromName("levelup:ruby_ore"), 15},
            {Block.getBlockFromName("levelup:sapphire_ore"), 15}
    }).collect(Collectors.toMap(data -> (Block)data[0], data -> (Integer) data[1]));

    public static int amountFromBlock(IBlockState b, ExperienceType type) {
        switch (type) {
            case mining:
                return MINING_EXPERIENCE.get(b.getBlock()) != null ? MINING_EXPERIENCE.get(b.getBlock()) : b.getMaterial().equals(Material.ROCK) ? 1 : 0;
            case farming:
                return b.getBlock() instanceof BlockCrops ||
                       b.getBlock() instanceof BlockPumpkin ||
                       b.getBlock() instanceof BlockMelon ||
                       b.getBlock() instanceof BlockLog ? 1 : 0;
            default: return 0;
        }
    }
}
