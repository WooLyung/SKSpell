package woolyung.skspell;

import ch.njol.skript.variables.Variables;
import woolyung.skspell.elements.types.SpellSeed;

import java.util.ArrayList;

public class SpellSeedManager {
    private ArrayList<SpellSeed> spellSeeds = new ArrayList<>();
    private ArrayList<SpellSeed> removes = new ArrayList<>();
    private ArrayList<SpellSeed> news = new ArrayList<>();

    public ArrayList<SpellSeed> getSpellSeeds() {
        return spellSeeds;
    }

    public SpellSeed createSpellSeed() {
        SpellSeed spellSeed = new SpellSeed();
        news.add(spellSeed);
        return spellSeed;
    }

    public void insertSpellSeed(SpellSeed spellSeed) {
        spellSeeds.add(spellSeed);
    }

    public void removeSpellSeed(SpellSeed spellSeed) {
        removes.add(spellSeed);
    }

    public void insertSpellSeeds() {
        for (SpellSeed spellSeed : news) {
            insertSpellSeed(spellSeed);
        }
        news.clear();
    }

    public void removeSpellSeeds() {
        for (SpellSeed spellSeed : removes) {
            spellSeeds.remove(spellSeed);
        }
        removes.clear();
    }
}