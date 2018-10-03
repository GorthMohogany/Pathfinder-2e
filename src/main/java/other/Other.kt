package other

import kotlin.math.absoluteValue

class Modifier(val name: Name, var value: Int = 0, var type: String?, var source: String?) {
    constructor(name: Name) : this(name, 0, null, null)
    constructor(name: Name, value: Int) : this(name, value, null, null)
    fun toStringWithSign(formulaStyle: Boolean = false): String {
        val spacing = if (formulaStyle) " " else ""
        val sign = if (value > 0) "+" else ""
        return "$sign$spacing$value"
    }
}

abstract class Totalable(vararg mods: Modifier) {

    var modifiers = mods
    var total = recalculate()

    fun recalculate(): Int {
        total = 0
        modifiers.forEach { mod -> total += mod.value }

        return total
    }

    open fun modify(modifierName: Name, newValue: Int) {
        modifiers.filter { mod -> mod.name == modifierName }
                .forEach { mod -> mod.value += newValue }

        total = recalculate()
    }

    fun toStringModifiers(): String {
        var str = ""

        for (i in modifiers.indices) {
            var mod = modifiers.get(i)
            if (i > 0 && mod.value != 0) {
                str += if (mod.value > 0) " + " else " - "
            }
            if (mod.value != 0) {
                str += "${mod.value.absoluteValue} (${mod.name.abbreviatedName})"
            }
        }

        return str
    }
}

enum class Name(var longName: String, var abbreviatedName: String = longName) {

    BASE("Base", "Base"),

    // modifiers
    AB_MOD("Ability Modifier", "Ability"),
    PROF_MOD("Profession Modifier", "Prof"),
    ANCESTRY_MOD("Ancestry Modifier", "Ancestry"),

    BOOST("Ability Boost", "Boost"),
    FLAW("Ability Flaw", "Flaw"),

    OTHER("Other modifier", "Other"),

    //ability score
    STRENGTH("Strength"),
    DEXTERITY("Dexterity","Dexterity"),
    CONSTITUTION("Constitution","Constitution"),
    INTELLIGENCE("Intelligence","Intelligence"),
    WISDOM("Wisdom","Wisdom"),
    CHARISMA("Charisma","Charisma"),

    // skills
    ACROBATICS("Acrobatics"),
    ARCANA("Arcana"),
    ATHLETICS("Athletics"),
    CRAFTING("Crafting"),
    DECEPTION("Deception"),
    DIPLOMACY("Diplomacy"),
    INTIMIDATION("Intimidation"),
    LORE("Lore"),
    MEDICINE("Medicine"),
    NATURE("Nature"),
    OCCULTISM("Occultism"),
    PERFORMANCE("Performance"),
    RELIGION("Religion"),
    SOCIETY("Society"),
    STEALTH("Stealth"),
    SURVIVAL("Survival"),
    THIEVERY("Thievery"),

    AC("Armor Class", "AC"),

    STR_MOD("Str Modifier", "Str"),
    DEX_MOD("Dex Modifier", "Dex"),
    CON_MOD("Con Modifier", "Con"),
    INT_MOD("Int Modifier", "Int"),
    WIS_MOD("Wis Modifier", "Wis"),
    CHA_MOD("Cha Modifier", "Cha"),

    ITEM_MOD("Item Modifier", "Item")
}