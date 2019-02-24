package features

import core.entities.Riddle
import core.interactors.UseCase
import core.repositories.RiddleRepository
import features.DeleteRiddle.Params

class DeleteRiddle(private val riddleRepository: RiddleRepository) : UseCase<Unit, Params>() {
    override suspend fun run(params: Params) = riddleRepository.delete(params.riddle)

    data class Params(val riddle: Riddle)
}