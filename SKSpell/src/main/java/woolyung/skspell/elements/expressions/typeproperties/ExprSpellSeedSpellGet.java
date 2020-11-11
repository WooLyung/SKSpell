package woolyung.skspell.elements.expressions.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSpellSeedSpellGet extends SimpleExpression<SpellSeed> {

    static {
        Skript.registerExpression(ExprSpellSeedSpellGet.class, SpellSeed.class, ExpressionType.COMBINED, "get spell [seed] property %string% in %spell%");
    }

    Expression<String> stringExpression;
    Expression<SpellSeed> spellSeedExpression;

    @Override
    protected SpellSeed[] get(Event event) {
        SpellSeed seed = spellSeedExpression.getSingle(event);

        if (seed == null) return null;

        SpellSeed[] spells = new SpellSeed[1];
        spells[0] = seed.getSpellProps(stringExpression.getSingle(event));
        return spells;
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
        return "get spell seed property in spell seed";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            stringExpression = (Expression<String>) expressions[0];
            spellSeedExpression = (Expression<SpellSeed>) expressions[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
