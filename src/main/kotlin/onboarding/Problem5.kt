package onboarding


fun solution5(money: Int): List<Int> {
    var m=money

    var unit:Array<Int> = arrayOf(50000,10000,5000,1000,500,100,50,10,1);
    var result= ArrayList<Int>();
    for(i:Int in unit){
        result.add(m/i);
        m%=i;

    }
    return result
}

