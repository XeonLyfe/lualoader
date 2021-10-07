package mephedronesolutions.lualoader.classloader;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yoursleep
 * @since 07.10.2021
 */
public class LuaClassLoader extends ClassLoader {
    private Map<String, Class<?>> classes = new HashMap<>();
    private Map<String, byte[]> resources = new HashMap<>();

    public void loadClass(String name, byte[] data) { classes.put(name, defineClass(name, data, 0, data.length)); }

    public void loadResource(String name, byte[] data) { resources.put(name, data); }

    @Override public URL getResource(String name) {
        for (String packageName : names) {
            if (name.contains(packageName)) {
                try { return new URL(null, "bytes://" + name, new BytesHandler()); }
                catch (Throwable t) { t.printStackTrace(); }
            }
        }

        return super.getResource(name);
    }

    @Override public InputStream getResourceAsStream(String name) {
        try { return getResource(name).openStream(); }
        catch (IOException e) { return super.getResourceAsStream(name); }
    }

    @Override public Class<?> findClass(String name) throws ClassNotFoundException {
        if (Arrays.stream(names).anyMatch(name::contains)) { if (classes.get(name) != null) return classes.get(name); }
        return super.findClass(name);
    }

    /* these 2 classes are stolen from stackoverflow, but who the fuck cares */

    /**
     * @author KIC (some random guy from stack overflow
     * @since 13.11.2015
     */
    private class BytesHandler extends URLStreamHandler {
        @Override protected URLConnection openConnection(URL u) { return new ByteUrlConnection(u); }
    }

    private class ByteUrlConnection extends URLConnection {
        public ByteUrlConnection(URL url) { super(url); }

        @Override public void connect() {}

        @Override public InputStream getInputStream() { return new ByteArrayInputStream(resources.get(this.getURL().getPath().substring(1))); }
    }

    private String[] names = {
            "Write names of your packages, examples:",
            "fuck",
            "For package fuck.you.somemod"
    };
}
