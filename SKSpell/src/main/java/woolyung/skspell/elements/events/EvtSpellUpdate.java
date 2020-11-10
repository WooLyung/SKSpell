package woolyung.skspell.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import org.bukkit.event.Event;
import woolyung.skspell.elements.types.SpellSeed;
import woolyung.skspell.events.SpellUpdateEvent;

public class EvtSpellUpdate extends SkriptEvent {

    static {
        Skript.registerEvent("Spell Update", EvtSpellUpdate.class, SpellUpdateEvent.class, "[on] spell [seed] updat(e|ing) [event]");
        EventValues.registerEventValue(SpellUpdateEvent.class, SpellSeed.class, new Getter<SpellSeed, SpellUpdateEvent>() {
            @Override
            public SpellSeed get(SpellUpdateEvent spellUpdateEvent) {
                return spellUpdateEvent.getSpellSeed();
            }
        }, 0);
    }

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        return event instanceof SpellUpdateEvent;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "spell update event";
    }
}