package at.htlkaindorf.levelup.blocks;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class RubyBlock extends Block {

    public static final String NAME = "ruby_block";

    public RubyBlock() {
        super(Material.ROCK);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setHarvestLevel("pickaxe", 2);
        setHardness(3f);
        setSoundType(SoundType.METAL);
    }
}
