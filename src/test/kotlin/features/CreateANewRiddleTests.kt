package features

import FakeRiddleRepositoryImpl
import core.entities.Riddle
import features.CreateANewRiddle.Params
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

class CreateANewRiddleTests {
    @Test
    fun nothing() {
    }

    @Test
    fun `Create a new riddle_get a new riddle`() =
        runBlocking<Unit>(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
            val riddle = Riddle(UUID.randomUUID().toString(), "question1", "answer1")
            val riddleRepository = FakeRiddleRepositoryImpl()
            val createANewRiddle = CreateANewRiddle(riddleRepository)
            createANewRiddle(Params(riddle)) { it.either({}, {}) }
            val allRiddles = riddleRepository.getAllRiddles()
            allRiddles.size `should be equal to` 1
            allRiddles shouldContain riddle
        }
}