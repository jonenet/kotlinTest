package launcher.lzui.com.kotlintestlib


fun <T : Comparable<T>> sort(list: List<T>) {
    // ……
}

fun main() {
    sort(listOf(1, 2, 3)) // OK。Int 是 Comparable<Int> 的子类型
    val listOf = listOf(HashMap<Int, String>())
//    println(listOf)
//    sort(listOf) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型

//    print(RunBob2(1).foo(2))

    //使用类
    val a1: A<*> = A(12, "String", Apple("苹果"))
    val a2: A<Any?> = A(12, "String", Apple("苹果"))   //和a1是一样的
    val apple = a1.t3    //参数类型为Any
    println(apple)
    apple as Apple   //强转成Apple类
    println(apple.name)
    //使用数组
    val l:ArrayList<*> = arrayListOf("String",1,1.2f,Apple("苹果"))
    for (item in l){
        println(item)
    }
}


// 定义一个支持协变的类
class RunBob<out A>(private val a: A) {
    fun foo(): A {
        return a
    }
}

// 定义一个支持协变的类
class RunBob2<in B>(private val b: B) {
    fun foo(b: B) {
        print(b)
    }
}


class A<T>(val t: T, val t2 : T, val t3 : T)
class Apple(var name : String)

