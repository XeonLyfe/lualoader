package mephedronesolutions.lualoader;

import mephedronesolutions.lualoader.classloader.LuaClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
public class Lualoader {
    private static LuaClassLoader LUACLASSLOADER;

    public static void load() {
        LUACLASSLOADER = new LuaClassLoader();

        try {
            Socket socket = new Socket("some socket ip", 1337);
            InputStream inputStream = socket.getInputStream();

            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String name = zipEntry.getName();
                if (name.endsWith(".class")) {
                    name = name.substring(0, name.length() - 6);
                    name = name.replace('/', '.');
                    ByteArrayOutputStream streamBuilder = new ByteArrayOutputStream();
                    int bytesRead;
                    byte[] tempBuffer = new byte[16384];
                    while ((bytesRead = zipInputStream.read(tempBuffer)) != -1) streamBuilder.write(tempBuffer, 0, bytesRead);

                    LUACLASSLOADER.loadClass(name, streamBuilder.toByteArray());
                } else {
                    ByteArrayOutputStream streamBuilder = new ByteArrayOutputStream();
                    int bytesRead;
                    byte[] tempBuffer = new byte[16384];
                    while ((bytesRead = zipInputStream.read(tempBuffer)) != -1) streamBuilder.write(tempBuffer, 0, bytesRead);

                    LUACLASSLOADER.loadResource(name, streamBuilder.toByteArray());
                }
            }
        } catch (Throwable t) { t.printStackTrace(); }

        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.lualoader.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }
}
