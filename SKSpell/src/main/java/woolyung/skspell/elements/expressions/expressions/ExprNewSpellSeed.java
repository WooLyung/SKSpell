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

public class ExprNewSpellSeed extends SimpleExpression<SpellSeed> {

    static {
        Skript.registerExpression(ExprNewSpellSeed.class, SpellSeed.class, ExpressionType.COMBINED, "(new|create|summon) spell [seed]");
    }

    @Override
    protected SpellSeed[] get(Event event) {
        SpellSeed[] seed = new SpellSeed[1];
        seed[0] = SKSpell.getPlugin().getSSManager().createSpellSeed();

        return seed;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends SpellSeed> getReturnType() {
        return SpellSeed.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "delete spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }
}
