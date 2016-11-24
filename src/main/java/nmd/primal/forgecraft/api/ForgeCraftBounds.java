package nmd.primal.forgecraft.api;

import net.minecraft.util.math.AxisAlignedBB;

public class ForgeCraftBounds
{
    // ***************************************************************************** //
    //  Common Bounding Boxes
    // ***************************************************************************** //
    public static final AxisAlignedBB AABB_SOULSAND = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
    public static final AxisAlignedBB AABB_FARMLAND = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9375D, 1.0D);

    public static final AxisAlignedBB AABB_NARROW_CUBE = new AxisAlignedBB(0.26D, 0.0D, 0.26D, 0.74D, 1.0D, 0.74D);

    public static final AxisAlignedBB AABB_BUSH = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);
    public static final AxisAlignedBB[] AABB_CROPS = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};


    // ***************************************************************************** //
    //  Block/Model Specific Bounding Boxes
    // ***************************************************************************** //
    public static final AxisAlignedBB AABB_DRYING_RACK = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);

    // TODO: this should be broken into two, to account for orientation. For the time being one size fits either direction is OK.
    public static final AxisAlignedBB AABB_FISH_TRAP = new AxisAlignedBB(0.15D, 0.0D, 0.15D, 0.85D, 0.5D, 0.85D);

    public static final AxisAlignedBB AABB_LANTERN_UP = new AxisAlignedBB(0.32D, 0.0D, 0.32D, 0.68D, 0.75D, 0.68D);
    public static final AxisAlignedBB AABB_LANTERN = new AxisAlignedBB(0.32D, 0.07D, 0.32D, 0.68D, 0.93D, 0.68D);

    public static final AxisAlignedBB AABB_SLAT_TOP_FULL = new AxisAlignedBB(0.0D, 0.815D, 0.0D, 1.0D, 0.935D, 1.0D);
    public static final AxisAlignedBB AABB_SLAT_BOTTOM_FULL = new AxisAlignedBB(0.0D, 0.065D, 0.0D, 1.0D, 0.185D, 1.0D);

    public static final AxisAlignedBB AABB_SLAT_TOP_EAST = new AxisAlignedBB(0.0D, 0.815D, 0.0D, 0.875D, 0.935D, 1.0D);
    public static final AxisAlignedBB AABB_SLAT_BOTTOM_EAST = new AxisAlignedBB(0.0D, 0.065D, 0.0D, 0.875D, 0.185D, 1.0D);

    public static final AxisAlignedBB AABB_SLAT_TOP_WEST = new AxisAlignedBB(0.125D, 0.815D, 0.0D, 1.0D, 0.935D, 1.0D);
    public static final AxisAlignedBB AABB_SLAT_BOTTOM_WEST = new AxisAlignedBB(0.125D, 0.065D, 0.0D, 1.0D, 0.185D, 1.0D);

    public static final AxisAlignedBB AABB_SLAT_TOP_NORTH = new AxisAlignedBB(0.0D, 0.815D, 0.125D, 1.0D, 0.935D, 1.0D);
    public static final AxisAlignedBB AABB_SLAT_BOTTOM_NORTH = new AxisAlignedBB(0.0D, 0.065D, 0.125D, 1.0D, 0.185D, 1.0D);

    public static final AxisAlignedBB AABB_SLAT_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.815D, 0.0D, 1.0D, 0.935D, 0.875D);
    public static final AxisAlignedBB AABB_SLAT_BOTTOM_SOUTH = new AxisAlignedBB(0.0D, 0.065D, 0.0D, 1.0D, 0.185D, 0.875D);

    public static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
    public static final AxisAlignedBB AABB_SLAB_TOP = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

    public static final AxisAlignedBB AABB_SLAB_VERTICAL_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.5D);
    public static final AxisAlignedBB AABB_SLAB_VERTICAL_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB AABB_SLAB_VERTICAL_WEST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB AABB_SLAB_VERTICAL_EAST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 1.0D, 1.0D);

    public static final AxisAlignedBB AABB_THIN_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D);
    public static final AxisAlignedBB AABB_THIN_SLAB_TOP = new AxisAlignedBB(0.0D, 0.8125D, 0.0D, 1.0D, 1.0D, 1.0D);

    public static final AxisAlignedBB AABB_PALM_CORE = new AxisAlignedBB(0.32D, 0.0D, 0.32D, 0.68D, 1.0D, 0.68D);
    public static final AxisAlignedBB AABB_IGNIS_FATUUS = new AxisAlignedBB(0.5D, 0.3D, 0.5D, 0.6D, 0.5D, 0.6D);


    // ***************************************************************************** //
    //  Layers, pretty much the same as vanilla snow, why am I here?
    // ***************************************************************************** //
    public static final AxisAlignedBB[] AABB_LAYERS = new AxisAlignedBB[] {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
}