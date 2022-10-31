package onboarding


fun solution6(forms: List<List<String>>): List<String> {

    var email_set = HashSet<String>()
    var email_and_nick = HashMap<String,String>()

    for(i in 0 until forms.size){

        var name = forms[i][1]

        if(name.length < 2){
            break
        }

        for(j in 0 until name.length-1){

            var key = name.substring(j , j+2)

            if(email_and_nick.containsKey(key)){

                var email = email_and_nick.get(key)

                if(!email.equals(forms[i][0])){
                    email?.let { email_set.add(it) }
                    email_set.add(forms[i][0])
                }
            }



            email_and_nick.put(key, forms[i][0])
        }



    }


}
