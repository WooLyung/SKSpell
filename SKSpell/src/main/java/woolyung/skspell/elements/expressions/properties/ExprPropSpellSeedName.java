package woolyung.skspell.elements.expressions.properties;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprPropSpellSeedName extends SimplePropertyExpression<SpellSeed, String> {

    static {
        SKSpell.registerPropExpr(ExprPropSpellSeedName.class, String.class, "name", "spell");
    }

    @Override
    protected String getPropertyName() {
        return "name of spell seed";
    }

    @Override
    public String convert(SpellSeed spellSeed) {
        if (spellSeed == null)
            return null;
        else
            return spellSeed.getName();
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET) {
            return CollectionUtils.array(String.class);
        }
        if (mode == Changer.ChangeMode.RESET) {
            return CollectionUtils.array();
        }
        return null;
    }

    @Override
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        switch (mode) {
            case SET:
                if (getExpr().getSingle(e) != null) {
                    getExpr().getSingle(e).setName((String) delta[0]);
                }
                break;
            case RESET:
                if (getExpr().getSingle(e) != null) {
                    getExpr().getSingle(e).setName(SpellSeed.getDefaultName());
                }
                break;
        }
    }
}
