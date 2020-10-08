package at.htlkaindorf.levelup.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class RubyOre extends Block {

   public RubyOre(String name)
   {
       super(Material.ROCK);
       setCreativeTab(CreativeTabs.MISC);
       setUnlocalizedName(name);
       setRegistryName(name);
       setHarvestLevel("pickaxe", 6);
       setHardness(3.5f);
   }
}
