package onboarding


fun solution6(forms: List<List<String>>): List<String> {

    var email_set = HashSet<String>()
    var email_and_nick = HashMap<String,String>()

    for(i in 0 until forms.size){

        var name = forms[i][1]

        if(name.length < 2){
            break
        }

        

}
