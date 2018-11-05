package extensions

fun <T> ArrayList<T>?.removeFirst() {
    if (this == null || isEmpty()) throw NullPointerException("ArrayList is null or Empty")
    removeAt(0)
}

fun <T> ArrayList<T>?.moveToDown(){
    if (this == null) throw NullPointerException("ArrayList is null")
    add(first())
    removeFirst()
}

fun ArrayList<String>?.concat(value:Char, position: Int?=null) {
    if (this == null || isEmpty()) throw NullPointerException("ArrayList is null or Empty")
    this[position ?: lastIndex] = this[position ?: lastIndex] + value
}