package at.htlkaindorf.levelup.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class ExperienceStorage implements Capability.IStorage<IExperience> {

    @Override
    public NBTBase writeNBT(Capability<IExperience> capability, IExperience instance, EnumFacing side) {
        return new NBTTagInt(instance.getExperience());
    }

    @Override
    public void readNBT(Capability<IExperience> capability, IExperience instance, EnumFacing side, NBTBase nbt) {
        instance.set(((NBTPrimitive)nbt).getInt());
    }
}
