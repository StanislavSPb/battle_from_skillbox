import kotlin.random.Random

abstract class AbstractWarrior() : Warrior {
    abstract val maxHealth: Int     // макс здоровье
    abstract val evasion: Int       // уклонение
    abstract val accuracy: Int      //точность
    abstract val weapon: AbstractWeapon
    abstract var nowHealth: Int    // текущее здоровье
    abstract val name : String // допиливание : случаное имя
    abstract val title : String  // допиливание звание
    abstract var summDamage : Int // допиливание суммарный урон
    override fun toAtack(warrior: Warrior){
        var damageToAtack: Int = 0
        if (weapon.isEmpty) {                                                 // если пустой магазин то перезаряжаем
            weapon.recharge()
            weapon.isEmpty = false
            print("Перезарядка")
        } else {
            val stackToAtack = weapon.getQuanity()                           // создали новую обойму
            while (!stackToAtack.isEmpty()) {                                // пока обойма НЕ пуста...
                if (hitChance(warrior)) {                                      // если шанс попадания выпал то ...
                    print("...Попадание ")
                    damageToAtack += weapon.makeQuanity().nowDamage()             // суммирую дамаг от пули
                    stackToAtack.pop()
                }                                                              // вычел пулю после выстрела из обоймы
                else {
                    stackToAtack.pop()                                             // или просто вычитаю пулю
                    print("...Уклонился ")
                }
            }
        }
        warrior as AbstractWarrior
        warrior.getDamage(damageToAtack)
        println(" ... Суммарный урон составил $damageToAtack")
        summDamage += damageToAtack  // дамаг суммируем в копилку послебоевую
        if (warrior.nowHealth<=0) {
            warrior.isKilled=true
            println("Убит")
        }
    }
    override fun getDamage(damageToAtack: Int) {                                     // вычитаем дамаг у противника
        nowHealth -= damageToAtack
    }
    private fun hitChance(warrior: Warrior): Boolean {                                       // шанс попадания
        warrior as AbstractWarrior
        return Random.nextInt(0, accuracy) > Random.nextInt(0, warrior.evasion)

    }


}
