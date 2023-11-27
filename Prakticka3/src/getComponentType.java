import java.util.List;
import java.util.ArrayList;
public class getComponentType {
    public static List<? extends ConfigurableItem> getComponentsByType(TypeComponent type,
                                                                       List<Processor> processors, List<Motherboard> motherboards,
                                                                       List<GraphicCard> graphicsCards, List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives,
                                                                       List<SoundCard> soundCards) {
        switch (type) {
            case PROCESSOR:
                return processors;
            case MOTHERBOARD:
                return motherboards;
            case GRAPHICS_CARD:
                return graphicsCards;
            case POWER_SUPPLY:
                return powerSupplies;
            case SSD_DRIVE:
                return ssdDrives;
            case SOUND_CARD:
                return soundCards;
            default:
                return new ArrayList<>();
        }
    }
}
