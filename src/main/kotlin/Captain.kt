class Captain:AbstractWarrior () {
    override val maxHealth: Int = 250

    override val evasion: Int = 25

    override val accuracy: Int = 45

    override val weapon: AbstractWeapon = Weapons.createAvtomatThreeShot()

    override var nowHealth: Int = maxHealth

    override var isKilled = false

    override var isLive: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override val name: String = getRandomName(1)  // допиливание
    override val title: String
        get() = "capitan"
    override var summDamage: Int =0

}
