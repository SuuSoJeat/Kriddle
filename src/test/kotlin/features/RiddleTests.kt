package features

import FakeRiddleRepositoryImpl
import core.entities.Riddle
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be`
import org.amshove.kluent.shouldBeEmpty
import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.Executors

class RiddleTests {

    @Test
    fun nothing() {

    }

    @Test
    fun `deleteAllRiddle _ 0 riddles`() = runBlocking<Unit> {
        val riddleRepository = FakeRiddleRepositoryImpl()
        riddleRepository.deleteAll()
        riddleRepository.riddles().shouldBeEmpty()
    }

    @Test
    fun `getAllRiddles_get 1 riddles`() = runBlocking<Unit> {
        val riddleRepository = FakeRiddleRepositoryImpl()
        val riddle = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
        riddleRepository.save(riddle)
        riddleRepository.riddles().shouldContain(riddle)
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
        riddleRepository.riddles().shouldContain(riddle1)
        riddleRepository.riddles().shouldContain(riddle2)
        riddleRepository.riddles().shouldContain(riddle3)
    }

    @Test
    fun `get Riddle By Id_get riddle`() =
        runBlocking<Unit>(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
            val riddleRepository = FakeRiddleRepositoryImpl()
            val riddle1 = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
            riddleRepository.save(riddle1)
            riddleRepository.findById(riddle1.id) `should be` riddle1
        }

    @Test
    fun `get Riddle By Id_get not exist exception`() =
        runBlocking<Unit>(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
            val riddleRepository = FakeRiddleRepositoryImpl()
            val riddle1 = Riddle(UUID.randomUUID().mostSignificantBits.toString(), "question1", "answer1")
            Assertions.assertThrows(Exception::class.java) { runBlocking { riddleRepository.findById(riddle1.id) } }
        }
}