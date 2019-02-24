package core

import core.functional.Either
import core.functional.Either.Right
import core.interactors.UseCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.Test

//class UseCaseTest {
//
//    private val TYPE_TEST = "Test"
//    private val TYPE_PARAM = "ParamTest"
//
//    private val useCase = MyUseCase()
//
//    @Test
//    fun `running use case should return 'Either' of use case type`() {
//        val params = MyParams(TYPE_PARAM)
//        val result = runBlocking { useCase.run(params) }
//
//        result shouldEqual Right(MyType(TYPE_TEST))
//    }
//
//    @Test
//    fun `should return correct data when executing use case`() {
//        var result: Either<Exception, MyType>? = null
//
//        val params = MyParams("TestParam")
//        val onResult = { myResult: Either<Exception, MyType> -> result = myResult }
//
//        runBlocking { useCase(params, onResult) }
//
//        result shouldEqual Right(MyType(TYPE_TEST))
//    }
//
//    data class MyType(val name: String)
//    data class MyParams(val name: String)
//
//    private inner class MyUseCase : UseCase<MyType, MyParams>() {
//        override suspend fun run(params: MyParams) = Right(MyType(TYPE_TEST))
//    }
//}