package woolyung.skspell.elements.expressions.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSpellSeedIntGet extends SimpleExpression<Integer> {

    static {
        Skript.registerExpression(ExprSpellSeedIntGet.class, Integer.class, ExpressionType.COMBINED, "get int[eger] property %string% in %spell%");
    }

    Expression<String> stringExpression;
    Expression<SpellSeed> spellSeedExpression;

    @Override
    protected Integer[] get(Event event) {
        SpellSeed seed = spellSeedExpression.getSingle(event);

        if (seed == null) return null;

        Integer[] integers = new Integer[1];
        integers[0] = seed.getIntProp(stringExpression.getSingle(event));
        return integers;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "get integer property in spell seed";
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
