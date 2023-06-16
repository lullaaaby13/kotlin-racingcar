package study.racinggame.domain

class Winners private constructor(private val winnersOfGame: List<Participant>) {

    fun names(): List<String> {
        return winnersOfGame.map { it.name }
    }

    companion object {
        fun of(racingGameStage: RacingGameStage): Winners {
            val frontRunners = racingGameStage.frontRunners().map { it.participant }
            return Winners(frontRunners)
        }
    }
}
