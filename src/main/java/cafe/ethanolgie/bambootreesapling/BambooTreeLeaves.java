package cafe.ethanolgie.bambootreesapling;

import net.minecraft.block.BlockState;

import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;


import java.util.OptionalInt;

public class BambooTreeLeaves extends LeavesBlock {
    public BambooTreeLeaves(Settings settings) {

        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, updateDistanceFromBamboo(state, world, pos), 3);
    }

    private static BlockState updateDistanceFromBamboo(BlockState state, WorldAccess world, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            mutable.set(pos, direction);
            i = Math.min(i, getDistanceFromBamboo(world.getBlockState(mutable)) + 1);
            if (i == 1) {
                break;
            }
        }

        return (BlockState)state.with(DISTANCE, i);
    }

    private static int getDistanceFromBamboo(BlockState state) {
        return getOptionalDistanceFromBamboo(state).orElse(7);
    }

    public static OptionalInt getOptionalDistanceFromBamboo(BlockState state) {
        if (state.isIn(BlockTags.BAMBOO_BLOCKS)||state.isIn(BlockTags.LOGS)) {
            return OptionalInt.of(0);
        } else {
            return state.contains(DISTANCE) ? OptionalInt.of((Integer)state.get(DISTANCE)) : OptionalInt.empty();
        }
    }
}
