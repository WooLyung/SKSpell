package woolyung.skspell.elements.expressions.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

import java.util.ArrayList;

public class ExprAllSpells extends SimpleExpression<SpellSeed> {

    static {
        Skript.registerExpression(ExprAllSpells.class, SpellSeed.class, ExpressionType.SIMPLE, "all (spells|spell seeds)");
    }

    @Override
    protected SpellSeed[] get(Event event) {
        ArrayList<SpellSeed> spells = SKSpell.getPlugin().getSSManager().getSpellSeeds();

        return spells.toArray(new SpellSeed[spells.size()]);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends SpellSeed> getReturnType() {
        return SpellSeed.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "get all spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}
