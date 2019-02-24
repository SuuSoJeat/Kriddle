package core.repositories

import core.entities.Riddle
import core.functional.Either

interface RiddleRepository {
    suspend fun save(riddle: Riddle)
    suspend fun delete(riddle: Riddle)
    suspend fun deleteAll()
    suspend fun update(riddle: Riddle)
    suspend fun findById(id: String): Riddle
    suspend fun riddles(): List<Riddle>
}