package onboarding

fun solution2(cryptogram: String): String {

    var answer = cryptogram
    var tempCryptogram = cryptogram
    var check = 0       //앞의 문자가 중복됐었는지를 체크해주는 변수
    var count =1        //중복된 문자가 있다면 다시 while문이 돌아가야 하므로 이를 체크해 줄 변수
    var last = 1        //마지막 문자도 입력해줘야 하므로 이를 체크해줄 변수

    while(count != 0){      //count 가 0이라는 말은 중복된 문자가 없는 상태이다
        tempCryptogram = answer     //for 문에 answer 문자열을 넣어줄 것이다
        answer = ""     // answer는 for문에서 새로 입력받아야 하므로 비워준다

        count = 0       //while문을 다음에 돌려야 하는지 확인을 위해 count 를 0으로 초기화한다
        var temp = '0'  //temp에는 이전 for문의 elem을 기록하여 중복을 확인할 것이다, 하지만 처음에는 중복에 걸리지 않을 문자가 필요해 '0' 으로한다

        for(elem in tempCryptogram){
            if(temp == elem){   //앞의 문자와 중복이 생겼다면
                count++     //중복이 발생하면 count값을 올려준다
                check = 1   //다음 for문 ( -> 현재 elem ) 의 입력을 막기 위해 check를 1로 바꿔준다
                last = 0    //이 elem이 마지막 문자인 경우 입력이 되면 안되므로 last는 0으로 해준다
                temp = elem
            }
            else if(check == 1){        //이 앞에서 중복이 발생한 문자중 뒤 문자인 경우
                check = 0       //temp를 입력해줄수는 없고, check를 다시 0으로 바꿔준다
                last = 1        //중복이 발생한 것은 아니므로 이 elem이 마지막 문자인 경우 입력해줘야 한다
                temp = elem
            }
            else{       //현재 temp가 중복된 문자가 아닌 경우
                if(temp != '0')     //처음 temp를 '0'로 초기화했지만 이는 중복 방지를 위한것이지 입력되면 안되므로 제외한다
                    answer = answer + temp      //answer 문자열의 뒤에 추가해준다
                temp = elem
                last =1     //당연히 마지막에도 더해준다
            }
        }
        if(last == 1)       //for문에서 처리되지 못한 마지막 문자를 더해준다
            answer = answer  + temp
    }

    return answer
}
