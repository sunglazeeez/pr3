import java.util.ArrayList;
import java.util.List;
public class Builder {
    static void createBasicBuild() {
        List<Processor> processors = new ArrayList<>();
        List<Motherboard> motherboards = new ArrayList<>();
        List<GraphicCard> graphicsCards = new ArrayList<>();

        processors.add(new Processor(TypeProcessor.AMD, "Ryzen 9", 3.7, 400.0));
        processors.add(new Processor(TypeProcessor.Intel, "Core i9", 4.2, 450.0));
        processors.add(new Processor(TypeProcessor.AMD, "Ryzen 7", 3.5, 300.0));

        motherboards.add(new Motherboard("ATX", "ASUS", 180.0));
        motherboards.add(new Motherboard("Micro ATX", "Gigabyte", 130.0));
        motherboards.add(new Motherboard("Mini ITX", "MSI", 110.0));

        graphicsCards.add(new GraphicCard("NVIDIA", "RTX 3080", 800.0));
        graphicsCards.add(new GraphicCard("AMD", "RX 6700 XT", 450.0));
        graphicsCards.add(new GraphicCard("NVIDIA", "RTX 3070", 600.0));

        createBuild2(processors, motherboards, graphicsCards, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
    private static void createBuild2(List<Processor> processors, List<Motherboard> motherboards, List<GraphicCard> graphicsCards,
                                     List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        ComputerBuilder build = new ComputerBuilder();

        for (TypeComponent type : TypeComponent.values()) {
            if (type == TypeComponent.PROCESSOR || type == TypeComponent.MOTHERBOARD || type == TypeComponent.GRAPHICS_CARD) {
                DisplayComponents.displayComponents(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
                int choice = Choise.getUserChoice(type);
                switch (type) {
                    case PROCESSOR:
                        build.addComponent(processors.get(choice - 1));
                        break;
                    case MOTHERBOARD:
                        build.addComponent(motherboards.get(choice - 1));
                        break;
                    case GRAPHICS_CARD:
                        build.addComponent(graphicsCards.get(choice - 1));
                        break;
                }
            }
        }

        double totalPrice = build.calculateTotalPrice();

        System.out.println("\nВаша обрана конфігурація ПК:");
        build.displayConfiguration();
        System.out.println("Загальна сума: $" + totalPrice);
    }
}

