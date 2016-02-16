package com.kitsu.medievalcraft.block.machines;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.Random;

import com.kitsu.medievalcraft.Main;
import com.kitsu.medievalcraft.block.ModBlocks;
import com.kitsu.medievalcraft.entity.EntityCannonBall;
import com.kitsu.medievalcraft.entity.EntityModelArrow;
import com.kitsu.medievalcraft.entity.ProjectileCannonBall;
import com.kitsu.medievalcraft.item.ModItems;
import com.kitsu.medievalcraft.renderer.RenderId;
import com.kitsu.medievalcraft.tileents.cannon.TileCannon_28;
import com.kitsu.medievalcraft.tileents.machine.TileEntityFirebox;
import com.kitsu.medievalcraft.util.CustomTab;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Cannon_28 extends BlockContainer{

	private final Random random = new Random();

	public Cannon_28(String unlocalizedName, Material material) {
		super(material.iron);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CustomTab.MedievalCraftTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setStepSound(Block.soundTypeAnvil);
		//this.isFlammable(world, x, y, z, face);
		//(xmin, ymin, zmin, 
		// xmax, ymax, zmax)
		this.setBlockBounds(0.0F, 0.00F, 0.0F,
				1.0F, 1.00F, 1.0F);

	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face){
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, random);

	}
	
	private Entity shootCannon(World world, Integer x, Integer y, Integer z){
		EntityCannonBall cannonball = null;
		
		if(world.getBlockMetadata(x, y, z)==3){
			cannonball = new EntityCannonBall(world, (double)x+2, (double)y, (double)z, null);
			cannonball.setVelocity(5+world.rand.nextFloat(), 0.25, (world.rand.nextFloat()*2-1)/5);
		}
		if(world.getBlockMetadata(x, y, z)==2){
			cannonball = new EntityCannonBall(world, (double)x, (double)y, (double)z-2, null);
			cannonball.setVelocity((world.rand.nextFloat()*2-1)/5, 0.25, -5-world.rand.nextFloat());
		}
		if(world.getBlockMetadata(x, y, z)==1){
			cannonball = new EntityCannonBall(world, (double)x-2, (double)y, (double)z, null);
			cannonball.setVelocity(-5-world.rand.nextFloat(), 0.25, (world.rand.nextFloat()*2-1)/5);
		}
		if(world.getBlockMetadata(x, y, z)==0){
			cannonball = new EntityCannonBall(world, (double)x, (double)y, (double)z+2, null);
			cannonball.setVelocity((world.rand.nextFloat()*2-1)/5, 0.25, 5+world.rand.nextFloat());
		}
		return cannonball;
	}

	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		if(!world.isRemote){
			TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);
			if(tileEnt.isOn==false){
				if(player.inventory.getCurrentItem()!=null){
					if(player.inventory.getCurrentItem().getItem()==Items.flint_and_steel){
						tileEnt.isOn=true;
						world.playSoundEffect(x, y, z, "random.fizz", 0.1f, world.rand.nextFloat()/0.5f * 0.1F + 0.8F);
						world.playSoundEffect(x, y, z, "random.explode", 0.5f, world.rand.nextFloat()/0.5f * 0.1F + 0.8F);

						world.spawnEntityInWorld(shootCannon(world,x,y,z));
						tileEnt.markForUpdate();
						tileEnt.markDirty();
						return true;
					}
				}
			}
		}
		return false;
	}
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		if (world.isBlockIndirectlyGettingPowered(x, y, z))
		{
			TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);
			if(tileEnt.isOn==false){
				tileEnt.isOn=true;
				world.playSoundEffect(x, y, z, "random.fizz", 0.1f, world.rand.nextFloat()/0.5f * 0.1F + 0.8F);
				world.playSoundEffect(x, y, z, "random.explode", 0.5f, world.rand.nextFloat()/0.5f * 0.1F + 0.8F);
				world.spawnEntityInWorld(shootCannon(world, x, y, z));
				tileEnt.markForUpdate();
				tileEnt.markDirty();
			}
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack p_149689_6_) {
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3; 
		world.setBlockMetadataWithNotify(x, y, z, dir, 0);
		System.out.println(dir);
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileCannon_28 tileEnt = (TileCannon_28) world.getTileEntity(x, y, z);

		if (tileEnt != null) {
			for (int i = 0; i < tileEnt.getSizeInventory(); ++i) {
				ItemStack itemstack = tileEnt.getStackInSlot(i);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = this.random.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, x + f, y + f1, z + f2, new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (float) this.random.nextGaussian() * f3;
						entityitem.motionY = (float) this.random.nextGaussian() * f3 + 0.1F;
						entityitem.motionZ = (float) this.random.nextGaussian() * f3;
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileCannon_28();
	}
	@Override
	public int getRenderType() {
		return RenderId.cannon_28ID;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
