package problem3

class Game369 {
    private fun count369(num:String) : Int {
        return num.count { it == '3' || it == '6' || it == '9' }
    }

    fun count369(start:Int, end:Int) : Int {
        var clap = 0

        for(i in start..end) {
            clap += count369(i.toString())
        }

        return clap
    }
}