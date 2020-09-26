package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import sun.rmi.runtime.Log;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests{

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url");
    }

    @Story("Realizar Cadastro ")
    @Test
    public void createAccount(){
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        MyAccountPage account = new MyAccountPage();

        home.clickBtnLogin();

        System.out.println("Clicou em Sing In e direcionou para a página de login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        account.KeyEmailCreate();
        account.clickBtnSubmitCreate();
        account.clickCheckGender();
        account.createFirstName();
        account.createLastName();
        account.createPasswd();
        account.selectDays();
        account.selectMonths();
        account.selectYears();
        account.createAdress();
        account.createCity();
        account.selectState();
        account.createPostCode();
        account.createPhoneMobile();
        account.createAlias();
        account.clickBtnSubmitAccount();

        System.out.println("Cadastro realizado com sucesso! ");
    }

    @Test
    @Story("Realizar o login")
    public void testLogin() {

        // Iniciar as páginas

        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();

        System.out.println("Clicou em Sing In e direcionou para a página de login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));

        login.fillEmail();
        System.out.println("Preencheu o email");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou em Sing In");
        Assert.assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a URL de minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou Minha conta no Site");

    }

    @Test
    @Story("Pesquisar por Produto")
    public void testeSearch(){

        String quest = "DRESS";
        String questResultQtd = "7";

        // Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);

        //Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""),quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));

    }

    @Test
    @Story("Acessar Categoria")
    public void testAcessCategoryTShirts(){

        //Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T-Shirts
        home.clickCategoryTShirts();
        //Browser.getCurrentDriver().findElement(By.linkText("T-SHIRTS")).click();

        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
    }

    @Test
    @Story("Acessar a página de produto")
    public void testAddProductToProductPage(){

        //Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva o nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicaar em More e direcionar para a página do produto
        category.clickProductAddToProductPage();

        //Verifica se produto está na página de detalhess do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));

    }

    @Test
    @Story("Adicionar produto ao carrinho")
    public void testAddProductToCartPage(){
        //Acessa a página de produto
        testAddProductToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salvar o nome do produto na página PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de Adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed To Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //Validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));

    }

    @Test
    @Story("Finalizar Compra")
    public void testCheckOut(){

        //Acessa a página de produto
        testAddProductToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();
        ProceedToCheckout pc = new ProceedToCheckout();
        LoginPage login = new LoginPage();

        //Salvar o nome do produto na página PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de Adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed To Checkout da modal
        pdp.clickButtonModalProceedToCheckout();

        //Validação do nome do produto no carrinho
        assertTrue(cart.getNameProductCart().equals(nameProductPDP));

        pc.clickBtnCartAdd();

        //faz login
        login.fillEmail();
        login.fillPasswd();
        login.clickBtnSubmitLogin();

        pc.clickBtnCartAdd2();

        pc.clickCheckBox();

        pc.clickBtnShipping();

        pc.clickBtnPayBank();

        pc.clickBtnConfirmOrder();


    }
}