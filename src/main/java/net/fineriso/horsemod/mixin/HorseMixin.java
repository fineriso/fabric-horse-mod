package net.fineriso.horsemod.mixin;
import net.fineriso.horsemod.Horsemod;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public class HorseMixin {
    @Inject( method = "createBaseHorseAttributes", at = @At("HEAD"), cancellable = true )
    private static void createBaseHorseAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
        DefaultAttributeContainer.Builder building = AnimalEntity.createAnimalAttributes()
                .add(EntityAttributes.JUMP_STRENGTH, 0.7)
                .add(EntityAttributes.MAX_HEALTH, 53.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.225F)
                .add(EntityAttributes.STEP_HEIGHT, 1.1)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 6.0)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.5);
        info.setReturnValue(building);
        info.cancel();
    }
}