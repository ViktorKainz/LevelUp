package at.htlkaindorf.levelup.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ExperienceProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IExperience.class)
    public static final Capability<IExperience> EXPERIENCE_CAP = null;

    private IExperience instance = EXPERIENCE_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == EXPERIENCE_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == EXPERIENCE_CAP ? EXPERIENCE_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return EXPERIENCE_CAP.getStorage().writeNBT(EXPERIENCE_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        EXPERIENCE_CAP.getStorage().readNBT(EXPERIENCE_CAP, this.instance, null, nbt);
    }
}
