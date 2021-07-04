package xyz.invisraidinq.rocketapi.api.serialization;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SerializableLocation {

    /**
     * Serialize an {@link Location} object
     *
     * @param location The {@link Location} to serialize
     * @return A string which can then be deserialized
     */
    public static String serialize(Location location) {
        return String.join(";", new String[] {
                location.getWorld().getName(),
                String.valueOf(location.getX()),
                String.valueOf(location.getY()),
                String.valueOf(location.getZ())
        });
    }

    /**
     * Deserialize an {@link Location} object
     *
     * @param location The location to deserialize as type {@link String}
     * @return The deserialized {@link Location}
     */
    public static Location deserialize(String location) {
        String[] data = location.split(";");
        return new Location(
                Bukkit.getWorld(data[0]),
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]),
                Double.parseDouble(data[3])
        );
    }
}
