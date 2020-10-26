package at.htlkaindorf.levelup.blocks;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SapphireBlock extends Block {

    public static final String NAME = "sapphire_block";

    public SapphireBlock() {
        super(Material.ROCK);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setHarvestLevel("pickaxe", 2);
        setHardness(3f);
        setSoundType(SoundType.METAL);
    }
}
