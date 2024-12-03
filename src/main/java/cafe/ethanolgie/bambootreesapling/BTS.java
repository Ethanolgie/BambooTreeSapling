package cafe.ethanolgie.bambootreesapling;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.*;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class BTS implements ModInitializer {

    public static String MOD_ID = "bts";
    public static final RegistryKey<ConfiguredFeature<?,?>> BAMBOO_TREE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,rID("bamboo_tree"));

    public static final Block BAMBOO_TREE_LEAVES = new BambooTreeLeaves(FabricBlockSettings.copyOf(Blocks.AZALEA_LEAVES));
    public static final Block BAMBOO_TREE_SAPLING = new BambooTreeSapling(new BambooTreeGenerator(),AbstractBlock.Settings.create().mapColor(MapColor.LIME).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.BAMBOO_SAPLING).pistonBehavior(PistonBehavior.DESTROY));

    @Environment(EnvType.CLIENT)


    @Override
    public void onInitialize() {
        startRegister();
    }

    public static void registerBlockItem(String id,Block block){
        Registry.register(Registries.BLOCK,rID(id),block);
        Registry.register(Registries.ITEM,rID(id),new BlockItem(block,new FabricItemSettings()));
    }

    public static void startRegister(){

        registerBlockItem("bamboo_tree_leaves",BAMBOO_TREE_LEAVES);
        registerBlockItem("bamboo_tree_sapling",BAMBOO_TREE_SAPLING);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content ->{
            content.addAfter(Items.CHERRY_SAPLING,BTS.BAMBOO_TREE_SAPLING);
            content.addAfter(Items.CHERRY_LEAVES,BTS.BAMBOO_TREE_LEAVES);
        });
    }
    public static Identifier rID(String id){
        return new Identifier(MOD_ID,id);
    }

}
