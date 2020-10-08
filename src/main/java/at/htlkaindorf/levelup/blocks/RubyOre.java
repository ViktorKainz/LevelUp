package at.htlkaindorf.levelup.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import scala.tools.nsc.Global;
import scala.xml.dtd.impl.Base;

public class RubyOre extends Block {


   public RubyOre(String name)
   {
       super(Material.ROCK);
       setCreativeTab(CreativeTabs.MISC);
       setHarvestLevel("pickaxe", 6);
       setHardness(3.5f);
   }
}
