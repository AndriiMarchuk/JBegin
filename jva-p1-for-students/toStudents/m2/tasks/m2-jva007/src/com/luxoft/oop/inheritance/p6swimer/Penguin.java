package com.luxoft.oop.inheritance.p6swimer;

public class Penguin implements Swimmer
{
    @Override
    public void swim()
    {
        // A penguin is able to swim, but not able to fly
        // Compiler error! Cannot reduce the visibility of the inherited method from Swimmer
    }
}
