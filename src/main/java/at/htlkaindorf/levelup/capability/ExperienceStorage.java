package at.htlkaindorf.levelup.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class ExperienceStorage implements Capability.IStorage<IExperience> {

    @Override
    public NBTBase writeNBT(Capability<IExperience> capability, IExperience instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        for(ExperienceType type : ExperienceType.values()) {
            tag.setInteger(type.toString(),instance.getExperience(type));
        }
        return tag;
    }

    @Override
    public void readNBT(Capability<IExperience> capability, IExperience instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tag = (NBTTagCompound) nbt;
        for(ExperienceType type : ExperienceType.values()) {
            instance.set(type,tag.getInteger(type.toString()));
        }
    }
}
