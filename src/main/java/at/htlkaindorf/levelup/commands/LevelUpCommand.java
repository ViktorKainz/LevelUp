package at.htlkaindorf.levelup.commands;

import at.htlkaindorf.levelup.LevelUp;
import at.htlkaindorf.levelup.config.Group;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class LevelUpCommand extends CommandBase {

    private final List<String> aliases;

    public LevelUpCommand()
    {
        aliases = Lists.newArrayList(LevelUp.MODID,"levelup","LEVELUP");
    }


    @Override
    public String getName() {
        return "levelup";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "levelup";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer p = (EntityPlayer) sender;
            Map<String,Group> groups = Group.getGroups();
        }
    }
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Collections.emptyList();
    }
}
