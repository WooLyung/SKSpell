package woolyung.skspell.elements.expressions.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;

public class ExprVectorSumLoc extends SimpleExpression<Location> {

    static {
        Skript.registerExpression(ExprVectorSumLoc.class, Location.class, ExpressionType.COMBINED, "vector %vector% added %location%");
    }

    Expression<Vector> vectorExpression;
    Expression<Location> locationExpression;

    @Override
    protected Location[] get(Event event) {
        Location loc = locationExpression.getSingle(event);
        Vector vec = vectorExpression.getSingle(event);

        Location[] locs = new Location[1];
        locs[0] = loc.clone().add(vec);

        return locs;
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
        return "vector plus location";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        try {
            vectorExpression = (Expression<Vector>) expressions[0];
            locationExpression = (Expression<Location>) expressions[1];
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
