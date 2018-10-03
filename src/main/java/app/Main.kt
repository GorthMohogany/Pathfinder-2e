package app

import character.CharacterName
import character.PF2eCharacter
import other.Name
import skills.Skills

fun main(ars: Array<String>) {
    var c = PF2eCharacter(CharacterName("Gorth", "Mohogany"))

    c.abilityScores.strength.modify(Name.ANCESTRY_MOD, 5)
    c.abilityScores.strength.modify(Name.BOOST, -2)
    c.abilityScores.dexterity.modify(Name.BASE, -2)
    outln(c.toString())
}

fun outln(obj: Any) {
    System.out.println(obj)
}

