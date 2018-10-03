package skills

import other.Modifier
import other.Name
import other.Totalable

class Skills(
        var acrobatics: Skill = Skill(Name.ACROBATICS),
        var arcana: Skill = Skill(Name.ARCANA),
        var athletics: Skill = Skill(Name.ATHLETICS),
        var crafting: Skill = Skill(Name.CRAFTING),
        var deception: Skill = Skill(Name.DECEPTION),
        var diplomacy: Skill = Skill(Name.DIPLOMACY),
        var intimidation: Skill = Skill(Name.INTIMIDATION),
        var lore: Skill = Skill(Name.LORE),
        var medicine: Skill = Skill(Name.MEDICINE),
        var nature: Skill = Skill(Name.NATURE),
        var occultism: Skill = Skill(Name.OCCULTISM),
        var performance: Skill = Skill(Name.PERFORMANCE),
        var religion: Skill = Skill(Name.RELIGION),
        var society: Skill = Skill(Name.SOCIETY),
        var stealth: Skill = Skill(Name.STEALTH),
        var survival: Skill = Skill(Name.SURVIVAL),
        var thievery: Skill = Skill(Name.THIEVERY)
) {
}

class Skill(
        var name: Name,
        abMod: Modifier = Modifier(Name.AB_MOD),
        profMod: Modifier = Modifier(Name.PROF_MOD)
) : Totalable(abMod, profMod) {

    override fun toString(): String {
        return name.longName + ": " + toStringModifiers() + " = $total"
    }
}