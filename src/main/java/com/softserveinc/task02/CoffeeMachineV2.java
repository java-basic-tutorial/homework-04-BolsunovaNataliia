package com.softserveinc.task02;

import com.softserveinc.task01.CoffeeMachineV1;

public class CoffeeMachineV2 extends CoffeeMachineV1 {

    protected final int  milkReservoirCapacity;

    private int milk;

    public CoffeeMachineV2(int coffeeBeanStorageCapacity, int waterReservoirCapacity, int wasteCoffeeBeanCapacity, int milkReservoirCapacity) {
        super(coffeeBeanStorageCapacity, waterReservoirCapacity, wasteCoffeeBeanCapacity);
        this.milkReservoirCapacity = milkReservoirCapacity;
    }

    public void addMilk(int milk) {
        this.milk = Math.min(milk + this.milk, milkReservoirCapacity);
    }

    public int getMilk() {
        return milk;
    }

    public boolean makeCappuccino() {
        int milk = 85;
        if (!makeEspresso()) { return false; }
        if (milk > this.milk) {
            System.err.println("Not enough milk");
            return false;
        }
        this.milk -= milk;
        return true;
    }

    public boolean makeLatte() {
        int milk = 150;
        if (!makeEspresso()) { return false; }
        if (milk > this.milk) {
            System.err.println("Not enough milk");
            return false;
        }
        this.milk -= milk;
        return true;
    }
}
