import core.entities.Riddle
import core.functional.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import core.repositories.RiddleRepository

class FakeRiddleRepositoryImpl : RiddleRepository {
    private val inMemoryDatabase = HashMap<String, Riddle>()
    override suspend fun save(riddle: Riddle): Either<Exception, Unit> {
        return try {
            withContext(Dispatchers.IO) {
                inMemoryDatabase[riddle.id] = riddle
                Either.Right(Unit)
            }
        } catch (e: Exception) {
            Either.Left(e)
        }
    }

    override fun delete(riddle: Riddle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun edit(riddle: Riddle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getAllRiddles(): List<Riddle> {
        return inMemoryDatabase.values.toList()
    }
}