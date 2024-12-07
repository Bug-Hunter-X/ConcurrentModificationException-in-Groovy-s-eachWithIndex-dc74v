```groovy
def myMethod(List<String> list) {
  //Create a copy to avoid ConcurrentModificationException
  list.eachWithIndex { String item, int index ->
    println "Item $index: $item"
    if (item == "someValue") {
      list.remove(item)
    }
  }
}

List<String> myList = ["value1", "someValue", "value3", "someValue"]
myMethod(myList)

//Alternative using iterator and remove()

def myMethod2(List<String> list){
    Iterator<String> iterator = list.iterator()
    while(iterator.hasNext()){
        String item = iterator.next()
        if(item == "someValue"){
            iterator.remove()
        }
    }
}
myList = ["value1", "someValue", "value3", "someValue"]
myMethod2(myList)
println myList
```