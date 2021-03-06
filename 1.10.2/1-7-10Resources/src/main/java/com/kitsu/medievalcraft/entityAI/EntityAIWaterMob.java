package com.kitsu.medievalcraft.entityAI;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;

public class EntityAIWaterMob extends EntityWaterMob implements IAnimals{

	protected int attackInterval = 50;
	protected float attackSpeed = 1.2F;
	protected float swimSpeed = 0.5F;
	private double targetX;
	private double targetY;
	private double targetZ;
	private Entity targetedEntity;
	private boolean isAttacking;
	protected float swimRadius = 4.0F;
	protected float swimRadiusHeight = 4.0F;
	protected boolean Agrooed = false;
	protected boolean landBounce = true;
	protected float moreDamage = 0.5F;
	public Profiler theProfiler;


	public EntityAIWaterMob(World world)
	{
		super(world);
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntitySquid.class, 32, true, true, IMob.mobSelector));
	}


	protected boolean canTriggerWalking()
	{
		return false;
	}

	protected boolean isAIEnabled()
	{
		return true;
	}
	public boolean canBreatheUnderwater()
	{
		return true;
	}
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
	}

	public boolean isInWater()
	{
		return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
	}

	public void onUpdate()
	{
		super.onUpdate();
		if (isInWater()) {
			this.motionY *= 0.1D;
		}
	}
	public void applyEntityCollision(Entity entity)
	{
		super.applyEntityCollision(entity);
		if ((this.Agrooed) && (this.targetedEntity == entity)) 
		{
			attackEntityAsMob(entity);

		}
	}


	protected Entity findPreyHuman()
	{
		EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
		return (player != null) && (canEntityBeSeen(player)) ? player : null;

	}
	

	public boolean attackEntityAsMob(Entity entity)
	{
		float f = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

		return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f + moreDamage);

	}


	public void onEntityUpdate()
	{
		int air = getAir();
		super.onEntityUpdate();
		if ((isEntityAlive()) && (!isInWater()))
		{
			air--;
			setAir(air);
			if (getAir() == -20)
			{
				setAir(0);
				attackEntityFrom(DamageSource.drown, 2.0F);
			}
		}
		else
		{
			setAir(300);
		}
	}


	protected void updateAITasks()
	{
		super.updateAITasks();
		if (isInWater())
		{
			double dx = this.targetX - this.posX;
			double dy = this.targetY - this.posY;
			double dz = this.targetZ - this.posZ;
			double dist = MathHelper.sqrt_double(dx * dx + dy * dy + dz * dz);
			if ((dist < 1.0D) || (dist > 1000.0D))
			{
				this.targetX = (this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
				this.targetY = (this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadiusHeight);
				this.targetZ = (this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * this.swimRadius);
				this.isAttacking = false;
			}
			if (this.worldObj.getBlock(MathHelper.floor_double(this.targetX), MathHelper.floor_double(this.targetY + this.height), MathHelper.floor_double(this.targetZ)).getMaterial() == Material.water)
			{
				this.motionX += dx / dist * 0.05D * this.swimSpeed;
				this.motionY += dy / dist * 0.1D * this.swimSpeed;
				this.motionZ += dz / dist * 0.05D * this.swimSpeed;
			}
			else
			{
				this.targetX = this.posX;
				this.targetY = (this.posY + 0.1D);
				this.targetZ = this.posZ;
			}
			if (this.isAttacking)
			{
				this.motionX *= this.attackSpeed;
				this.motionY *= this.attackSpeed;
				this.motionZ *= this.attackSpeed;
			}
			if ((this.Agrooed) && (this.rand.nextInt(this.attackInterval) == 0))
			{
				this.targetedEntity = findPreyHuman();
				if ((this.targetedEntity != null) && (this.targetedEntity.isInWater()))
				{
					this.targetX = this.targetedEntity.posX;
					this.targetY = this.targetedEntity.posY;
					this.targetZ = this.targetedEntity.posZ;
					this.isAttacking = true;
				}

			}
			this.renderYawOffset += (-(float)Math.atan2(this.motionX, this.motionZ) * 180.0F / 3.141593F - this.renderYawOffset) * 0.5F;
			this.rotationYaw = this.renderYawOffset;
			float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.rotationPitch += ((float)Math.atan2(this.motionY, f) * 180.0F / 3.141593F - this.rotationPitch) * 0.5F;
		}
		else
		{
			this.motionX = 0.0D;
			this.motionY -= 0.08D;
			this.motionY *= 0.9800000190734863D;
			this.motionZ = 0.0D;
			if ((this.landBounce) && (this.onGround) && (this.rand.nextInt(30) == 0))
			{
				this.motionY = 0.300000011920929D;
				this.motionX = (-0.4F + this.rand.nextFloat() * 0.8F);
				this.motionZ = (-0.4F + this.rand.nextFloat() * 0.8F);
			}
		}
	}

}

/*when you extend it,
you want to add these to your constructor:

this.Agrooed = true;
    this.swimRadius = 25F;
    this.swimSpeed = 0.5F;
    this.attackInterval = 23;
    this.landBounce = true;

what these stand for are pretty self explanitory. add this to your class:

    @Override
    protected Entity findPrey()
    {
        AxisAlignedBB area = this.boundingBox.expand(16.0D, 16.0D, 16.0D);

        EntityPlayer player = (EntityPlayer)super.findPrey();
        if (player != null) {
            return player;
        }

        return worldObj.findNearestEntityWithinAABB(EntityPlayer.class, area, this);
 */

