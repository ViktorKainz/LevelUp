package at.htlkaindorf.levelup.client;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LevelUpTab extends CreativeTabs {

    public LevelUpTab()
    {
        super(LevelUp.MOD_ID);
        setNoTitle();
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.Ruby);
    }
}
