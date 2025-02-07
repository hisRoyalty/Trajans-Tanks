package com.crescentine.trajanstanks.item;

import com.crescentine.trajanscore.basetank.BaseATEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ATSpawnEgg extends Item {
    public boolean standard;
    public boolean apcr;
    public boolean piercing;
    public boolean heat;
    public boolean lowCalibar;
    public boolean highExplosive;
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final Supplier<? extends EntityType<? extends BaseATEntity>> type;

    public ATSpawnEgg(Properties properties, Supplier<? extends EntityType<? extends BaseATEntity>> type, boolean standardShell,
                      boolean apcrShell, boolean piercingShell, boolean heatShell, boolean lowCalibarShell, boolean highExplosiveShell) {
        super(properties.stacksTo(1));
        this.type = type;
        this.standard = standardShell;
        this.apcr = apcrShell;
        this.piercing = piercingShell;
        this.heat = heatShell;
        this.lowCalibar = lowCalibarShell;
        this.highExplosive = highExplosiveShell;
    }


    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        HitResult hitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = pPlayer.getViewVector(1.0F);
            double d0 = 5.0D;
            List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 vec31 = pPlayer.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                BaseATEntity tank = type.get().create(pLevel);
                tank.setPos(hitresult.getLocation().x(), hitresult.getLocation().y(), hitresult.getLocation().z());
                tank.setYRot(pPlayer.getYRot());
                tank.yRotO = pPlayer.yRotO;


                if (!pLevel.noCollision(tank, tank.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!pLevel.isClientSide) {
                        pLevel.addFreshEntity(tank);
                        pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if (!pPlayer.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        CompoundTag entityTag = pStack.getTagElement("Compound");
        pTooltipComponents.add(Component.literal("Ammo").withStyle(ChatFormatting.AQUA));
        if (standard) {
            pTooltipComponents.add(Component.literal("Standard Shell"));
        }
        if (apcr) {
            pTooltipComponents.add(Component.literal("APCR Shell"));
        }
        if (piercing) {
            pTooltipComponents.add(Component.literal("Piercing Shell"));
        }
        if (heat) {
            pTooltipComponents.add(Component.literal("Heat Shell"));
        }
        if (lowCalibar) {
            pTooltipComponents.add(Component.literal("Low Calibar Shell"));
        }
        //pTooltipComponents.add(Component.literal("Netherite").withStyle(ChatFormatting.LIGHT_PURPLE));

    }
}