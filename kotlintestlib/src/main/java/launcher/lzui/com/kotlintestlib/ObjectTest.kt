package launcher.lzui.com.kotlintestlib

fun main() {
//    listener.move(100, 100)
//    MyClass.create().methodTest()
//    println(MyClass.VALUE)

    var map:MutableMap<String, Any?> = mutableMapOf(
            "name" to "菜鸟教程",
            "url" to "www.runoob.com"
    )

    var site = Site(map)
    println(site.name)
    println(site.url)

    map.put("name", "Google")
    map.put("url", "www.google.com")
    println(site.name)
    println(site.url)

}

var listener = object : MouseEvent() {

//    override fun move(x: Int, y: Int) {
////        super.move(x,y)
//    }
}

open class MouseAdapter {

    open fun mouseEntered(e: MouseEvent) {
        e.move(0, 0)
    }

    open fun mouseClicked(e: MouseEvent) {
        e.move(100, 100)
    }
}

open class MouseEvent {
    open fun move(x: Int, y: Int) {
        print("x = $x ,y = $y")
    }

}

class MyClass {
//    companion object Factory {
//        fun create(): MyClass = MyClass()
//        var VALUE: String = "Create"
//    }

    companion object {
        fun create(): MyClass = MyClass()
        const val VALUE: String = "Create"
    }

    fun methodTest() {
        println("I'm method.")
    }
}

class Site(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String by map
}