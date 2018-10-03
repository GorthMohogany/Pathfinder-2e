package character

import other.*
import skills.Skills
import java.lang.StringBuilder

class PF2eCharacter(
        var name: CharacterName = CharacterName(),
        var ancestry: Ancestry?,
        var size: Size?,
        var alignment: Alignment?,
        var languages: Array<Language>?,
        var abilityScores: AbilityScores = AbilityScores(),
        var speed: Array<Speed>?,
        var ac: ArmorClass?,
        var saves: Array<SavingThrow>?,
        var skills: Skills = Skills()
) {
    constructor() : this(CharacterName(), null, null, null, null, AbilityScores(), null, null, null, Skills())
    constructor(name: CharacterName) : this(name, null, null, null, null, AbilityScores(), null, null, null, Skills())

    init {
    }

    override fun toString(): String {
        val builder = StringBuilder()

        builder.appendln("Name: ${name!!.fullName()}")
        builder.appendln("Ability Scores:")

        abilityScores!!.getAbilityScores().forEach { score ->
            var str = " ${score.name.longName}: ${score.total} (${score.abMod.toStringWithSign()})"
            if (!score.toStringModifiers().isEmpty()) {
                str += (" = ${score.toStringModifiers()}")
            }
            builder.appendln(str)
        }

        return builder.toString()
    }
}


class SavingThrow {}

// todo remove otherModifier. Instead ad a method to add a

class ArmorClass(
        var name: Name = Name.AC,
        var dexMod: Modifier = Modifier(Name.DEX_MOD, 0),
        var profMod: Modifier = Modifier(Name.PROF_MOD, 0),
        var itemMod: Modifier = Modifier(Name.ITEM_MOD, 0),
        other: Modifier = Modifier(Name.OTHER)
        ) : Totalable(dexMod, profMod, itemMod, other) {

}

class CharacterName(val first: String= "", val last: String = "", val middle: String = "") {
    constructor(first: String, last: String) : this(first, last, "")

    fun fullName(): String {
        return ("$first${if (!middle.isEmpty() ) " " else ""}$middle${if (!last.isEmpty() ) " " else ""}$last")
    }
}
class Speed {}
class Ancestry {}
class Size {}
class Alignment {}
class Language {}
