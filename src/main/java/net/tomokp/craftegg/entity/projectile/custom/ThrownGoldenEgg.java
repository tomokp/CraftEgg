package net.tomokp.craftegg.entity.projectile.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.tomokp.craftegg.item.ModItems;
import net.tomokp.craftegg.item.custom.GoldenEggItem;

public class ThrownGoldenEgg extends ThrowableItemProjectile {
    public ThrownGoldenEgg(EntityType<? extends ThrownGoldenEgg> type, Level level) {
        super(type, level);
    }

    public ThrownGoldenEgg(Level level, LivingEntity entity) {
        super(EntityType.EGG, entity, level);
    }

    public ThrownGoldenEgg(Level level, double v, double v1, double v2) {
        super(EntityType.EGG, v, v1, v2, level);
    }

    public void handleEntityEvent(byte b) {
        if (b == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        entityHitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            if (this.random.nextInt(2) == 0) {
                int i = 10;
                if (this.random.nextInt(10000) == 0) {
                    Boat boat = EntityType.BOAT.create(this.level());
                    boat.moveTo(this.getX() + random.nextInt(2), this.getY(), this.getZ() + random.nextInt(2), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boat);
                    //yes you see this right, there is a 1 in 10,000 chance the chickens spawn alongside a boat :)
                }
                for(int j = 0; j < i; ++j) {
                    Chicken chicken = EntityType.CHICKEN.create(this.level());
                    if (chicken != null) {
                        chicken.setAge(-24000);
                        chicken.moveTo(this.getX()+random.nextInt(2), this.getY(), this.getZ()+random.nextInt(2), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(chicken);
                    }
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    protected Item getDefaultItem() {
        return Items.EGG;

    }
}
