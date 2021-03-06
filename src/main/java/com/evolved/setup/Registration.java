package com.evolved.setup;

import com.evolved.blocks.Generator;
import com.evolved.blocks.GeneratorBE;
import com.evolved.blocks.GeneratorContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.evolved.mainEvolved.MODID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,MODID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITIES.register(bus);
        CONTAINERS.register(bus);
    }
    // blocks
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
    public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.AIR).strength(2f);

    //template public static final RegistryObject<Item>  = ITEMS.register("", () -> new Item(ITEM_PROPERTIES));

    //items
    public static final RegistryObject<Item> SEA_SALT_ITEM = ITEMS.register("salt_water_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> WIRE_ITEM = ITEMS.register("wire_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> ELECTRICAL_CONDUIT_ITEM = ITEMS.register("electrical_conduit_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> BUCKET_OF_SALT_WATER = ITEMS.register("bucket_of_sea_water", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Block> ELECTRICAL_PILLAR = BLOCKS.register("electrical_pillar_item", () -> new Block(BLOCK_PROPERTIES));
    public static final RegistryObject<Item> ELECTRICAL_PILLAR_ITEM = fromBlock(ELECTRICAL_PILLAR);

    //items/ores
    public static final RegistryObject<Block> NICKEL_ORE_OVERWORLD = BLOCKS.register("nickel_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> NICKEL_ORE_ITEM = fromBlock(NICKEL_ORE_OVERWORLD);
    public static final RegistryObject<Block> OBSIDIAN_ORE_OVERWORLD = BLOCKS.register("obsidian_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_ORE_ITEM = fromBlock(OBSIDIAN_ORE_OVERWORLD);
    public static final RegistryObject<Block> ENDER_ORE_END = BLOCKS.register("ender_ore_end", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> ENDER_ORE_ITEM = fromBlock(ENDER_ORE_END);

    //items/ingots
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_INGOT_ITEM = ITEMS.register("obsidian_ingot_item", ()-> new Item(ITEM_PROPERTIES));


    //items/chunks & shards
    public static final RegistryObject<Item> COBALT_SHARD_ITEM = ITEMS.register("cobalt_shard_item",() -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> LITHIUM_SHARD_ITEM = ITEMS.register("lithium_chunk_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> NICKEL_CHUNK_ITEM = ITEMS.register("nickel_chunk_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> OBSIDIAN_SHARD_ITEM = ITEMS.register("obsidian_shard_item", () -> new Item(ITEM_PROPERTIES));


    //items/dust
    public static final RegistryObject<Item> OBSIDIAN_DUST_ITEM = ITEMS.register("obsidian_dust_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> COBALT_DUST_ITEM = ITEMS.register("cobalt_dust_item", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> COAL_DUST_ITEM = ITEMS.register("coal_dust_item", ()-> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> LITHIUM_DUST_ITEM = ITEMS.register("lithium_dust_item", ()-> new Item(ITEM_PROPERTIES));

    //items/coins
    public static final RegistryObject<Item> ONE_COIN = ITEMS.register("1_coin", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> TWO_COIN = ITEMS.register("2_coin", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> FIVE_BUCKS = ITEMS.register("5_bucks", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> TEN_BUCKS = ITEMS.register("10_bucks", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> TWENTY_BUCKS = ITEMS.register("20_bucks", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> FIFTY_BUCKS = ITEMS.register("50_bucks", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> HUNDERD_BUCKS = ITEMS.register("100_bucks", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> TWOHUNDERD_BUCKS = ITEMS.register("200_bucks", () -> new Item(ITEM_PROPERTIES));

    //costume tags
    //costumeTags/items
    public static final  Tags.IOptionalNamedTag <Block> TAG_ELECTRICAL_PILLAR = BlockTags.createOptional(new ResourceLocation(MODID, "electrical_pillar"));

    //costumeTags/ores
    public static final Tags.IOptionalNamedTag<Block> TAG_NICKEL_ORE = BlockTags.createOptional(new ResourceLocation(MODID, "nickel_ore"));
    public static final Tags.IOptionalNamedTag<Item> TAG_NICKEL_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(MODID, "nickel_ore"));

    public static final Tags.IOptionalNamedTag<Item> TAG_LITHIUM_DUST_ITEM = ItemTags.createOptional(new ResourceLocation(MODID, "lithium_dust"));
    public static final Tags.IOptionalNamedTag<Item> TAG_LITHIUM_SHARD_ITEM = ItemTags.createOptional(new ResourceLocation(MODID, "lithium_shard"));


    //costumeTags/ores/rawChunk
    //costumeTags/ingots
    //costumeTags/Generators
    //costumeTags/Money
    public static final Tags.IOptionalNamedTag<Item> MONEY = ItemTags.createOptional(new ResourceLocation(MODID,"money"));
    //items/blocks/generator
    public static final RegistryObject<Generator> GENERATOR = BLOCKS.register("cool_generator", Generator::new);
    public static final RegistryObject<Item> GENERATOR_ITEM = fromBlock(GENERATOR);
    public static final RegistryObject<BlockEntityType<GeneratorBE>> GENERATOR_BE = BLOCK_ENTITIES.register("cool_generator",()-> BlockEntityType.Builder.of(GeneratorBE::new,GENERATOR.get()).build(null));
    public static final RegistryObject<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = CONTAINERS.register("cool_generator",
            ()-> IForgeContainerType.create((windowId, inv, data) -> new GeneratorContainer(windowId, data.readBlockPos(),inv,inv.player)));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
