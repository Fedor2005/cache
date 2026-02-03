import scala.collection.mutable.Map


// Абстрактный интерфейс кэша с эффектом F[_]
trait Cache[F[_], Key, Value]{
  def get(key: Key): F[Option[Value]]
  def put(key: Key, value: Value): F[Unit]
  def modify(key: Key, f: Value=>Value): F[Unit]
}

type Id[A] = A

class SimpleCache extends Cache[Id, String, Int]:
  private val map = Map.empty[String, Int]

  def get(key: String): Option[Int] = map.get(key)
  def put(key: String, value: Int): Unit = map.put(key, value)
  def modify(key: String, f: Int=>Int): Unit ={
    val current = map.get(key) match {
      case Some(value) => map.put(key, f(value))
      case None => 0
    }
    ()
  }
  override def toString: String = map.toString
