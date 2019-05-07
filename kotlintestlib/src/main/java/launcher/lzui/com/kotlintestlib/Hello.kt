package launcher.lzui.com.kotlintestlib

/**
 * Desc: TODO
 *
 * Author: zhoulai
 * PackageName: launcher.lzui.com.kotlintestlib
 * ProjectName: kotlin
 * Date: 2019/4/19 10:27
 */


fun main(args: Array<String>) {
    val user = User("jone", 18)
//    println("name = " + user.name + " age = " + user.age)
//    user.learnKotlin()
//    val add: (a: Int, b: Int) -> Int = { a, b ->
//        a + b
//    }
//    val result = user.learMath(1, 2, 3, 4, 5)
//    println("result = $result")
//    println("add =" + add(1, 2))
//
//    var a = 1
//    // 模板中的简单名称：
//    val s1 = "a is $a"
//
//    a = 2
//    // 模板中的任意表达式：
//    val s2 = "${s1.replace("is", "was")}, but now is $a"
//    println(s2)
//    val arr = Array(1){
//        "1"
//    }
//    val arr1 = arrayOf(user)
//    println(user.main2(arr1))

//    user.testFor()
//    user.changeNum()
    var people = People("", "")
    people.firstName  = "jone"
    people.lastName  = "jonenet"
    println("firstName = ${people.firstName } lastName = ${people.lastName}")
}


class User(var name: String, var age: Int) {


    fun learnKotlin() {
        println("${name}在学习Kotlin")
    }

    fun learMath(vararg v: Int): Int {
        var sum = 0
        for (i in v) {
            sum += i
        }
        return sum
    }

    fun main2(args: Array<User>) {
//        if (args.size < 2) {
//            print("Two integers expected")
//            return
//        }
        for (arg in args) {
            println(arg.age)
        }
        // 直接使用 `x * y` 会导致错误, 因为它们可能为 null.
//        if (x != null && y != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
//        }
    }


    fun testFor() {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        for ((index, value) in items.withIndex()) {
            println("the element at $index is $value")
        }
    }

    fun changeNum() {
        println(if (age > 10) age else 10)

        val x = 1
        when (x) {
            1,2 ->{}
            else -> { // 注意这个块
                print("x 不是 1 ，也不是 2")
            }
        }
    }

}