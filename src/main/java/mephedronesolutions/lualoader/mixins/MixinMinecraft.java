/*
 * @author yoursleep
 * @since 07.10.2021, 20:55
 */

package mephedronesolutions.lualoader.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "init", at = @At("TAIL")) public void init(CallbackInfo ci) {
        System.out.println("yay go fuck yourself");
    }
}
