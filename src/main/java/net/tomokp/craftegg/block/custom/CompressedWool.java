package net.tomokp.craftegg.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CompressedWool extends HalfTransparentBlock {
    public CompressedWool(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float v) {
        if (entity.isSuppressingBounce()) {
            entity.causeFallDamage(v, 0.2F, level.damageSources().fall());
        } else {
            entity.causeFallDamage(v, 0.0F, level.damageSources().fall());
        }
    }

    public void updateEntityAfterFallOn(BlockGetter blockGetter, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(blockGetter, entity);
        } else {
            this.bounceUp(entity);
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0D) {
            double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
            double multiplier;
            System.out.println(vec3.y);
            if (vec3.y>-1){
                multiplier = 1.3;
            }else {
                multiplier = 1.2;
            }
            entity.setDeltaMovement(vec3.x, -vec3.y * d0 * multiplier, vec3.z);
        }

    }

    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        double d0 = Math.abs(entity.getDeltaMovement().y);
        if (d0 < 0.1D && !entity.isSteppingCarefully()) {
            double d1 = 0.4D + d0 * 0.2D;
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(d1, 1.0D, d1));
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
