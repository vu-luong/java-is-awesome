package com.vuluong.designpattern.templatemethod;

public class StandardComputerBuilder extends ComputerBuilder {

    @Override
    public void addMotherboard() {
        computerParts.put("Motherboard", "Standard Motherboard");
    }

    @Override
    public void setupMotherboard() {
        motherboardSetupStatus.add("Screwing the standard motherboard to the case.");
        motherboardSetupStatus.add("Plugging in the power supply connectors.");
        motherboardSetupStatus.forEach(System.out::println);
    }

    @Override
    public void addProcessor() {
        computerParts.put("Processor", "Standard Processor");
    }
}
