package woolyung.skspell.elements.expressions.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSpellSeedVecGet extends SimpleExpression<Vector> {

    static {
        Skript.registerExpression(ExprSpellSeedVecGet.class, Vector.class, ExpressionType.COMBINED, "get vec[tor] property %string% in %spell%");
    }

    Expression<String> stringExpression;
    Expression<SpellSeed> spellSeedExpression;

    @Override
    protected Vector[] get(Event event) {
        SpellSeed seed = spellSeedExpression.getSingle(event);

        if (seed == null) return null;

        Vector[] vectors = new Vector[1];
        vectors[0] = seed.getVecProp(stringExpression.getSingle(event));
        return vectors;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Vector> getReturnType() {
        return Vector.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "get vector property in spell seed";
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
