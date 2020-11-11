package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedSpellSet extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedSpellSet.class, "set spell [seed] property %string% in %spell% to %spell%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;
    private Expression<SpellSeed> value;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.setSpellProps(key.getSingle(event), value.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "set spell seed property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
            value = (Expression<SpellSeed>) expressions[2];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
