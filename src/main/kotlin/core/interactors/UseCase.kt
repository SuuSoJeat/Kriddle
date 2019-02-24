package core.interactors

abstract class UseCase<out Type, in Params> where Type : Any {
    abstract suspend fun run(params: Params): Type

    suspend operator fun invoke(params: Params, onResult: (Type) -> Unit = {}) {
        onResult(run(params))
    }
}