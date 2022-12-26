class General : AbstractWarrior() {
    override val maxHealth: Int = 300

    override val evasion: Int = 30

    override val accuracy: Int = 50

    override val weapon: AbstractWeapon = Weapons.createAvtomatManyShot()

    override var nowHealth: Int = maxHealth

    override var isKilled=false
    override var isLive: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    override val name: String = getRandomName(0)  // допиливание
    override val title: String
        get() = "general"
    override var summDamage: Int = 0

}