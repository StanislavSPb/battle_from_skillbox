class Soldier:AbstractWarrior() {
    override val maxHealth: Int = 200

    override val evasion: Int = 20
    override val accuracy: Int = 35
    override val weapon: AbstractWeapon = Weapons.createPistoletGold()
    override var nowHealth: Int = maxHealth
    override var isKilled: Boolean = false
    override var isLive: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    override val name: String = getRandomName(3)  // допиливание
    override val title: String = "soldier"
    override var summDamage: Int = 0
}