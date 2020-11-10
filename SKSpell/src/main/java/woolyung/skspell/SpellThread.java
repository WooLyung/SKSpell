package woolyung.skspell;

import org.bukkit.Bukkit;
import woolyung.skspell.elements.types.SpellSeed;
import woolyung.skspell.events.SpellUpdateEvent;

public class SpellThread extends Thread {
    private SKSpell plugin;

    @Override
    public void run() {
        plugin = SKSpell.getPlugin();

        while (plugin.isEnabled()) {
            try {
                Thread.sleep(50);
                Bukkit.getScheduler().runTask(plugin, () -> {
                    for (SpellSeed spellSeed : plugin.getSSManager().getSpellSeeds()) {
                        spellSeed.setTime(spellSeed.getTime() + 0.05);
                        SpellUpdateEvent event = new SpellUpdateEvent(spellSeed);
                        Bukkit.getPluginManager().callEvent(event);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}