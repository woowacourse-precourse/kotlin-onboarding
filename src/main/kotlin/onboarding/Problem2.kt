package onboarding

fun solution2(cryptogram: String): String {
    var index: Int
    var temp: String
    var result = cryptogram
    var convertNum = 1 // 중복 문자를 발견한 횟수

    while(convertNum > 0) {
        index = 0
        convertNum = 0
        temp = result
        result = ""

        while(index < temp.length) {
            if(index > 0 && temp[index] == temp[index-1]){
                index += 1
                convertNum += 1
                continue
            }

            if(index < temp.length-1 && temp[index] == temp[index+1]){
                index += 2
                convertNum += 1
                continue
            }
            result += temp[index]
            index += 1
        }
    }

    return result
}
