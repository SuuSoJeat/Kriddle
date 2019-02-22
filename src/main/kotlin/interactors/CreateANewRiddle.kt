package interactors

import entities.Riddle
import interactors.CreateANewRiddle.Params
import repositories.RiddleRepository

class CreateANewRiddle(private val riddleRepository: RiddleRepository) : UseCase<Unit, Params>() {
    override suspend fun run(params: Params) = riddleRepository.save(params.riddle)

    data class Params(val riddle: Riddle)
}