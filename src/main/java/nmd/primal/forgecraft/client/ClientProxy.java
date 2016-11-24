package nmd.primal.forgecraft.client;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nmd.primal.forgecraft.client.render.MeshDefinitionFix;
import nmd.primal.forgecraft.common.init.ModFluids;
import nmd.primal.forgecraft.common.init.ModInfo;
import java.util.ArrayList;
import java.util.List;
import nmd.primal.forgecraft.common.CommonProxy;
import nmd.primal.forgecraft.common.CommonUtils;

/**
 * Created by kitsu on 11/23/2016.
 */
public class ClientProxy extends CommonProxy
{
    public static Minecraft minecraft = Minecraft.getMinecraft();

    @Override
    public Object getClient() {
        return FMLClientHandler.instance().getClient();
    }

    @Override
    public World getClientWorld() {
        return FMLClientHandler.instance().getClient().theWorld;
    }

    @Override
    public void registerClientEvents()
    {
        //CommonUtils.debugLogger(2, "proxy test", "client events");

        //MinecraftForge.EVENT_BUS.register(new GuiEventHandler());
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

    @Override
    public void preInit() {
        this.registerRendering();
        this.registerFluidModels();
    }

    @Override
    public void init() {
        this.registerTileRendering();
    }

    @Override
    public void postInit() {

    }

    @Override
    public void registerRendering()
    {
        ///
        // Projectile Entities
        ///
        //registerEntityRenderer(EntityMuckBall.class, RenderMuck.class);
        //registerEntityRenderer(EntityRock.class, RenderRock.class);
        //registerEntityRenderer(EntityQuartzArrow.class, RenderArrowQuartz.class);
        //registerEntityRenderer(EntityTorchArrow.class, RenderArrowTorchWood.class);
        //registerEntityRenderer(EntityTorchArrowNether.class, RenderArrowTorchNether.class);
        //registerEntityRenderer(EntityTorchArrow.class, RenderArrowTorchWood.class);
    }

    @Override
    public void registerTileRendering()
    {
        ///
        // Tiles
        ///
        //ClientRegistry.bindTileEntitySpecialRenderer(TileWorkTableBasic.class, new TileWorkTableBasicRender());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileWorkTableShelf.class, new TileWorkTableShelfRender());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileShelf.class, new TileShelfRender());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileDryingRack.class, new TileDryingRackRender());
    }

    @Override
    public void renderBlock(Block block)
    {
        minecraft.getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    @Override
    public void renderItem(Item item)
    {
        minecraft.getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void registerBlockSided(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        ResourceLocation location = block.getRegistryName();
        //CommonUtils.debugLogger(2, "block item render", "1: " + location);

        if (item!=null)
        {
            ModelBakery.registerItemVariants(item, new ResourceLocation(ModInfo.MOD_ID, block.getUnlocalizedName()));
            ModelLoader.setCustomModelResourceLocation(item, block.getMetaFromState(block.getDefaultState()), new ModelResourceLocation(location, "inventory"));
        }

        //Register colour handlers
        //if (bopBlock.getBlockColor() != null || bopBlock.getItemColor() != null)
        //{
        //    blocksToColour.add(block);
        //}

    }

    @Override
    public void registerItemSided(Item item)
    {
        // register sub types if there are any
        if (item.getHasSubtypes())
        {
            List<ItemStack> subItems = new ArrayList<ItemStack>();
            item.getSubItems(item, ModInfo.TAB_FORGECRAFT, subItems);
            for (ItemStack subItem : subItems)
            {
                String subItemName = item.getUnlocalizedName(subItem);
                subItemName =  subItemName.substring(subItemName.indexOf(".") + 1); // remove 'item.' from the front

                //CommonUtils.debugLogger(2, "item render", "1: " + subItemName.substring(7));
                //ModelBakery.registerItemVariants(item, new ResourceLocation(ModInfo.MOD_ID, subItemName));
                ModelBakery.registerItemVariants(item, new ResourceLocation(ModInfo.MOD_ID, subItemName.substring(7)));
                ModelLoader.setCustomModelResourceLocation(item, subItem.getMetadata(), new ModelResourceLocation(ModInfo.MOD_ID + ":" + subItemName, "inventory"));
            }
        }
        else
        {
            //CommonUtils.debugLogger(2, "item render", "2: " + item.delegate.name().getResourcePath());
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ModInfo.MOD_ID + ":" + item.delegate.name().getResourcePath(), "inventory"));
        }

        //Register colour handlers
        //if (item instanceof IColoredItem && ((IColoredItem)item).getItemColor() != null)
        //{
        //    this.itemsToColor.add(item);
        //}
    }


    @Override
    public void registerItemVariantModel(Item item, String name, int metadata)
    {
        if (item != null)
        {
            ModelBakery.registerItemVariants(item, new ResourceLocation(ModInfo.MOD_PREFIX + name));
            ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(ModInfo.MOD_PREFIX + name, "inventory"));
        }
    }

    @Override
    public void registerFluidBlockRendering(Block block, String name)
    {
        final ModelResourceLocation fluidLocation = new ModelResourceLocation(ModInfo.MOD_ID.toLowerCase() + ":fluids", name);

        // use a custom state mapper which will ignore the LEVEL property
        ModelLoader.setCustomStateMapper(block, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });
    }


    //@Override
    //public void registerFluidModels()
    {
        ModFluids.FLUID_BLOCKS.forEach(this::registerFluidModel);
    }

    @Override
    public void registerFluidModel(IFluidBlock fluidBlock)
    {
        //ModelResourceLocation location = new ModelResourceLocation(ModInfo.MOD_PREFIX, fluidBlock.getFluid().getName());
        ModelResourceLocation location = new ModelResourceLocation(ModInfo.MOD_PREFIX + "fluids", fluidBlock.getFluid().getName());
        //CommonUtils.debugLogger(2, "Fluid models", "location: " + location);

        final Item item = Item.getItemFromBlock((Block) fluidBlock);
        assert item != null;

        ModelBakery.registerItemVariants(item);
        ModelLoader.setCustomMeshDefinition(item, MeshDefinitionFix.create(stack -> location));
        //ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase()
        /*{
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_)
            {
                return location;
            }
        });
        */

        //itemsRegistered.add(item);
    }

    public void registerFluidRendering2(IFluidBlock fluidBlock, String name)
    {
        ModelResourceLocation location = new ModelResourceLocation(ModInfo.MOD_PREFIX + "fluids", name);
        //CommonUtils.debugLogger(2, "Fluid models", "location: " + location);

        Item item = Item.getItemFromBlock((Block) fluidBlock);
        assert item != null;

        ModelBakery.registerItemVariants(item);
        //ModelLoader.setCustomMeshDefinition(item, MeshDefinitionFix.create(stack -> location));


         ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack) {
            return location;
        }
        });


        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return location;
            }
        });


    }

    /*@Override
    public void spawnParticle(ForgeCraftParticles particle, double x, double y, double z, Object... info)
    {
        Minecraft minecraft = Minecraft.getMinecraft();
        Particle entityFx;
        int item_id;

        switch (particle)
        {
            case MUCK:
                item_id = Item.getIdFromItem(ForgeCraftItems.MUCK);
                minecraft.theWorld.spawnParticle(EnumParticleTypes.ITEM_CRACK, x, y, z, MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), new int[] { item_id });
                return;
            case ROCK:
                item_id = Item.getIdFromItem(ForgeCraftItems.ROCK);
                minecraft.theWorld.spawnParticle(EnumParticleTypes.ITEM_CRACK, x, y, z, MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), MathHelper.getRandomDoubleInRange(minecraft.theWorld.rand, -0.08D, 0.08D), new int[] { item_id });
                return;
            default:
                entityFx = null;
                break;
        }

        if (entityFx != null) {
            minecraft.effectRenderer.addEffect(entityFx);
        }
    }*/

    private static <E extends Entity> void registerEntityRenderer(Class<E> entityClass, Class<? extends Render<E>> renderClass)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<E>(renderClass));
    }

    private static class EntityRenderFactory<E extends Entity> implements IRenderFactory<E>
    {
        private Class<? extends Render<E>> renderClass;

        private EntityRenderFactory(Class<? extends Render<E>> renderClass)
        {
            this.renderClass = renderClass;
        }

        @Override
        public Render<E> createRenderFor(RenderManager manager)
        {
            Render<E> renderer = null;

            try {
                renderer = renderClass.getConstructor(RenderManager.class).newInstance(manager);
            }

            catch (Exception e) {
                e.printStackTrace();
            }

            return renderer;
        }
    }

    /**
     @Override
     public int registerArmor(String armor)
     {
     return RenderingRegistry.addNewArmourRendererPrefix(armor);
     }
     **/

    /**
     @Override
     public void setClientEnvironment()
     {
     //if (ModConfig.enableRealisticDarkness)
     }
     **/

    @Override
    public void registerSounds() {
        //MinecraftForge.EVENT_BUS.register(new ModSounds());//register the sound event handling class
    }

    @Override
    public void registerTickHandler()
    {
        //FMLCommonHandler.instance().bus().register(new ClientTickHandler());
    }
}
