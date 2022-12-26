import FireType.ManyShot

abstract class AbstractWeapon
    (
    val maxQuanityCartridgesInMagazin: Int,
    val fireType: FireType,
) {
    var stack: Stack<Ammo> = Stack()

    var isEmpty: Boolean = true              //stack.isEmpty()

    abstract fun makeQuanity(): Ammo                           // создание патрона


    fun recharge()/*: Stack<Ammo>*/ {                              //  перезарядка
        var stackForRecharge: Stack<Ammo> = Stack()
//       if (isEmpty)
        var n: Int = 0
        while (n < maxQuanityCartridgesInMagazin) {
            n++
            stackForRecharge.push(makeQuanity())
        }
        stack = stackForRecharge

        //return stack
    }

    abstract fun getQuanity(): Stack<Ammo>                       // получение патронов для выстрела
    override fun toString(): String {
        return "AbstractWeapon(maxQuanityCartridgesInMagazin=$maxQuanityCartridgesInMagazin, fireType=$fireType, stack=$stack, isEmpty=$isEmpty)"
    }
}


