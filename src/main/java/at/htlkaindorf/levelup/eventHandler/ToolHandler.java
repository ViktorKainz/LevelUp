package at.htlkaindorf.levelup.eventHandler;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.items.ender.tools.EnderTools;
import at.htlkaindorf.levelup.items.magma.armor.MagmaHelmet;
import at.htlkaindorf.levelup.items.magma.tools.MagmaTools;
import at.htlkaindorf.levelup.items.wither.armor.WitherHelmet;
import at.htlkaindorf.levelup.materials.Materials;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LevelUp.MODID)
public class ToolHandler {

    @SubscribeEvent
    public void onHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
        if (main instanceof ItemTool) {
            ItemTool tool = (ItemTool) main;
            if (tool.getToolMaterialName().equals(Materials.MAGMA_TOOL_MATERIAL.name())) {
                MagmaTools.onHarvestDrop(event);
            } else if (tool.getToolMaterialName().equals(Materials.ENDER_TOOL_MATERIAL.name())) {
                EnderTools.onHarvestDrop(event);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        DamageSource source = event.getSource();
        if (source.getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) source.getTrueSource();
            Item main = player != null ? player.getHeldItemMainhand() != null ? player.getHeldItemMainhand().getItem() : null : null;
            if (main instanceof ItemSword) {
                ItemSword tool = (ItemSword) main;
                if (tool.getToolMaterialName().equals(Materials.ENDER_TOOL_MATERIAL.name())) {
                    EnderTools.onLivingDrops(event);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        EntityLivingBase target = event.getEntityLiving();
        DamageSource source = event.getSource();
        if (target instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) target;
            if (MagmaHelmet.fullArmor(player) && source.getImmediateSource() != null) {
                source.getImmediateSource().setFire(1);
            } else if (WitherHelmet.fullArmor(player) && source.getImmediateSource() instanceof EntityLiving) {
                ((EntityLiving) source.getImmediateSource()).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20, 1));
            }
        }
    }
}
