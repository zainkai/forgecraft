package nmd.primal.forgecraft.api;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;

/**
 *  Any Blockstate that might need to be shared or accessed through the API should be created here
 */
public class ForgeCraftStates
{
    public static final PropertyBool BLOOM = PropertyBool.create("bloom");
    public static final PropertyBool LIT = PropertyBool.create("lit");

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public static final PropertyInteger DENSITY = PropertyInteger.create("density", 0, 7);
    public static final PropertyInteger SOIL = PropertyInteger.create("soil", 0, 15);
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

    /**
     *  this is basically the same as vanilla snow
     */
    public static final PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);

    /**
     *  vanilla mining overlay consists of 0-9 states
     *
     */
    public static final PropertyInteger CRACKED = PropertyInteger.create("layers", 0, 9);

    /**
     *  Vanilla MOISTURE levels for farmland 0-7
     *  Primal DAMPNESS levels 0-2 leaving space to support horizontal facing
     *      simulate the higher resolution by slowing down DAMPNESS changes
     */
    public static final PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 7);
    public static final PropertyInteger DAMPNESS = PropertyInteger.create("dampness", 0, 2);

    // old states
    // PrimalFacing-like Block positions, TOP = true, BOTTOM = false
    //public static final PropertyBool HALF = PropertyBool.create("half");
}