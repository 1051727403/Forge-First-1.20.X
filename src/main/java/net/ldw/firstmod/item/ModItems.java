package net.ldw.firstmod.item;

import net.ldw.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    //创建蓝宝石，与assert.models.item中的名称一致
    public static final RegistryObject<Item> SAPPHIRE=registerItem("sapphire",
            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE=registerItem("raw_sapphire",
            ()->new Item(new Item.Properties()));


    //注册物品封装，使用T泛型可以使得物品自定义特殊效果
    public static <T extends Item>RegistryObject<T>registerItem(String name, Supplier<T>item){
        RegistryObject<T> toreturn=ITEMS.register(name,item);
        return toreturn;
    }


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
