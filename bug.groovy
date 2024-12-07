```groovy
def myMethod(List<String> list) {
  list.eachWithIndex { String item, int index ->
    println "Item $index: $item"
    if (item == "someValue") {
      list.remove(item) // This line might cause ConcurrentModificationException
    }
  }
}

List<String> myList = ["value1", "someValue", "value3", "someValue"]
myMethod(myList)
```