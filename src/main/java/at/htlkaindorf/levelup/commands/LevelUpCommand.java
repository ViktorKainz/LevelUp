package at.htlkaindorf.levelup.commands;

import at.htlkaindorf.levelup.config.Group;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;


public class LevelUpCommand extends CommandBase {

    private final int groupsInAPage = 2;
    private int page = 1;

    @Override
    @Nonnull
    public String getName() {
        return "levelup";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "/levelup [page]";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args){
        int neededPages;
        try {
            page = Integer.parseInt(args[0]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if (sender instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) sender;
            Map<String, Group> groups = getUnlockedGroups(p);
            neededPages = (groups.size()/groupsInAPage) + (groups.size()%groupsInAPage==0?0:1);
            List<String> keys = new ArrayList<>(groups.keySet());

            for(int i = 0; i<20;i++)
            {
                p.sendMessage(new TextComponentString(""));
            }

            if(neededPages == 0)
            {
                page = 1;
                p.sendMessage(new TextComponentString("Your unlocks! Page: " + page + " of 1").setStyle(new Style().setColor(TextFormatting.BLUE)));
                p.sendMessage(new TextComponentString("You have nothing unlocked yet!"));
                return;
            }
            else
            {
                if(page > neededPages)
                {
                    page = neededPages;
                }
                p.sendMessage(new TextComponentString("Your unlocks! Page: " + page + " of " + neededPages).setStyle(new Style().setColor(TextFormatting.BLUE)));
            }

            for(int pageCounter = page*groupsInAPage-groupsInAPage; pageCounter <= page*groupsInAPage-1; pageCounter++)
            {
                try {

                    String currentGroupKey = keys.get(pageCounter);
                    p.sendMessage(new TextComponentString("Category " + currentGroupKey).setStyle(new Style().setColor(TextFormatting.RED)));
                    groups.get(currentGroupKey).getItems().forEach(i -> {
                        String[] output = splitResourceLocation(i);
                        p.sendMessage(new TextComponentString(output[0].substring(0, 1).toUpperCase() + output[0].substring(1) + " " + output[1].substring(0, 1).toUpperCase() + output[1].substring(1)));
                    });
                    groups.get(currentGroupKey).getAmounts().keySet().forEach(a -> {
                        String[] output = splitResourceLocation(a);
                        p.sendMessage(new TextComponentString("Your crafting output for " + output[0].substring(0, 1).toUpperCase() + output[0].substring(1) + " " + output[1].substring(0, 1).toUpperCase() + output[1].substring(1) + " is multiplied with " + groups.get(currentGroupKey).getAmounts().get(a).toString()));
                    });
                }
                catch (Exception ex)
                {

                }
            }

            if(neededPages == 1)
            {
                p.sendMessage(getMenuString(true,true));
            }
            else if(page == neededPages)
            {
                p.sendMessage(getMenuString(false,true));
            }
            else if(page == 1)
            {
                p.sendMessage(getMenuString(true,false));
            }
            else
            {
                p.sendMessage(getMenuString(false,false));
            }
        }
    }

    public ITextComponent getMenuString(boolean firstPage, boolean lastPage)
    {
        ITextComponent previousPage = new TextComponentString("Previous Page");
        ITextComponent nextPage = new TextComponentString("Next Page");
        ITextComponent space = new TextComponentString("      ");

        Style nextPageStyle = new Style().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/levelup "+(page+1))).setColor(TextFormatting.GREEN).setUnderlined(true);
        Style previousPageStyle = new Style().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/levelup "+(page-1))).setColor(TextFormatting.GREEN).setUnderlined(true);
        Style spaceStyle = new Style().setUnderlined(false);

        previousPage.setStyle(previousPageStyle);
        nextPage.setStyle(nextPageStyle);
        space.setStyle(spaceStyle);


        if(!firstPage && !lastPage)
        {
            return previousPage.appendSibling(space).appendSibling(nextPage);
        }
        else if(firstPage &&!lastPage)
        {
            return nextPage;
        }
        else if(!firstPage)
        {
            return previousPage;
        }
        else {
            return null;
        }
    }

    public Map<String,Group> getUnlockedGroups(EntityPlayer p)
    {
        Map<String, Group> groupMap = new HashMap<>();
        Map<String, Group> g = Group.getGroups();
        g.keySet().forEach(v -> {
            if(g.get(v).isUnlockedBy(p))
            {
                groupMap.put(v,g.get(v));
            }
        });
        return groupMap;
    }


    public String[] splitResourceLocation(ResourceLocation r)
    {
        String[] tokens = r.toString().split(":");
        return tokens[1].split("_");
    }

    @Override
    public boolean checkPermission(@Nonnull MinecraftServer server,@Nonnull ICommandSender sender) {
        return true;
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args, @Nullable BlockPos targetPos) {
        List<String> pages = new LinkedList<>();
        int neededPages;
        if (sender instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) sender;
            Map<String, Group> groups = getUnlockedGroups(p);
            neededPages = (groups.size() / groupsInAPage) + (groups.size() % groupsInAPage == 0 ? 0 : 1);
            for(int i = 1; i <= neededPages; i++)
            {
                pages.add(i+"");
            }
        }
        return pages;
    }
}
