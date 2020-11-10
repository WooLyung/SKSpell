package woolyung.skspell.elements.expressions.properties;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import woolyung.skspell.SKSpell;
import woolyung.skspell.elements.types.SpellSeed;

import java.security.acl.Owner;

public class ExprPropSpellSeedOwner extends SimplePropertyExpression<SpellSeed, Entity> {

    static {
        SKSpell.registerPropExpr(ExprPropSpellSeedOwner.class, Entity.class, "owner", "spell");
    }

    @Override
    protected String getPropertyName() {
        return "owner of spell seed";
    }

    @Override
    public Entity convert(SpellSeed spellSeed) {
        if (spellSeed == null)
            return null;
        else
            return spellSeed.getOwner();
    }

    @Override
    public Class<? extends Entity> getReturnType() {
        return Entity.class;
    }

    @Override
    public Class<?>[] acceptChange(Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.SET) {
            return CollectionUtils.array(Entity.class);
        }
        return null;
    }

    @Override
    public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
        switch (mode) {
            case SET:
                if (getExpr().getSingle(e) != null) {
                    getExpr().getSingle(e).setOwner((Entity) delta[0]);
                }
                break;
        }
    }
}
