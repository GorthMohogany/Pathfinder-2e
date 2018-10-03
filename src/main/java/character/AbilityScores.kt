package character

import other.Modifier
import other.Name
import other.Totalable

class AbilityScores(
        var strength: AbilityScore = AbilityScore(Name.STRENGTH),
        var dexterity: AbilityScore = AbilityScore(Name.DEXTERITY),
        var constitution: AbilityScore = AbilityScore(Name.CONSTITUTION),
        var intelligence: AbilityScore = AbilityScore(Name.INTELLIGENCE),
        var wisdom: AbilityScore = AbilityScore(Name.WISDOM),
        var charisma: AbilityScore = AbilityScore(Name.CHARISMA)
) {
    init {
        strength = AbilityScore(Name.STRENGTH)
        dexterity = AbilityScore(Name.DEXTERITY)
        constitution = AbilityScore(Name.CONSTITUTION)
        intelligence = AbilityScore(Name.INTELLIGENCE)
        wisdom = AbilityScore(Name.WISDOM)
        charisma = AbilityScore(Name.CHARISMA)
    }

    fun getAbilityScores(): Array<AbilityScore> {
        return arrayOf(strength, dexterity, constitution, intelligence, wisdom, charisma)
    }
}

class AbilityScore(
        var name: Name,
        var abMod: Modifier = Modifier(Name.AB_MOD),
        base: Modifier = Modifier(Name.BASE, 10),
        ancestryMod: Modifier = Modifier(Name.ANCESTRY_MOD),
        boost: Modifier = Modifier(Name.BOOST),
        flaw: Modifier = Modifier(Name.FLAW),
        other: Modifier = Modifier(Name.OTHER)
) : Totalable(base, ancestryMod, boost, flaw, other) {

    init {
        this.calculateModifier()
    }

    private fun calculateModifier() {
        abMod.value = (total - 10) / 2
    }

    override fun modify(modifierName: Name, newValue: Int) {
        super.modify(modifierName, newValue)
        calculateModifier()
    }

}