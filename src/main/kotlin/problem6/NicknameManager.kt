package problem6

class NicknameManager(private val forms:List<List<String>>) {
    private val storage = NicknameStorage()
    private lateinit var nicknameSet:Set<String>
    private val reporter = mutableSetOf<String>()

    private fun manage() {}

    fun apply() {
        manage()
        storage.addToStorage(nicknameSet)
    }
}