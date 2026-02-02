// src/main/scala/Main.scala

import scala.util.{Try, Success, Failure}
import scala.io.StdIn
import java.time.LocalDateTime

object Main {

  def example(): Unit = {
    println("Example 1: SimpleCache")

    val cache = new SimpleCache

    cache.put("aabb", 1)
    cache.put("abab", 9)
    cache.put("abba", 8)
    cache.put("aaaa", 7)
    cache.put("bbbb", 3)

    println(cache)
    
    val f = (a: Int) => a*a
    val x2 = (a: Int) => 2*a
    
    cache.modify("aabb", f)
    cache.modify("bbbb", x2)
    
    println(cache)
}


  def main(args: Array[String]): Unit = {
      example()
  }
}
