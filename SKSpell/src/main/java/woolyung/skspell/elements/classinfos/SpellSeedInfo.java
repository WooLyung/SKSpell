package woolyung.skspell.elements.classinfos;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.classes.Serializer;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.lang.parser.ParserInstance;
import ch.njol.skript.registrations.Classes;
import ch.njol.yggdrasil.Fields;
import woolyung.skspell.elements.types.SpellSeed;

import java.io.NotSerializableException;
import java.io.StreamCorruptedException;

public class SpellSeedInfo {
    static {
        Classes.registerClass(new ClassInfo<>(SpellSeed.class, "spell")
        .user("spell?")
        .name("Spell")
        .defaultExpression(new EventValueExpression<>(SpellSeed.class))
        .parser(new Parser<SpellSeed>() {
            @Override
            public SpellSeed parse(String s, ParseContext context, ParserInstance pi) {
                return null;
            }

            @Override
            public SpellSeed parse(String s, ParseContext context) {
                return  null;
            }

            @Override
            public boolean canParse(ParseContext context) {
                return false;
            }

            @Override
            public String toCommandString(SpellSeed o) {
                return super.toCommandString(o);
            }

            @Override
            public String getDebugMessage(SpellSeed o) {
                return super.getDebugMessage(o);
            }

            @Override
            public String toString(SpellSeed seed, int i) {
                return toVariableNameString(seed);
            }

            @Override
            public String toVariableNameString(SpellSeed seed) {
                return seed.getString();
            }

            @Override
            public String getVariableNamePattern() {
                return ".+";
            }
        }).serializer(new Serializer<SpellSeed>() {
            @Override
            public Fields serialize(SpellSeed spellSeed) throws NotSerializableException {
                return null;
            }

            @Override
            public void deserialize(SpellSeed spellSeed, Fields fields) throws StreamCorruptedException, NotSerializableException {
                assert false;
            }

            @Override
            public boolean mustSyncDeserialization() {
                return false;
            }

            @Override
            protected boolean canBeInstantiated() {
                return false;
            }
        }));
    }
}
