package com.example.agrofield.models

class User {
    var email: String = ""
    var pass:String =""
    var userid :String =""

    constructor(email:String,pass:String,userid:String){
        this.email=email
        this.userid =userid
        this.pass=pass
    }
    constructor()
}