package woolyung.skspell.elements.expressions.setters;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprSetSpellSeedName extends SimpleExpression<SpellSeed> {

    static {
        Skript.registerExpression(ExprSetSpellSeedName.class, SpellSeed.class, ExpressionType.COMBINED, "%spell% named %string%");
    }

    private Expression<String> stringExpression;
    private Expression<SpellSeed> spellSeedExpression;

    @Override
    protected SpellSeed[] get(Event event) {
        SpellSeed[] seed = new SpellSeed[1];
        seed[0] = spellSeedExpression.getSingle(event);
        seed[0].setName(stringExpression.getSingle(event));

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
        return "set spell seed name";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            spellSeedExpression = (Expression<SpellSeed>) expressions[0];
            stringExpression = (Expression<String>) expressions[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
