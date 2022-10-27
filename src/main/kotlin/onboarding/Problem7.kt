package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var Myfriend = makeMyFriend(user,friends)
    for(i in friends){
        if(!i.contains(user) &&
            (Myfriend.any{ it == i[0] } xor Myfriend.any{it == i[1]} )){ //둘 다 친구인 경우는 제외
            when(Myfriend.any{ it == i[0] }){
                true -> ScoreCalculate.Calculate(i[1],10)
                false ->ScoreCalculate.Calculate(i[0],10)
            }
        }
    }
    var visitors  = visitors.toMutableList()
    for(i in Myfriend){
        visitors.remove(i)
    }
    for(i in visitors){
        ScoreCalculate.Calculate(i,1)
    }
    ScoreCalculate.Scores = sortAsc(ScoreCalculate.Scores)

    return makeRank(ScoreCalculate.Scores)
}

object ScoreCalculate{
    var Scores = mutableListOf<Score>()

    fun Calculate(name : String , score : Int){
        when(Scores.any{it.name==name}){
            true -> addOld(name, score)
            false -> addNew(name, score)
        }
    }

    fun addNew(name :String, score : Int){
        var new = Score(name, score)
        Scores.add(new)
    }

    fun addOld(name : String, score : Int){
        for(i in Scores){
            if(i.name==name){
                i.score+=score
                break;
            }
        }
    }
}

data class Score(val name:String, var score:Int)

fun makeMyFriend(user : String ,friends : List<List<String>>): List<String>{
    var Myfriend : MutableList<String> = mutableListOf()
    for(relation in friends){
        if(relation.contains(user)){
            Myfriend.add(when(relation[0]==user){
                true -> relation[1]
                false -> relation[0]
            })
        }
    }
    return Myfriend
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
    var rank = mutableListOf<String>()
    var count = 0;
    for(i in scores){
        rank.add(i.name)
        count++
        if(count ==5)
            break
    }
    return rank
}