package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun exception7(user : String, friends: List<List<String>>, visitors: List<String>) {
    if(user.length < 1 || user.length > 30) {
        throw IllegalArgumentException("user는 길이가 1이상 30이하여야 합니다.")
    }

    if(friends.size < 1 || friends.size > 10000) {
        throw IllegalArgumentException("friends의 길이는 1이상 10000이하여야 합니다.")
    }

    if(visitors.size < 0 || visitors.size > 10000) {
        throw IllegalArgumentException("visitors의 길이는 0이상 10000이하여야 합니다.")
    }
}

fun exception_id(id : String) {

    if(id.length < 1 || id.length > 30) {
        throw IllegalArgumentException("아이디의 길이는 1이상 30이하여야 합니다.")
    }

    if(!id.matches("^[a-z]*S".toRegex())) {
        throw IllegalArgumentException("아이디는 소문자여야 합니다.")
    }
}