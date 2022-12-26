class Stack<T> {

    //   var item: T? = value

   private var stackList = mutableListOf<T>()

    fun push(item: T) {
        stackList.add(item)
    }
    fun pop(): T? {
        return if (isEmpty()) {
            null
        } else {
            val popLast = stackList.last()
            stackList.removeAt(stackList.lastIndex)
        return popLast}

    }
    fun isEmpty(): Boolean {
        return stackList.isEmpty()
    }
}



