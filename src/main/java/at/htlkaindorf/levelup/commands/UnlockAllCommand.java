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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UnlockAllCommand extends CommandBase {

    private final List<String> aliases;

    public UnlockAllCommand() {
        aliases = Lists.newArrayList(LevelUp.MODID, "unlockall", "UNLOCKALL");
    }

    @Override
    public String getName() {
        return "unlockall";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/unlockall";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) sender;
            Map<String, Group> groups = Group.getGroups();
            groups.keySet().forEach(v -> {
                groups.get(v).setUnlocked(p);
            });
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        EntityPlayer p = (EntityPlayer) sender;
        return p.canUseCommand(2,"");
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Collections.emptyList();
    }
}
