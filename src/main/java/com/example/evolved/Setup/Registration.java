package com.example.evolved.Setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

import static com.example.evolved.Evolved.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
    // blocks
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> Test_ORE_OVERWORLD = BLOCKS.register("test_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> Test_ORE_OVERWORLD_ITEM = fromBlock(Test_ORE_OVERWORLD);

    public static final RegistryObject<Block> NICKEL_ORE_OVERWORLD = BLOCKS.register("nickel_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> NICKEL_ORE_ITEM = fromBlock(NICKEL_ORE_OVERWORLD);

    public static final RegistryObject<Block> OBSIDIAN_ORE_OVERWORLD = BLOCKS.register("obsidian_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_ORE_ITEM = fromBlock(OBSIDIAN_ORE_OVERWORLD);

    public static final RegistryObject<Block> ENDER_ORE_END = BLOCKS.register("ender_ore_end", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> ENDER_ORE_ITEM = fromBlock(ENDER_ORE_END);





    // items
    //template public static final RegistryObject<Item>  = ITEMS.register("", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> LITHIUM_ITEM = ITEMS.register("lithium_item",() -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> COBALT_ITEM = ITEMS.register("cobalt_item",() -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> SALT_WATER_ITEM = ITEMS.register("salt_water_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> WIRE_ITEM = ITEMS.register("wire_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> ELECTRICAL_CONDUIT_ITEM = ITEMS.register("electrical_conduit_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_DUST_ITEM = ITEMS.register("obsidian_dust", () -> new Item(ITEM_PROPERTIES));



    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
