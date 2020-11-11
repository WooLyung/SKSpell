package woolyung.skspell.elements.expressions.typeproperties;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSpellSeedLocGet extends SimpleExpression<Location> {

    static {
        Skript.registerExpression(ExprSpellSeedLocGet.class, Location.class, ExpressionType.COMBINED, "get loc[ation] property %string% in %spell%");
    }

    Expression<String> stringExpression;
    Expression<SpellSeed> spellSeedExpression;

    @Override
    protected Location[] get(Event event) {
        SpellSeed seed = spellSeedExpression.getSingle(event);

        if (seed == null) return null;

        Location[] locations = new Location[1];
        locations[0] = seed.getLocProps(stringExpression.getSingle(event));
        return locations;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Location> getReturnType() {
        return Location.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "get location property in spell seed";
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
