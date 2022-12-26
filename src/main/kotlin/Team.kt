import kotlin.random.Random

class Team {
    fun createTeam(): List<Warrior> {
        var team = mutableListOf<Warrior>()

        for (i in 1..10) {
            when (Random.nextInt(0, 120)) {
                in (0..10) -> team.add(General())
                in (11..30) -> team.add(Captain())
                in (31..70) -> team.add(Soldier())
                in (71..120) -> team.add(Novobranec())
            }
        }


        return team
    }


}