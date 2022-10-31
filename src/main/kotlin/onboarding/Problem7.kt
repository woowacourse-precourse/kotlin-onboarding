package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val myFriend = makeMyFriend(user,friends)
    addFriend(user,friends,myFriend)
    addVisitor(visitors,myFriend)

    val result = sortAsc(ScoreCalculate.Scores)

    return makeRank(result)
}

object ScoreCalculate{
    var Scores = mutableListOf<Score>()

    fun calculate(name : String, score : Int){
        when(Scores.any{it.name==name}){
            true -> addOld(name, score)
            false -> addNew(name, score)
        }
    }

    private fun addNew(name :String, score : Int){
        val new = Score(name, score)
        Scores.add(new)
    }

    private fun addOld(name : String, score : Int){
        for(i in Scores){
            if(i.name==name){
                i.score+=score
                break
            }
        }
    }
}

data class Score(val name:String, var score:Int)

fun makeMyFriend(user : String ,friends : List<List<String>>): List<String>{
    val myFriend : MutableList<String> = mutableListOf()
    for(relation in friends){
        if(relation.contains(user)){
            myFriend.add(when(relation[0]==user){
                true -> relation[1]
                false -> relation[0]
            })
        }
    }
    return myFriend
}

fun addFriend(user: String,
              friends: List<List<String>>,
              myFriend :List<String>){
    for(i in friends){
        if(!i.contains(user) &&
            (myFriend.any{ it == i[0] } xor myFriend.any{it == i[1]} )){ //둘 다 친구인 경우는 제외
            when(myFriend.any{ it == i[0] }){
                true -> ScoreCalculate.calculate(i[1],10)
                false ->ScoreCalculate.calculate(i[0],10)
            }
        }
    }
}

fun addVisitor(visitors : List<String>, myFriend: List<String>){
    val visitorList  = visitors.toMutableList()
    for(i in myFriend){
        visitorList.remove(i)
    }
    for(i in visitorList){
        ScoreCalculate.calculate(i,1)
    }
}

fun sortAsc(scores : MutableList<Score>): MutableList<Score>{
    scores.sortWith(
        compareBy(
            {-it.score},
            {it.name}
        )
    )
    return scores
}

fun makeRank(scores : MutableList<Score>) : List<String>{
    val rank = mutableListOf<String>()
    var count = 0
    for(i in scores){
        rank.add(i.name)
        count++
        if(count ==5)
            break
    }
    return rank
}