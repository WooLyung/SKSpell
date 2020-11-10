package woolyung.skspell.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import woolyung.skspell.elements.types.SpellSeed;

public class SpellUpdateEvent extends Event {

    private SpellSeed spellSeed;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public SpellUpdateEvent(SpellSeed spellSeed){
        this.spellSeed = spellSeed;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public SpellSeed getSpellSeed() {
        return spellSeed;
    }

    public void setSpellSeed(SpellSeed spellSeed) {
        this.spellSeed = spellSeed;
    }
}