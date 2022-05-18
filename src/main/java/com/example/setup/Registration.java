package com.example.setup;

import com.example.items.TestItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.example.evolved.Evolved.MODID;

public class Registration {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init(){
        IEventBus bus =  FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> Test_ORE_OVERWORLD = BLOCKS.register("test_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> Test_ORE_OVERWORLD_ITEM = fromBlock(Test_ORE_OVERWORLD);
    public static final RegistryObject<Block> Test_ORE_NETHER = BLOCKS.register("test_ore_nether", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> Test_ORE_NETHER_ITEM = fromBlock(Test_ORE_NETHER);
    public static final RegistryObject<Block> Test_ORE_END = BLOCKS.register("test_ore_end", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> Test_ORE_END_ITEM = fromBlock(Test_ORE_END);
    public static final RegistryObject<Block> Test_ORE_DEEPSLATE = BLOCKS.register("test_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> Test_ORE_DEEPSLATE_ITEM = fromBlock(Test_ORE_DEEPSLATE);

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

}
