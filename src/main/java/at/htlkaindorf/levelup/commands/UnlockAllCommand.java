package at.htlkaindorf.levelup.commands;

import at.htlkaindorf.levelup.config.Group;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UnlockAllCommand extends CommandBase {

    @Override
    @Nonnull
    public String getName() {
        return "unlockall";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "/unlockall [Player]";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args){
        if (sender instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) sender;
            try
            {
                String name = args[0];
                List<EntityPlayerMP> onlinePlayers = server.getPlayerList().getPlayers();
                onlinePlayers.removeIf(v -> !v.getName().equals(name));
                p = onlinePlayers.get(0);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            Map<String, Group> groups = Group.getGroups();
            EntityPlayer finalP = p;
            groups.keySet().forEach(v -> groups.get(v).setUnlocked(finalP));
        }
    }

    @Override
    public boolean checkPermission(@Nonnull MinecraftServer server,@Nonnull ICommandSender sender) {
        EntityPlayer p = (EntityPlayer) sender;
        return p.canUseCommand(1,"");
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server,@Nonnull ICommandSender sender,@Nonnull String[] args, @Nullable BlockPos targetPos) {
        return Arrays.asList(server.getPlayerList().getOnlinePlayerNames().clone());
    }
}
