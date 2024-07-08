package club.sk1er.patcher.mixins.features.cropheight;

import club.sk1er.patcher.config.PatcherConfig;
import club.sk1er.patcher.hooks.CropUtilities;
import gg.essential.api.EssentialAPI;
import gg.essential.universal.UMinecraft;
import net.minecraft.block.BlockCactus;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockCactus.class)
public class BlockCactusMixin_CropHitbox extends BlockMixin_CropHitbox {
    //#if MC==10809
    @Inject(method = "getSelectedBoundingBox", at = @At("HEAD"))
    public void patcher$getSelectedBoundingBox(World worldIn, BlockPos pos, CallbackInfoReturnable<AxisAlignedBB> cir) {
        if (PatcherConfig.futureCactusHitBoxes && (EssentialAPI.getMinecraftUtil().isHypixel() || UMinecraft.getMinecraft().isIntegratedServerRunning())) {
            //CropUtilities.updateCactusBox(worldIn.getBlockState(pos).getBlock());
        }
    }

    @Override
    public void collisionRayTrace(World worldIn, BlockPos pos, Vec3 start, Vec3 end, CallbackInfoReturnable<MovingObjectPosition> cir) {
        if (PatcherConfig.futureCactusHitBoxes && (EssentialAPI.getMinecraftUtil().isHypixel() || UMinecraft.getMinecraft().isIntegratedServerRunning())) {
            //CropUtilities.updateCactusBox(worldIn.getBlockState(pos).getBlock());
        }
    }
    //#endif
}
