package repositories

import entities.Riddle
import functional.Either

interface RiddleRepository {
    suspend fun save(riddle: Riddle): Either<Exception, Unit>
    fun delete(riddle: Riddle)
    fun edit(riddle: Riddle)
    fun getById(id: String)
    suspend fun getAllRiddles(): List<Riddle>
}