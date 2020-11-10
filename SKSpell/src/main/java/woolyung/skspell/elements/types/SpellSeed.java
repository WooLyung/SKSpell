package woolyung.skspell.elements.types;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SpellSeed {

    private String name;
    private Entity owner;
    private Location location;
    private double time = 0;

    public static String getDefaultName() {
        return "new spell seed";
    }

    public SpellSeed() {
        name = getDefaultName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location.clone();
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getString() {
        return "spell seed named \"" + name + "\"";
    }
}
