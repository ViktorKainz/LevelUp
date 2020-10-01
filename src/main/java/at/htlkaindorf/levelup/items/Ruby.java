package at.htlkaindorf.levelup.items;

import net.minecraft.creativetab.CreativeTabs;

public class Ruby extends ItemBase {
    public static ItemBase ruby = new ItemBase("Ruby").setCreativeTab(CreativeTabs.MATERIALS);

    public Ruby(String name) {
        super(name);
    }
}
