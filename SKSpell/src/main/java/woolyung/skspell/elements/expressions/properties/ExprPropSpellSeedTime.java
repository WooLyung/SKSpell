package woolyung.skspell.elements.expressions.properties;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

public class ExprPropSpellSeedTime extends SimplePropertyExpression<SpellSeed, Double> {

    static {
        SKSpell.registerPropExpr(ExprPropSpellSeedTime.class, Double.class, "time", "spell");
    }

    @Override
    protected String getPropertyName() {
        return "time of spell seed";
    }

    @Override
    public Double convert(SpellSeed spellSeed) {
        if (spellSeed == null)
            return null;
        else
            return spellSeed.getTime();
    }

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @Override
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        return null;
    }
}
