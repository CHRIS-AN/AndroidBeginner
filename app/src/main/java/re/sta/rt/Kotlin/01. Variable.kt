package re.sta.rt.Kotlin

// 01. Variable -> 변수

// var(varivable) -> 내 마음대로 원하는 것을 넗을 수 있는 상자
// val(value) -> 한 번 넣으면 바꿀수 없는 상자



var num = 10
var hello = "hello"
var point = 3.4

val fix = 20


fun main (args:Array<String>) {

    println(num)
    println(hello)
    println(point)
    println(fix)

    println("-----------")


    num = 100
    hello = "Good Bye"
    point = 10.4

    println(num)
    println(hello)
    println(point)

    //fix = 500;    ERROR : Val cannat be reassigned
     println(fix)
}