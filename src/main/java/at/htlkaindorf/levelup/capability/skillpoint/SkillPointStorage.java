package at.htlkaindorf.levelup.capability.skillpoint;

import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class SkillPointStorage implements Capability.IStorage<ISkillPoint> {

    @Override
    public NBTBase writeNBT(Capability<ISkillPoint> capability, ISkillPoint instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        for(ExperienceType type : ExperienceType.values()) {
            tag.setInteger(type.toString(),instance.get(type));
        }
        return tag;
    }

    @Override
    public void readNBT(Capability<ISkillPoint> capability, ISkillPoint instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound tag = (NBTTagCompound) nbt;
        for(ExperienceType type : ExperienceType.values()) {
            instance.set(type,tag.getInteger(type.toString()));
        }
    }
}
