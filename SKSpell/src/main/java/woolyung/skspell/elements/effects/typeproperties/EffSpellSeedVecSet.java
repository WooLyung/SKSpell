package woolyung.skspell.elements.effects.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedVecSet extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedVecSet.class, "set vec[tor] property %string% in %spell% to %vector%");
    }

    private Expression<String> key;
    private Expression<SpellSeed> spell;
    private Expression<Vector> value;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            seed.setVecProps(key.getSingle(event), value.getSingle(event));
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "set vector property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            key = (Expression<String>) expressions[0];
            spell = (Expression<SpellSeed>) expressions[1];
            value = (Expression<Vector>) expressions[2];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
