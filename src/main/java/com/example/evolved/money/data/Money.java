package com.example.evolved.money.data;

public class Money implements Interface_money
{
    private int moneyPoints = 0;

    @Override
    public void money(int money) {
        this.moneyPoints = money;

        if (this.moneyPoints < 0) this.moneyPoints = 0;
    }

    @Override
    public void addMoney(int money) {
        this.moneyPoints += money;
    }

    @Override
    public void removeMoney(int money) {
        this.moneyPoints -= money;
    }

    @Override
    public int getMoney() {
        return this.moneyPoints;
    }
}

