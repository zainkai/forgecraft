package nmd.primal.forgecraft.handler;

import net.minecraft.util.IStringSerializable;

/**
 * Created by mminaie on 2/1/17.
 */
public class EnumHandler {

    public static enum TongTypes implements IStringSerializable {
        DEFAULT("default", 0),
        EMPTYHOT("emptyhot", 1);

        private int ID;
        private String name;

        private TongTypes(String name, int ID) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

}
