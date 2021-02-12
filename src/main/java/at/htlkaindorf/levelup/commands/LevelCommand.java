package at.htlkaindorf.levelup.commands;

import at.htlkaindorf.levelup.capability.experience.ExperienceProvider;
import at.htlkaindorf.levelup.capability.experience.ExperienceType;
import at.htlkaindorf.levelup.capability.experience.IExperience;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelCommand extends CommandBase {
    @Override
    public String getName() {
        return "level";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/level [type]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ExperienceType type = null;
        try {
            type = ExperienceType.valueOf(args[0].toLowerCase());
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException ex) {}
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
            IExperience experience = player.getCapability(ExperienceProvider.EXPERIENCE_CAP, null);
            player.sendMessage(new TextComponentString("Level:"));
            for (ExperienceType t : type == null || type == ExperienceType.tool ? ExperienceType.values() : new ExperienceType[]{type}) {
                if (t != ExperienceType.tool) {
                    int level = experience.getLevel(t);
                    if (level == 0) {
                        player.sendMessage(new TextComponentString(String.format("%s: lv%d (%d/%d)",
                                t, experience.getLevel(t), 100 + experience.getExperience(t)
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1),
                                100 + experience.getExperienceOfLevel(experience.getLevel(t))
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1))));
                    } else if (level == 1) {
                        player.sendMessage(new TextComponentString(String.format("%s: lv%d (%d/%d)",
                                t, experience.getLevel(t), experience.getExperience(t)
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1),
                                100 + experience.getExperienceOfLevel(experience.getLevel(t))
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1))));
                    } else {
                        player.sendMessage(new TextComponentString(String.format("%s: lv%d (%d/%d)",
                                t, experience.getLevel(t), experience.getExperience(t) - 100
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1),
                                experience.getExperienceOfLevel(experience.getLevel(t))
                                - experience.getExperienceOfLevel(experience.getLevel(t) - 1))));
                    }
                }
            }
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Stream.of(ExperienceType.values()).map(Enum::name).collect(Collectors.toList());
    }

    @Override
    public boolean checkPermission(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender) {
        return true;
    }
}
