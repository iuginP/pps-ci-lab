package u07lab

import org.scalamock.matchers.Matchers
import org.scalamock.scalatest.MockFactory
import org.scalatest.{FlatSpec, FunSpec, FunSuite}

class CartTest extends FunSuite {

  test("Cart initial empty") {
    assert(new BasicCart().size == 0)
  }

  test("Cart content") {
    val cartC = Map((new Product(""), new ItemDetails(1, new Price(1.0))));
    val cart = new BasicCart(cartC)
    assert(cartC.size == cart.content.size)
  }

}

class CatalogTest extends FlatSpec {

  "Catalog" should " have 0 products" in {
    assert(new BasicCatalog(Map.empty).products.isEmpty)
  }

}

class WarehouseTest extends FunSpec {

  describe("A wareouse") {
    describe("when empty") {
      it("return 0 products") {
        assert(new BasicWarehouse().get(new Product(""), 10) == (new Product(""), 0))
      }
    }
  }
}

class ShoppingTest extends FunSuite with MockFactory with Matchers {
  test("scalaMock") {
    val warehouseMock = mock[Warehouse]
//    val sStub = stubFunction[Request , Boolean]

    val (p1,p2) = (Product("Shoe"), Product("Hat"))

/*
    inSequence {
      (warehouseMock.supply _).expects(p1,2)
      (warehouseMock.supply _).expects(p2,50)
    }
*/
    val warehouse = new BasicWarehouse
    warehouse.supply(p1, 2)
    warehouse.supply(p2, 50)
    assert(true)
//    val catalog = new BasicCatalog(Map[Product,Price](
//      p1 -> Price(78),
//      p2 -> Price(34)
//    ))
//    val cart = new BasicCart()
//    val shopping = new Shopping(warehouse, catalog, cart, new BasicLogger(">> "))
//    shopping.pick(p1,1)
//    shopping.pick(p2,2)
//    shopping.pick(p1,2)
//    println(cart.content)
//    println("Total cost: " + cart.totalCost)
  }
}
