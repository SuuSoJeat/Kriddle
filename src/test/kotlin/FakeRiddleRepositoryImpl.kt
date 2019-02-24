import core.entities.Riddle
import core.repositories.RiddleRepository
import java.util.*

class FakeRiddleRepositoryImpl : RiddleRepository {
    private val inMemoryDatabase = HashMap<String, Riddle>()

    init {
        for (i in 0..4) {
            val riddle = Riddle(UUID.randomUUID().toString(), "question$i", "answer$i")
            inMemoryDatabase[riddle.id] = riddle
        }
    }

    override suspend fun save(riddle: Riddle) {
        inMemoryDatabase[riddle.id] = riddle
    }

    override suspend fun delete(riddle: Riddle) {
        inMemoryDatabase.remove(riddle.id)
    }

    override suspend fun deleteAll() {
        inMemoryDatabase.clear()
    }

    override suspend fun update(riddle: Riddle) {
        inMemoryDatabase[riddle.id] = riddle
    }

    override suspend fun findById(id: String): Riddle {
        return inMemoryDatabase[id] ?: throw Exception("Riddle by id $id is not exist.")
    }

    override suspend fun riddles(): List<Riddle> {
        return inMemoryDatabase.values.toList()
    }
}