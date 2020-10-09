package at.htlkaindorf.levelup.materials;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    public static final Item.ToolMaterial rubyToolMatMATERIAL = EnumHelper.addToolMaterial("RUBY",
            3, 2000, 10F, 4.0F, 15); //comparison to diamond: DIAMOND(3, 1561, 8.0F, 3.0F, 10);
    public static final Item.ToolMaterial magmaToolMatMATERIAL = EnumHelper.addToolMaterial("MAGMA",
            1, 100, 15.0F, 1.0F, 25);
    public static final Item.ToolMaterial enderToolMatMATERIAL = EnumHelper.addToolMaterial("ENDER",
            2, 400, 8.0F, 3.0F, 16); //comparison to iron: IRON(2, 250, 6.0F, 2.0F, 14),

}
