package problem6

class ListSorter(private val form:List<String>) {
    fun sortByEmailNicknameOrder() : List<String> {
        if(form[0].contains("@")) {
            return form
        }
        return form.reversed()
    }
}