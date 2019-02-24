package features

import core.entities.Riddle
import core.interactors.UseCase
import features.CreateRiddle.Params
import core.repositories.RiddleRepository

class CreateRiddle(private val riddleRepository: RiddleRepository) : UseCase<Unit, Params>(){
    override suspend fun run(params: Params) = riddleRepository.save(params.riddle)

    data class Params(val riddle: Riddle)
}