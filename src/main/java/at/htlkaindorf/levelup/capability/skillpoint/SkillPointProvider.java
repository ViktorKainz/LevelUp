package at.htlkaindorf.levelup.capability.skillpoint;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SkillPointProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(ISkillPoint.class)
    public static final Capability<ISkillPoint> SkillPoint_CAP = null;

    private ISkillPoint instance = SkillPoint_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == SkillPoint_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == SkillPoint_CAP ? SkillPoint_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return SkillPoint_CAP.getStorage().writeNBT(SkillPoint_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        SkillPoint_CAP.getStorage().readNBT(SkillPoint_CAP, this.instance, null, nbt);
    }
}
