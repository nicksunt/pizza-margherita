import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductInCartTest extends BaseAbstractClass {

    @Test
    public void testAddPizzaAndColaToCart() throws InterruptedException {

        HomePizzaPageObj homePage = new HomePizzaPageObj(chromeDriver);
        CartPageObj cartPage = new CartPageObj(chromeDriver);

        homePage.openPageHome()                                      // открыли главную страницу
                .clickBtnOrderPizzaMargarita30()                     // нажали заказать маргариту
                .goToNapitki()                                       // перешли на вкладку напитки
                .clickBtnOrderCola05()                               // нажали заказать колу05
                .goToCart()                                          // перешли в корзину
                .ShowQuantityInCart(cartPage.quantityPizzaMargaritaInCart,
                        cartPage.actualQuantityPizzaMargaritaInCart)   // определили сколько в корзине маргарит
                .ShowNameInCart(cartPage.namePizzaMargaritaInCart,
                        cartPage.actualNamePizzaMargaritaInCart)   // определили что это именно маргариты30
                .ShowQuantityInCart(cartPage.quantityCola05InCart,
                         cartPage.actualQuantityCola05InCart)      // определили сколько колы05 в корзине
                .ShowNameInCart(cartPage.nameCola05InCart,
                        cartPage.actualNameCola05InCart);          // определили что это именно кола05

        assertEquals(CartPageObj.map.get("actualQuantityPizzaMargaritaInCart"),"1");

        assertEquals(CartPageObj.map.get("actualNamePizzaMargaritaInCart"), "Маргарита30");

        assertEquals(CartPageObj.map.get("actualQuantityCola05InCart"), "1");

        assertEquals(CartPageObj.map.get("actualNameCola05InCart"), "Кока - Кола 0.5");
    }
}
