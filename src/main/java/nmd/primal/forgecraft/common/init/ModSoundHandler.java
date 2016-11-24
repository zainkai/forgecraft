package nmd.primal.forgecraft.common.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * Created by kitsu on 11/20/2016.
 */
public class ModSoundHandler {
    //public static SoundEvent bulletCreate;
    //public static SoundEvent woodsaw;
    //public static SoundEvent scrape;

    private static int size = 0;

    public static void init() {
        size = SoundEvent.REGISTRY.getKeys().size();
        //woodsaw = register("woodsaw");
        //scrape = register("scrape");
        //bulletCreate = register("bulletCreate");
    }

    public static SoundEvent register(String name) {
        ResourceLocation loc = new ResourceLocation("forgecraft:" + name);
        SoundEvent e = new SoundEvent(loc);

        SoundEvent.REGISTRY.register(size, loc, e);
        size++;

        return e;
    }

}