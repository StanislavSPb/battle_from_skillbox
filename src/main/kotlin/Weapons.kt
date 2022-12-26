import java.util.*
import kotlin.random.Random

object Weapons {
    val stackForGetQuanity: Stack<Ammo> = Stack()
    fun createPistoletGold() = object : AbstractWeapon(30, FireType.OneShot) {
        override fun makeQuanity(): Ammo {
            return Ammo.GOLD
        }

        override fun getQuanity(): Stack<Ammo> {
            stack.pop()?.let { stackForGetQuanity.push(it) }
            return stackForGetQuanity
        }
    }

    fun createPistolBronze() = object : AbstractWeapon(50, FireType.OneShot) {
        override fun makeQuanity(): Ammo {
            return Ammo.BRONZE
        }

        override fun getQuanity(): Stack<Ammo> {
            stack.pop()?.let { stackForGetQuanity.push(it) }
            return stackForGetQuanity
        }
    }

    fun createAvtomatManyShot() = object : AbstractWeapon(100, FireType.ManyShot(Random.nextInt(10, 15))) {
        override fun makeQuanity(): Ammo {
            return Ammo.BRONZE
        }

        override fun getQuanity(): Stack<Ammo> {
            var xxx = 0
            while (xxx < (fireType as FireType.ManyShot).quantityCartridges /*вместо 10 вставить qunityCartridges*/) {
                xxx++
                stack.pop()?.let { stackForGetQuanity.push(it) }
            }
            return stackForGetQuanity
        }
    }

    fun createAvtomatThreeShot() = object : AbstractWeapon(33, FireType.ThreeShot) {
        override fun makeQuanity(): Ammo {
            return Ammo.SILVER
        }

        override fun getQuanity(): Stack<Ammo> {
            var xxx = 0
            while (xxx < 3) {
                xxx++
                stack.pop()?.let { stackForGetQuanity.push(it) }
            }
            return stackForGetQuanity
        }
    }
}




