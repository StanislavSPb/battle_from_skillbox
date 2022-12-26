sealed class BattleState {
    open fun battlePrint() {}

    object Progress : BattleState() {
    }
    object WinFirstTeam : BattleState() {
        override fun battlePrint() {
            println("Победила первая команда")
        }
    }
    object WinSecondTeam : BattleState() {
        override fun battlePrint() {
            println("Победила вторая команда")
        }
    }
}

