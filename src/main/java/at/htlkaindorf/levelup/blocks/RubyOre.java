package at.htlkaindorf.levelup.blocks;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.ruby.Ruby;
import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class RubyOre extends Block {

    public static final String NAME = "ruby_ore";

    public RubyOre() {
        super(Material.ROCK);
        setCreativeTab(LevelUp.LEVEL_UP_TAB);
        setUnlocalizedName(NAME);
        setRegistryName(NAME);
        setHarvestLevel("pickaxe", 2);
        setHardness(3f);
        setSoundType(SoundType.STONE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return CommonProxy.items.get(LevelUp.MODID + Ruby.NAME);
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(CommonProxy.items.get(getRegistryName()));
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
