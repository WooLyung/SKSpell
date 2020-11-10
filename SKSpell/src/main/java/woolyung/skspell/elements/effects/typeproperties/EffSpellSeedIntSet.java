package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedIntSet extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedIntSet.class, "set int[eger] property %string% in %spell% to %integer%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;
    private Expression<Integer> value;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.setIntProps(key.getSingle(event), value.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "set integer property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
            value = (Expression<Integer>) expressions[2];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
