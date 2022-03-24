package com.vuluong.designpattern.templatemethod;

public class HighEndComputerBuilder extends ComputerBuilder {

    @Override
    public void addMotherboard() {
        computerParts.put("Motherboard", "High-end Motherboard");
    }

    @Override
    public void setupMotherboard() {
        motherboardSetupStatus.add("Screwing the High-end motherboard to the case.");
        motherboardSetupStatus.add("Plugging in the power supply connectors.");
        motherboardSetupStatus.forEach(System.out::println);
    }

    @Override
    public void addProcessor() {
        computerParts.put("Processor", "High-end Processor");
    }
}
