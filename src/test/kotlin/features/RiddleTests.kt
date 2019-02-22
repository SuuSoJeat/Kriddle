package features

import FakeRiddleRepositoryImpl
import core.entities.Riddle
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test
import java.util.*

class RiddleTests {

    @Test
    fun nothing() {

    }

    @Test
    fun `getAllRiddles_get 0 riddles`() = runBlocking<Unit> {
        val riddleRepository = FakeRiddleRepositoryImpl()
        riddleRepository.getAllRiddles().shouldBeEmpty()
    }

    @Test
    fun `getAllRiddles_get 1 riddles`() = runBlocking<Unit> {
        val riddleRepository = FakeRiddleRepositoryImpl()
        val riddle = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
        riddleRepository.save(riddle)
        riddleRepository.getAllRiddles().shouldContain(riddle)
    }

    @Test
    fun `getAllRiddles_get 3 riddles`() = runBlocking<Unit> {
        val riddleRepository = FakeRiddleRepositoryImpl()
        val riddle1 = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
        val riddle2 = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
        val riddle3 = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
        riddleRepository.save(riddle1)
        riddleRepository.save(riddle2)
        riddleRepository.save(riddle3)
        riddleRepository.getAllRiddles().shouldContain(riddle1)
        riddleRepository.getAllRiddles().shouldContain(riddle2)
        riddleRepository.getAllRiddles().shouldContain(riddle3)    }
}