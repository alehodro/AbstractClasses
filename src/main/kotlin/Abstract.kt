/*
Абстрактный класс - является незавершенной моделью класса. Абстрактные классы используются для проектирования конкретных
классов, через наследование . Создать объект абстрактного класса невозможно. Абстрактные классы
могут хранить состояния.
Члены  абстрактного класса (функции и пропертя) могут быть абстрактными, т.е. не иметь реализации (только контракты)
для функций, и не иметь инициализации для пропертей. Такие функции и проперят  должны быть обязательно переопределены
 и реализованы или инициализированы в классе наследнике.
Абстрактный класс может иметь собственные функции, которые можно вызывать в классе наследнике. Собственные функции
абстрактного класса можно переопредлять в классе наследнике, для этого они должны быть помечены модификатором open.

 */


abstract class Animal(val weight: Int, val sex: String) {
    init {
        println("Animal is created")
    }

    abstract val type: String
    abstract fun say()
    fun eat() {
        println("$type eats")
    }

    open fun getDetails() {
        println("Тип животного - $type")
        println("Вес животного - $weight")
        println("Пол животного - $sex")
    }
}

class Cow(val name: String, weight: Int, sex: String) : Animal(weight, sex) {
    override val type: String = "Cow"

    init {
        println("$type is created")
    }

    override fun say() {
        println("$type says Mooow")
    }

    override fun getDetails() {
        super.getDetails()
        println("Имя животного - $name")
    }
}

/*
С помощью абстрактного класса возможно переопределить открытую не абстрактную функцию и сделать ее абстрактной через
 наследование

 */

open class Cash(){
    open fun getSalary(){
        println("Now you get your cash")
    }
}

abstract class ElectronicMoney():Cash(){
    override abstract fun getSalary()
}

class BitCoin():ElectronicMoney(){
    override fun getSalary() {
        println("Now you get your bitcoins")
    }
}

class DebitCard():ElectronicMoney(){
    override fun getSalary() {
        println("Now you get your debit card balans")
    }
}

/*
Абстрактную функцию абстрактного класса можно переопределять во множестве классов через наследование
 */

abstract class Calculator(){
    abstract fun calculate(x:Int,y:Int):Int
}

class Add():Calculator(){
    override fun calculate(x: Int, y: Int): Int {
        return x+y
    }
}

class Multiply():Calculator(){
    override fun calculate(x: Int, y: Int): Int {
        return x*y
    }

}