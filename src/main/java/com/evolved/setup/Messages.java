package com.evolved.setup;

import com.evolved.money.network.PacketGetMoney;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;
//import net.minecraftforge.network.NetworkRegistry;
//import net.minecraftforge.network.simple.SimpleChannel;

public class Messages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() { return packetId++;}

//    public static void register() {
//        SimpleChannel net = NetworkRegistry.ChannelBuilder
//                .named(new ResourceLocation(Evolved.MODID, "messages"))
//                .networkProtocolVersion(() -> "1.0")
//                .clientAcceptedVersions(s -> true)
//                .serverAcceptedVersions(s -> true)
//                .simpleChannel();
//
//        INSTANCE = net;
//    }
}