package at.htlkaindorf.levelup.blocks;

import at.htlkaindorf.levelup.LevelUp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RubyOre extends Block {

   public RubyOre(String name)
   {
       super(Material.ROCK);
       setCreativeTab(LevelUp.LEVEL_UP_TAB);
       setUnlocalizedName(name);
       setRegistryName(name);
       setHarvestLevel("pickaxe", 6);
       setHardness(3.5f);
   }
}
