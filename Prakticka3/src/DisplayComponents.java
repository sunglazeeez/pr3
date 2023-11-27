import java.util.List;
public class DisplayComponents {
    public static void displayComponents(TypeComponent type, List<Processor> processors, List<Motherboard> motherboards, List<GraphicCard> graphicsCards, List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        System.out.println("Доступні " + type.toString() + " компоненти:");
        List<? extends ConfigurableItem> components = getComponentType.getComponentsByType(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);

        for (int i = 0; i < components.size(); i++) {
            System.out.println((i + 1) + ". " + components.get(i).getDescription() + " - Ціна: $" + components.get(i).getPrice());
        }
    }
}
