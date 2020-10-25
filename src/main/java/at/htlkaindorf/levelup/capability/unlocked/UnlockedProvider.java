package at.htlkaindorf.levelup.capability.unlocked;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class UnlockedProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IUnlocked.class)
    public static final Capability<IUnlocked> UNLOCKED_CAP = null;

    private IUnlocked instance = UNLOCKED_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == UNLOCKED_CAP;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == UNLOCKED_CAP ? UNLOCKED_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return UNLOCKED_CAP.getStorage().writeNBT(UNLOCKED_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        UNLOCKED_CAP.getStorage().readNBT(UNLOCKED_CAP, this.instance, null, nbt);
    }
}