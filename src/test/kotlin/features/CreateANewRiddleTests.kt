package features

import FakeRiddleRepositoryImpl
import core.entities.Riddle
import features.CreateANewRiddle.Params
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
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
            createANewRiddle(Params(riddle))
            val allRiddles = riddleRepository.riddles()
            allRiddles shouldContain riddle
        }

    @Test
    fun `Create a new riddle_get exception`() =
        runBlocking<Unit>(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
            val riddle = Riddle(UUID.randomUUID().toString(), "question1", "answer1")
            val riddleRepository = FakeRiddleRepositoryImpl()
            val createANewRiddle = CreateANewRiddle(riddleRepository)
            createANewRiddle(Params(riddle)) { }
        }
}