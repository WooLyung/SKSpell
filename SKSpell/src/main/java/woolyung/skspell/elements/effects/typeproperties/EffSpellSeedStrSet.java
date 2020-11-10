package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedStrSet extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedStrSet.class, "set str[ing] property %string% in %spell% to %string%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;
    private Expression<String> value;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.setStrProps(key.getSingle(event), value.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "set string property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
            value = (Expression<String>) expressions[2];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
