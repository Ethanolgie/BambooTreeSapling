package cafe.ethanolgie.bambootreesapling;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;


public class BambooTreeGenerator extends SaplingGenerator {

    public BambooTreeGenerator(){
    }


    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return BTS.BAMBOO_TREE;
    }
}