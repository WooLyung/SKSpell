package woolyung.skspell;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.ExpressionType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class SKSpell extends JavaPlugin {

    private static SKSpell plugin;
    private SkriptAddon addon;

    @Override
    public void onEnable() {
        plugin = this;
        addon = Skript.registerAddon(this);

        try {
            addon.loadClasses("woolyung.skspell", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }

        getServer().getLogger().info("SKSpell 1.0.0 has been enabled.");
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("SKSpell 1.0.0 has been disabled.");
    }

    public static SKSpell getPlugin() {
        return plugin;
    }

    public SkriptAddon getAddon() {
        return addon;
    }

    public static void registerPropExpr(final Class<? extends SimplePropertyExpression> exprClass,
                                        Class<?> returnClass, final String property, final String type) {
        String[] propPatterns = {
                "[the] " + property + " of %" + type + "%",
                "%" + type + "%'[s] " + property
        };
        Skript.registerExpression(exprClass, returnClass, ExpressionType.PROPERTY, propPatterns);
    }
}
