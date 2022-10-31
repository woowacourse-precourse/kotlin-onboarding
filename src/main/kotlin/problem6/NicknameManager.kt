package problem6

class NicknameManager(private val forms:List<List<String>>) {
    private val storage = NicknameStorage()
    private lateinit var nicknameSet:MutableSet<String>
    private val reporter = mutableSetOf<String>()

    private fun createNicknameSet(nickname:String) {
        nicknameSet = mutableSetOf()

        for(i in 0 until (nickname.length - 1)) {
            val nicknameElement = nickname.substring(i, i + 1)
            nicknameSet.add(nicknameElement)
        }
    }

    private fun addEmailToReporter(email:String) {
        reporter.add(email)
    }

    private fun validateNicknameSet(email:String) {
        val intersection = storage.getIntersection(nicknameSet)

        if(intersection.isNotEmpty()) {
            addEmailToReporter(email)
        }
    }

    private fun manage() {
        for((email, nickname) in forms) {
            createNicknameSet(nickname)
            validateNicknameSet(email)
        }
    }

    private fun getManipulatedReporter(reporterList:List<String>) : List<String> {
        return reporterList.sorted()
    }

    fun apply() {
        manage()
        storage.addToStorage(nicknameSet)
    }

    fun getReporterAsList() : List<String> {
        val reporterList = reporter.toList()
        return getManipulatedReporter(reporterList)
    }
}