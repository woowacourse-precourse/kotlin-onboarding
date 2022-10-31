package problem6

class NicknameStorage {
    private val storage = mutableSetOf<String>()

    fun addToStorage(set:Set<String>) {
        storage.addAll(set)
    }
}