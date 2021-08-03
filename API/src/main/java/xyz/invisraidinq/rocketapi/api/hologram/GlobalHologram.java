package xyz.invisraidinq.rocketapi.api.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import xyz.invisraidinq.rocketapi.api.utils.CC;

import java.util.ArrayList;
import java.util.List;

public class GlobalHologram {

    private final List<ArmorStand> armorStands = new ArrayList<>();
    private List<String> lines = new ArrayList<>();
    private Location spawnLocation;

    public GlobalHologram(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public void addLine(String line) {
        this.lines.add(line);
    }

    public void removeLine(int index) {
        this.lines.remove(index);
    }

    public void create() {
        double offset = 0;
        for (String line : this.lines) {
            Location offsetLocation = new Location(this.spawnLocation.getWorld(), this.spawnLocation.getX(), this.spawnLocation.getY() - offset, this.spawnLocation.getZ());
            ArmorStand armorStand = (ArmorStand) this.spawnLocation.getWorld().spawnEntity(offsetLocation, EntityType.ARMOR_STAND);
            armorStand.setCustomName(CC.colour(line));
            armorStand.setCustomNameVisible(true);
            armorStand.setGravity(false);
            armorStand.setVisible(false);
            offset = offset + 0.3;
            this.armorStands.add(armorStand);
        }
    }

    public void update() {
        if (this.lines.size() != this.armorStands.size()) {
            this.remove();
            this.create();
            return;
        }

        for (ArmorStand armorStand : this.armorStands) {
            int index = this.armorStands.indexOf(armorStand);
            armorStand.setCustomName(CC.colour(this.lines.get(index)));
        }
    }

    public void remove() {
        this.armorStands.forEach(ArmorStand::remove);
        this.armorStands.clear();
    }
}
