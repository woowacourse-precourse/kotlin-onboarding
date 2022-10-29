package onboarding

fun solution2(cryptogram: String): String {

    val mutablecryptogram = cryptogram.chunked(1).toMutableList() // strinf을 list로 분해후 변경가능한 list로 설정

    while (true) { // 반복

        for (i in 0 until mutablecryptogram.size) { // 전체 순환 검색

            if (mutablecryptogram.get(i) == mutablecryptogram.get(i + 1)) { // 중복 발견 // if문에 {} 안하면 바로 아랫줄만 인식됨
                mutablecryptogram.removeAt(i + 1) // 삭제
                mutablecryptogram.removeAt(i) // 삭제

                if (mutablecryptogram.size == 0) { // 값이 다 사라졌을시 string으로 변경후 리턴
                    println(1111111111)
                    println(mutablecryptogram)
                    return mutablecryptogram.joinToString("") // ""값을 주면 공백없이 연결
                }

                break // for문 종료 다시 처음부터 반복
            }

            if (mutablecryptogram.size-2 == i) { // 검색후 미검출시 string으로 변경후 리턴
                return mutablecryptogram.joinToString("") // ""값을 주면 공백없이 연결
            }

        }
    }
}
