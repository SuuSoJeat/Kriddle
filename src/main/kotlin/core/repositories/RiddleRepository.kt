package core.repositories

import core.entities.Riddle
import core.functional.Either

interface RiddleRepository {
    suspend fun save(riddle: Riddle): Either<Exception, Unit>
    fun delete(riddle: Riddle)
    fun edit(riddle: Riddle)
    fun getById(id: String)
    suspend fun getAllRiddles(): List<Riddle>
}