package cafe.ethanolgie.bambootreesapling;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.*;
import net.minecraft.client.render.RenderLayer;


@Environment(EnvType.CLIENT)
public class BTSClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BTS.BAMBOO_TREE_SAPLING, RenderLayer.getCutout());
    }
}
