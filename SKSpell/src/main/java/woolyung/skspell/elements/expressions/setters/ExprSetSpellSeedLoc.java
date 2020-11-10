package woolyung.skspell.elements.expressions.setters;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSetSpellSeedLoc extends SimpleExpression<SpellSeed> {

    static {
        Skript.registerExpression(ExprSetSpellSeedLoc.class, SpellSeed.class, ExpressionType.COMBINED, "%spell% in %location%");
    }

    private Expression<Location> locationExpression;
    private Expression<SpellSeed> spellSeedExpression;

    @Override
    protected SpellSeed[] get(Event event) {
        SpellSeed[] seed = new SpellSeed[1];
        seed[0] = spellSeedExpression.getSingle(event);
        seed[0].setLocation(locationExpression.getSingle(event));

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
        return "set spell seed location";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            spellSeedExpression = (Expression<SpellSeed>) expressions[0];
            locationExpression = (Expression<Location>) expressions[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
