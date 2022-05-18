package com.example.evolved.energy;

import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergy extends EnergyStorage {

    public CustomEnergy(int capacity, int maxTransfer){
        super(capacity,maxTransfer,0);
    }

    protected void onEnergyChanged(){

    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
       int rc = super.receiveEnergy(maxReceive,simulate);
       if (rc >0 && !simulate){
           onEnergyChanged();
       }
           return rc;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        onEnergyChanged();
    }

    public void addEnergy(int energy){
        this.energy += energy;
        if (this.energy > getMaxEnergyStored()){
            this.energy = getEnergyStored();
        }
    }

    public void consumeEnergy(int energy){

    }

}
