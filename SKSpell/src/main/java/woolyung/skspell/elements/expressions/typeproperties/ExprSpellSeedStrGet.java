package woolyung.skspell.elements.expressions.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSpellSeedStrGet extends SimpleExpression<String> {

    static {
        Skript.registerExpression(ExprSpellSeedStrGet.class, String.class, ExpressionType.COMBINED, "get str[ing] property %string% in %spell%");
    }

    Expression<String> stringExpression;
    Expression<SpellSeed> spellSeedExpression;

    @Override
    protected String[] get(Event event) {
        SpellSeed seed = spellSeedExpression.getSingle(event);

        if (seed == null) return null;

        String[] strings = new String[1];
        strings[0] = seed.getStrProp(stringExpression.getSingle(event));
        return strings;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "get string property in spell seed";
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
