import kotlin.random.Random

class Battle {
    var team1 = Team().createTeam()
    var team2 = Team().createTeam()
    var battleIsEnd: Boolean = false
    var bs: BattleState = getBattleState()
    fun getBattleState(): BattleState {
        if (team1.isNotEmpty() && team2.isNotEmpty()) {
            println("Идут бои : бойцы в первой команде - ${team1.size}, бойцы во второй команде - ${team2.size}")
            return BattleState.Progress
        } else if (team2.isEmpty()) {
            return BattleState.WinFirstTeam
        } else return BattleState.WinSecondTeam
    }

    var aw: AbstractWarrior = Novobranec()  // новобранца кладем только для инициализации
    var teamWin = team1
    fun battleResults() {          // печатаем результаты победившей команды
        println("-------------------")
        println("Статистика победившей команды")
        if (team1.isEmpty()) {
            teamWin = team2
        }
        teamWin.sortedWith(compareBy{ (it as AbstractWarrior).summDamage })
        for (i in teamWin) {
            aw = i as AbstractWarrior

            print("${i.title} ${i.name} ${i.summDamage} ,")
        }
    }

    private fun warriorToAtackBattle(team: List<Warrior>): Int {
        var randomWarrior = Random.nextInt(0, team.size)
        print(" ${(team[randomWarrior] as AbstractWarrior).title} ${(team[randomWarrior] as AbstractWarrior).name} атакует")
        return randomWarrior
    }

    private fun warriorToDefBattle(team: List<Warrior>): Int {
        var randomWarrior = Random.nextInt(0, team.size)
        println(" ${(team[randomWarrior] as AbstractWarrior).title} ${(team[randomWarrior] as AbstractWarrior).name} с ${(team[randomWarrior] as AbstractWarrior).nowHealth} здоровья")
        return randomWarrior
    }

    var n = 1
    fun battle2() {
        do {
            println()
            println("Ход - $n")
            if (Random.nextBoolean()) {
                println("Атакует команда 1")
                team1[warriorToAtackBattle(team1)].toAtack(team2[warriorToDefBattle(team2)])
                team2 = team2.filter { !it.isKilled }


            } else {
                println("Атакует команда 2")
                team2[warriorToAtackBattle(team2)].toAtack(team1[warriorToDefBattle(team1)])
                team1 = team1.filter { !it.isKilled }
            }
            n++
        } while (getBattleState() is BattleState.Progress)
        if (getBattleState() is BattleState.WinFirstTeam) BattleState.WinFirstTeam.battlePrint()
        else BattleState.WinSecondTeam.battlePrint()
    }

}


