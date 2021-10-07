package mephedronesolutions.lualoader;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
public class LualoaderEntryPoint implements IFMLLoadingPlugin {
    public LualoaderEntryPoint() {
        Lualoader.load();
    }

    @Override public String[] getASMTransformerClass() { return new String[0]; }

    @Override public String getModContainerClass() { return null; }

    @Override public String getSetupClass() { return null; }

    @Override public void injectData(Map<String, Object> data) { }

    @Override public String getAccessTransformerClass() { return null; }
}
