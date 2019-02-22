package core.interactors

import core.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {
    abstract suspend fun run(params: Params): Either<Exception, Type>

    suspend operator fun invoke(params: Params, onResult: (Either<Exception, Type>) -> Unit = {}) {
        onResult(run(params))
    }
}