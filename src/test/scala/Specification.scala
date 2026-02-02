import org.scalacheck._
import org.scalacheck.Prop.forAll

object CacheSpecification extends Properties("Cache") {
  property("putThenGet") = forAll { (k: String, v: Int) =>
    val c = new SimpleCache
    c.put(k, v)
    c.get(k) == Some(v)
  }

  property("overwrite") = forAll { (k: String, v1: Int, v2: Int) =>
    val c = new SimpleCache
    c.put(k, v1)
    c.put(k, v2)
    c.get(k) == Some(v2)
  }

  property("independentKeys") = forAll { (k1: String, k2: String, v1: Int, v2: Int) =>
    if (k1 != k2) {
      val c = new SimpleCache
      c.put(k1, v1)
      c.put(k2, v2)
      c.get(k1) == Some(v1) && c.get(k2) == Some(v2)
    }
    else true
  }

  property("modifyExisting") = forAll { (k: String, v: Int, delta: Int) =>
    val c = new SimpleCache
    c.put(k, v)
    c.modify(k, _ + delta)
    c.get(k) == Some(v + delta)
  }

  property("modifyMissingNoEffect") = forAll { (k: String, delta: Int) =>
    val c = new SimpleCache
    c.modify(k, _ + delta)
    c.get(k) == None
  }
}
