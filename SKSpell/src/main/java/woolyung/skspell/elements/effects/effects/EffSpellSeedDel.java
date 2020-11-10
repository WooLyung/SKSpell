package woolyung.skspell.elements.effects.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

public class EffSpellSeedDel extends Effect {

    static {
        Skript.registerEffect(EffSpellSeedDel.class, "(del[ete]|remove) spell [seed] %spell%");
    }

    private Expression<SpellSeed> spell;

    @Override
    protected void execute(Event event) {
        SpellSeed seed = spell.getSingle(event);
        if (seed != null) {
            SKSpell.getPlugin().getSSManager().removeSpellSeed(seed);
        }
    }

    @Override
    public String toString(Event event, boolean b) {
        return "delete spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            spell = (Expression<SpellSeed>) expressions[0];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
