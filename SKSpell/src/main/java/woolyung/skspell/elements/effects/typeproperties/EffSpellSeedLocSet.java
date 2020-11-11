package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedLocSet extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedLocSet.class, "set loc[ation] property %string% in %spell% to %location%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;
    private Expression<Location> value;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.setLocProps(key.getSingle(event), value.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "set location property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
            value = (Expression<Location>) expressions[2];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
