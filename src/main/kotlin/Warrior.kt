interface Warrior {
var isKilled : Boolean
var isLive :Int
fun toAtack(warrior: Warrior)
fun getDamage(damageToAtack:Int)


fun getRandomName(zvanie: Int):String{
    val nameList = listOf<List<String>>(
        listOf("Alexandr Makedonskii", "Napoleon Bonapart", "Gannibal Barka","Yulii Cezar","Chingizkhan", "Ghukov"),
        listOf("Nemo","Grey","Jack Vorobei","Vrungel","America","Ochevidnost"))
    return if (zvanie>1) {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        (1..(5..10).random())
            .map { allowedChars.random() }
            .joinToString("")
    } else
        nameList[zvanie][(0..5).random()]
}
fun randomIntInList(){

}




/*fun getRandomName(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }*/
}