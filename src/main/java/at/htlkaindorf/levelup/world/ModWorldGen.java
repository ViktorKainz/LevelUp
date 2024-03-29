package at.htlkaindorf.levelup.world;

import at.htlkaindorf.levelup.proxy.CommonProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(CommonProxy.blocks.get("levelup:ruby_ore").getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(3) + 1, random.nextInt(5));
        generateOre(CommonProxy.blocks.get("levelup:sapphire_ore").getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 64, random.nextInt(3) + 1, random.nextInt(5));
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(maxY - minY), z + random.nextInt(16));
            new WorldGenMinable(ore, size).generate(world, random, pos);
        }
    }
}
