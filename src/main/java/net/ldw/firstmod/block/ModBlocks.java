package net.ldw.firstmod.block;

import net.ldw.firstmod.FirstMod;
import net.ldw.firstmod.item.ModItems;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    //方块
    public static final RegistryObject<Block> SAPPHIRE_BLOCK=registerBlock("sapphire_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));




    //注册方块
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        //注册方块
        RegistryObject<T> toreturn=BLOCKS.register(name,block);
        //注册方块为物品
        registerBlockItem(name,toreturn);
        //返回方块
        return toreturn;
    }


    //注册方块为物品
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T>block){
        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
