package emerald_gear;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EmeraldGear implements ModInitializer {
    public static final String MOD_ID = "emerald-gear";

    // 1. Изумрудное яблоко
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
        // Регистрация предметов
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_apple"), EMERALD_APPLE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_sword"), EMERALD_SWORD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "emerald_pickaxe"), EMERALD_PICKAXE);

        // Добавление предметов во вкладки креатива
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.add(EMERALD_APPLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(EMERALD_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(EMERALD_PICKAXE);
        });
    }
}
