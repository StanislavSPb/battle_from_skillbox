class Novobranec : AbstractWarrior(){
    override val maxHealth: Int = 100
    override val evasion: Int = 10
    override val accuracy: Int =20
    override val weapon: AbstractWeapon = Weapons.createPistolBronze()
    override var nowHealth: Int = maxHealth

    override var isKilled: Boolean = false
    override var isLive: Int
        get() = TODO("Not yet implemented")
        set(value) {}
    override val name: String = getRandomName(3) // допиливание
    override val title: String = "novobranec"
    override var summDamage: Int = 0
}