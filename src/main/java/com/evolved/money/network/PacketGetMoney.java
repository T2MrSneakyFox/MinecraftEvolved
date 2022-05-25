package com.evolved.money.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketGetMoney {
    //public static final String = MESSAGE_NO_MONEY "message.nobalance";

    public PacketGetMoney(){

    }

    public PacketGetMoney(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context ctx = supplier.get();
        ctx.enqueueWork(() ->{
            ServerPlayer player = ctx.getSender();
            //hier komt de code voor money toe te voegen na een keybind
        });
        return true;
    }
}
