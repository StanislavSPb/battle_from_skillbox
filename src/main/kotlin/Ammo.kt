import kotlin.random.Random

enum class Ammo(private val damage: Int, private val chanceCrit: Int, private val ratioCrit: Int) {
    GOLD(40, 50, 4),
    SILVER(30, 40, 3),
    BRONZE(20, 30, 2);
    fun nowDamage(): Int {
        var uron: Int = 0
        if (isCrit(chanceCrit)) {
            uron = damage * ratioCrit
            print("- критический урон составил $uron")
            return uron
        } else uron=damage
            print("- урон составил $damage")
        return uron
    }

    fun Ammo.isCrit(chanceCrit: Int): Boolean {
        return Random.nextInt(0, 100) <= chanceCrit
    }
}