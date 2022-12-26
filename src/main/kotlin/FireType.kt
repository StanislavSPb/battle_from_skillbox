sealed class FireType() {
    object OneShot : FireType()
    object ThreeShot : FireType()
    data class ManyShot(val quantityCartridges: Int) : FireType()


}
