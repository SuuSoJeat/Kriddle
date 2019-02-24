package features

import core.entities.Riddle
import core.interactors.UseCase
import features.CreateANewRiddle.Params
import core.repositories.RiddleRepository

class CreateANewRiddle(private val riddleRepository: RiddleRepository) : UseCase<Unit, Params>(){
    override suspend fun run(params: Params) = riddleRepository.save(params.riddle)

    data class Params(val riddle: Riddle)
}