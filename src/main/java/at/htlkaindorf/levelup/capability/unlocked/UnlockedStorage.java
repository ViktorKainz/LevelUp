package at.htlkaindorf.levelup.capability.unlocked;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

public class UnlockedStorage implements Capability.IStorage<IUnlocked>{

    @Override
    public NBTBase writeNBT(Capability<IUnlocked> capability, IUnlocked instance, EnumFacing side) {
        NBTTagList tag = new NBTTagList();
        for(String group : instance.get()) {
            tag.appendTag(new NBTTagString(group));
        }
        return tag;
    }

    @Override
    public void readNBT(Capability<IUnlocked> capability, IUnlocked instance, EnumFacing side, NBTBase nbt) {
        NBTTagList tag = (NBTTagList) nbt;
        for(NBTBase resource : tag) {
            NBTTagString string = (NBTTagString) resource;
            instance.add(string.getString());
        }
    }
}
