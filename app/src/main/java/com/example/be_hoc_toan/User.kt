package com.example.be_hoc_toan

class User {
    var id : Int = 0
    var Name : String = ""
    var Score : Int = 0
    var startTime = ""
    var endTime = ""
    constructor(name:String,score:Int,start:String,end:String){
        this.Name = name
        this.Score = score
        this.startTime = start
        this.endTime = end
    }
}