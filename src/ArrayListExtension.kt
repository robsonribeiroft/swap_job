fun <T> ArrayList<T>.removeFirst() {
    if (this.isNotEmpty()){
        this.removeAt(0)
    }
}

fun <T> ArrayList<T>.moveToDown(){
    this.add(this.first())
    this.removeFirst()
}
