package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var word_mail=mutableMapOf<String, MutableSet<String>>()
    var size=forms.size
    for(i in 0..size-1){
        var name_size=forms[i][1].length
        var email=forms[i][0]
        var name=forms[i][1]
        for(j in 0..name_size-2){
            var word=name.substring(j..j+1)
            if(word_mail[word]==null) word_mail[word]= mutableSetOf()
            word_mail[word]?.add(email)
        }
    }

    var mails=mutableSetOf<String>()
    for(word in word_mail){
        if(word.value.size==1) continue

        for(mail in word.value) {
            mails.add(mail)
        }
    }

    var ret=mails.toList().sorted()
    return ret
}
