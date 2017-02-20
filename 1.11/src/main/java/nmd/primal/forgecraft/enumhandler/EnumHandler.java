package nmd.primal.forgecraft.enumhandler;

import net.minecraft.util.IStringSerializable;
import nmd.primal.forgecraft.util.IMetaLookup;

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


    public enum IngotTypes implements IMetaLookup<IngotTypes> {
        IRONCOOL, /*0*/
        IRONHOT;  /*1*/

        public final int meta;
        public final String name;
        public boolean set = false;

        private IngotTypes() {
            meta = ordinal();
            name = toString().toLowerCase();
        }

        @Override
        public String getVariantName() {
            return name;
        }

        @Override
        public int getOrdinal() {
            return meta;
        }

        @Override
        public IngotTypes getByOrdinal(int i) {
            return this.values()[i];
        }

        @Override
        public String getID() {
            return "ore_type";
        }

    }




}
