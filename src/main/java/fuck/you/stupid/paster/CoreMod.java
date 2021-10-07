/*
 * @author yoursleep
 * @since 07.10.2021, 21:16
 */

package fuck.you.stupid.paster;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
@Mod(modid = CoreMod.MODID, name = CoreMod.NAME, version = CoreMod.VERSION)
public class CoreMod {
    public static final String MODID = "lualoader";
    public static final String NAME = "Lualoader";
    public static final String VERSION = "1.0";

    @Mod.EventHandler public void preInit(FMLPreInitializationEvent event) {}

    @Mod.EventHandler public void init(FMLInitializationEvent event) { System.out.println("lualoader loaded lol"); }

    @Mod.EventHandler public void postInit(FMLPostInitializationEvent event) {}
}
