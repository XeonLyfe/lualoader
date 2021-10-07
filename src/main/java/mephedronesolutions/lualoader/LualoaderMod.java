package mephedronesolutions.lualoader;

import fuck.you.stupid.paster.CoreMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
@Mod(modid = LualoaderMod.MODID, name = LualoaderMod.NAME, version = LualoaderMod.VERSION)
public class LualoaderMod {
    public static final String MODID = "lualoader";
    public static final String NAME = "Lualoader";
    public static final String VERSION = "1.0";

    private CoreMod coreMod = new CoreMod();

    @Mod.EventHandler public void preInit(FMLPreInitializationEvent event) { coreMod.preInit(event); }

    @Mod.EventHandler public void init(FMLInitializationEvent event) { coreMod.init(event); }

    @Mod.EventHandler public void postInit(FMLPostInitializationEvent event) { coreMod.postInit(event); }
}
