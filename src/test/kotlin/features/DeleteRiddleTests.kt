package features

import org.junit.jupiter.api.Test
import FakeRiddleRepositoryImpl
import core.entities.Riddle
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldNotContain
import java.util.*

class DeleteRiddleTests {
    @Test
    fun nothing() {}

    @Test
    fun `delete riddle _ riddle deleted`() = runBlocking<Unit>{
        val riddleRepository = FakeRiddleRepositoryImpl()
        val riddle = Riddle(UUID.randomUUID().toString(), "question1", "answer1")
        riddleRepository.save(riddle)
        riddleRepository.delete(riddle)
        riddleRepository.riddles() shouldNotContain riddle
    }
}