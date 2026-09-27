package emerald_gear;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EmeraldGear implements ModInitializer {
    public static final String MOD_ID = "emerald-gear";

    // 1. Изумрудное яблоко (Герой Деревни V + Удача II)
    public static final Item EMERALD_APPLE = new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .hunger(6)
                    .saturationModifier(1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 6000, 4), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 6000, 1), 1.0f)
                    .alwaysEdible()
                    .build()));

    // 2. Изумрудный меч
    public static final Item EMERALD_SWORD = new SwordItem(
            ToolMaterials.DIAMOND, 4, -2.2f, new Item.Settings());

    // 3. Изумрудная кирка
    public static final Item EMERALD_PICKAXE = new PickaxeItem(
            ToolMaterials.DIAMOND, 2, -2.8f, new Item.Settings());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_apple"), EMERALD_APPLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_sword"), EMERALD_SWORD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_pickaxe"), EMERALD_PICKAXE);
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}