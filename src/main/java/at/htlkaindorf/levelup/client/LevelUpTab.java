package at.htlkaindorf.levelup.client;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LevelUpTab extends CreativeTabs {

    public LevelUpTab()
    {
        super(LevelUp.MODID);
        setNoTitle();
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(CommonProxy.items.get("ruby"));
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
