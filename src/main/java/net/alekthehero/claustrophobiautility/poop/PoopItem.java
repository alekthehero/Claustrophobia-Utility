package net.alekthehero.claustrophobiautility.poop;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PoopItem extends Item {
    final static int MAX_STACK_SIZE = 16;
    final static MobEffectInstance POOP_EFFECT = new MobEffectInstance(MobEffects.CONFUSION, 200, 1);
    final static FoodProperties POOP_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.3f)
            .effect(() -> POOP_EFFECT, 1.0f)
            .build();

    public PoopItem(Properties pProperties) {
        super(pProperties.stacksTo(MAX_STACK_SIZE).food(POOP_FOOD_PROPERTIES));
    }
}
