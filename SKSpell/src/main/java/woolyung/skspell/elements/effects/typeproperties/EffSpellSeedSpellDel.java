package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedSpellDel extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedSpellDel.class, "(del[ete]|remove) spell [seed] property %string% in %spell%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.deleteSpellProps(key.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "delete location property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
