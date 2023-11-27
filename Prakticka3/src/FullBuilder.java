import java.util.ArrayList;
import java.util.List;
public class FullBuilder {
    public static void createFullBuild() {
        List<Processor> processors = new ArrayList<>();
        List<Motherboard> motherboards = new ArrayList<>();
        List<GraphicCard> graphicsCards = new ArrayList<>();
        List<PowerSupply> powerSupplies = new ArrayList<>();
        List<SsdDrive> ssdDrives = new ArrayList<>();
        List<SoundCard> soundCards = new ArrayList<>();

        processors.add(new Processor(TypeProcessor.AMD, "Ryzen 5", 3.5, 400.0));
        processors.add(new Processor(TypeProcessor.Intel, "Core i7", 4.2, 450.0));
        processors.add(new Processor(TypeProcessor.AMD, "Ryzen 3", 3.5, 300.0));

        motherboards.add(new Motherboard("ATX", "ASUS", 180.0));
        motherboards.add(new Motherboard("Micro ATX", "Gigabyte", 130.0));
        motherboards.add(new Motherboard("Mini ITX", "MSI", 110.0));

        graphicsCards.add(new GraphicCard("NVIDIA", "RTX 2070TI", 800.0));
        graphicsCards.add(new GraphicCard("AMD", "RX 580", 450.0));
        graphicsCards.add(new GraphicCard("NVIDIA", "GTX 1060", 600.0));

        powerSupplies.add(new PowerSupply("600W", "EVGA", 70.0));
        powerSupplies.add(new PowerSupply("700W", "Corsair", 90.0));
        powerSupplies.add(new PowerSupply("800W", "Seasonic", 120.0));

        ssdDrives.add(new SsdDrive("512GB", "Samsung", 90.0));
        ssdDrives.add(new SsdDrive("1.5TB", "Crucial", 150.0));
        ssdDrives.add(new SsdDrive("2TB", "Western Digital", 200.0));

        soundCards.add(new SoundCard("7.1", "Creative", 60.0));
        soundCards.add(new SoundCard("5.1", "ASUS", 80.0));
        soundCards.add(new SoundCard("2.1", "Logitech", 50.0));


        createBuild(processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
    }

    private static void createBuild(List<Processor> processors, List<Motherboard> motherboards, List<GraphicCard> graphicsCards,
                                    List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        ComputerBuilder build = new ComputerBuilder();

        for (TypeComponent type : TypeComponent.values()) {
            DisplayComponents.displayComponents(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
            int choice = Choise.getUserChoice(type);

            if (choice >= 0) {
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
                    case POWER_SUPPLY:
                        build.addComponent(powerSupplies.get(choice - 1));
                        break;
                    case SSD_DRIVE:
                        build.addComponent(ssdDrives.get(choice - 1));
                        break;
                    case SOUND_CARD:
                        build.addComponent(soundCards.get(choice - 1));
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
