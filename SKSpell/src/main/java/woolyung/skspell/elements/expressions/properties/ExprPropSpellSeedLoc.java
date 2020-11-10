package woolyung.skspell.elements.expressions.properties;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.Location;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprPropSpellSeedLoc extends SimplePropertyExpression<SpellSeed, Location> {

    static {
        SKSpell.registerPropExpr(ExprPropSpellSeedLoc.class, Location.class, "location", "spell");
    }

    @Override
    protected String getPropertyName() {
        return "location of spell seed";
    }

    @Override
    public Location convert(SpellSeed spellSeed) {
        if (spellSeed == null)
            return null;
        else
            return spellSeed.getLocation();
    }

    @Override
    public Class<? extends Location> getReturnType() {
        return Location.class;
    }

    @Override
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET) {
            return CollectionUtils.array(Location.class);
        }
        return null;
    }

    @Override
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        switch (mode) {
            case SET:
                if (getExpr().getSingle(e) != null) {
                    getExpr().getSingle(e).setLocation((Location) delta[0]);
                }
                break;
        }
    }
}
