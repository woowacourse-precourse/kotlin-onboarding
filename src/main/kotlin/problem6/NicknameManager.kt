package problem6

class NicknameManager(private val forms:List<List<String>>) {
    private val storage = NicknameStorage()
    private lateinit var nicknameSet:Set<String>
    private val reporter = mutableSetOf<String>()

    private fun createNicknameSet(nickname:String) {}

    private fun validateNicknameSet(email:String) {}

    private fun manage() {
        for((email, nickname) in forms) {
            createNicknameSet(nickname)
            validateNicknameSet(email)
        }
    }

    fun apply() {
        manage()
        storage.addToStorage(nicknameSet)
    }
}