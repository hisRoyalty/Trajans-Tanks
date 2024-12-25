package com.crescentine.trajanstanks.entity.artillery.pak40;

import com.crescentine.trajanscore.example_at.ExampleATEntity;
import com.crescentine.trajanstanks.TankMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class Pak40Model extends GeoModel<Pak40Entity>
{
    public ResourceLocation getModelResource(Pak40Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "geo/artillery.geo.json");
    }

    public ResourceLocation getTextureResource(Pak40Entity object) {
        return new ResourceLocation(TankMod.MOD_ID, "textures/item/artillery.png");
    }

    public ResourceLocation getAnimationResource(Pak40Entity animatable) {
        return new ResourceLocation(TankMod.MOD_ID, "animations/artillery_animation.json");
    }


    @Override
    public void setCustomAnimations(Pak40Entity animatable, long instanceId, AnimationState<Pak40Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        CoreGeoBone gun = this.getAnimationProcessor().getBone("Barrel");
        CoreGeoBone main = this.getAnimationProcessor().getBone("Artillery");
        gun.setRotY(0f);
        main.setRotY(0f);

        if (animatable.getControllingPassenger()!=null) {
            Entity rider = animatable.getControllingPassenger();
            if (animatable.isVehicle()) {
                float elevationAngle = rider.getXRot();
                main.setRotY((float) Math.toRadians(-animatable.getYRot()));

                float maxElevation = 9;
                float minElevation = -3;

                if (elevationAngle > maxElevation) {
                    elevationAngle = maxElevation;
                } else if (elevationAngle < minElevation) {
                    elevationAngle = minElevation;
                }

                float targetGunRotZ = (float) Math.toRadians(elevationAngle);

                float lerpFactor = 1;

                gun.setRotX(-targetGunRotZ);


            }
        } else {
            main.setRotY((float) Math.toRadians(-animatable.getLastYRot()));
        }
    }

}