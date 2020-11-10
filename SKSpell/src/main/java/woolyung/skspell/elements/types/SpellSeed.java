package woolyung.skspell.elements.types;

import ch.njol.util.VectorMath;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.HashMap;

public class SpellSeed {

    private String name;
    private Entity owner;
    private Location location;
    private HashMap<String, Integer> intProps = new HashMap<>();
    private HashMap<String, Double> numProps = new HashMap<>();
    private HashMap<String, String> strProps = new HashMap<>();
    private HashMap<String, Vector> vecProps = new HashMap<>();
    private HashMap<String, Entity> entityProps = new HashMap<>();
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

    public Integer getIntProps(String key) {
        if (intProps.containsKey(key))
            return intProps.get(key);
        return null;
    }

    public Double getNumProps(String key) {
        if (numProps.containsKey(key))
            return numProps.get(key);
        return null;
    }

    public String getStrProps(String key) {
        if (strProps.containsKey(key))
            return strProps.get(key);
        return null;
    }

    public Vector getVecProps(String key) {
        if (vecProps.containsKey(key))
            return vecProps.get(key);
        return null;
    }

    public Entity getEntityProps(String key) {
        if (entityProps.containsKey(key))
            return entityProps.get(key);
        return null;
    }

    public void setIntProps(String key, int value) {
        if (intProps.containsKey(key))
            intProps.remove(key);
        intProps.put(key, value);
    }

    public void setNumProps(String key, double value) {
        if (numProps.containsKey(key))
            numProps.remove(key);
        numProps.put(key, value);
    }

    public void setStrProps(String key, String value) {
        if (strProps.containsKey(key))
            strProps.remove(key);
        strProps.put(key, value);
    }

    public void setVecProps(String key, Vector value) {
        if (vecProps.containsKey(key))
            vecProps.remove(key);
        vecProps.put(key, value.clone());
    }

    public void setEntityProps(String key, Entity value) {
        if (entityProps.containsKey(key))
            entityProps.remove(key);
        entityProps.put(key, value);
    }

    public void deleteIntProps(String key) {
        if (intProps.containsKey(key))
            intProps.remove(key);
    }

    public void deleteNumProps(String key) {
        if (numProps.containsKey(key))
            numProps.remove(key);
    }

    public void deleteStrProps(String key) {
        if (strProps.containsKey(key))
            strProps.remove(key);
    }

    public void deleteVecProps(String key) {
        if (vecProps.containsKey(key))
            vecProps.remove(key);
    }

    public void deleteEntityProps(String key) {
        if (entityProps.containsKey(key))
            entityProps.remove(key);
    }
}
