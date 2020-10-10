package at.htlkaindorf.levelup.blocks;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.init.ModBlocks;
import at.htlkaindorf.levelup.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class RubyOre extends Block {

    public RubyOre(String name) {
        super(Material.ROCK);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHarvestLevel("pickaxe", 2);
        setHardness(3f);
        setSoundType(SoundType.STONE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.ruby;
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(ModBlocks.rubyOreItem);
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;
            return this.quantityDropped(random) * ( i < 1 ? 1 : i + 1);
        } else {
            return this.quantityDropped(random);
        }
    }
}
