package com.uniovi.asw;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumTests {
	static String PathFirefox = "C:\\Users\\David\\Downloads\\Firefox46.win\\FirefoxPortable.exe";
	static WebDriver driver = getDriver(PathFirefox);
	static String URL = "http://localhost:8090";
	protected static int timeout = 4;

	public static WebDriver getDriver(String PathFirefox) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	private static void wait(WebDriver driver, int secs) {

		synchronized (driver) {
			try {
				driver.wait(secs * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

	// Inicio de sesión con datos inválidos (usuario no existente en la aplicación)
	@Test
	public void PR01() {
		// Vamos al formulario de logueo.
		driver.findElement(By.id("indexLoginButton")).click();
		wait(driver, 1);
		// Rellenamos el formulario
		WebElement username = driver.findElement(By.name("username"));
		username.click();
		username.clear();
		username.sendKeys("usuarioInexistente");
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys("contraseñaInexistente");
		// Pulsar el boton de Alta.
		driver.findElement(By.id("loginButton")).click();
		wait(driver, 1);
		// Comprobamos que seguimos en el login
		Assert.assertTrue(driver.getCurrentUrl() + " vs " + URL + "/login\n",
				driver.getCurrentUrl().equalsIgnoreCase(URL + "/login?error=true"));
	}

	// Inicio de sesión con datos válidos (user: admin, pwd: admin)
	@Test
	public void PR02() {
		// Vamos al formulario de logueo.
		driver.findElement(By.id("indexLoginButton")).click();
		wait(driver, 1);
		// Rellenamos el formulario
		WebElement username = driver.findElement(By.name("username"));
		username.click();
		username.clear();
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys("admin");
		// Pulsar el boton de Alta.
		driver.findElement(By.id("loginButton")).click();
		wait(driver, 1);
		// Comprobamos que entramos al dashboard
		Assert.assertTrue(driver.getCurrentUrl() + " vs " + URL + "/dashboard\n",
				driver.getCurrentUrl().equalsIgnoreCase(URL + "/dashboard"));
	}

	// Acceso al dashboard sin autentificación
	@Test
	public void PR03() {
		// Tratamos de navegar al dashboard
		driver.navigate().to(URL + "/dashboard");
		wait(driver, 1);
		// Comprobamos que hemos sido redirigidos al login
		Assert.assertTrue(driver.getCurrentUrl() + " vs " + URL + "/login\n",
				driver.getCurrentUrl().equalsIgnoreCase(URL + "/login"));
	}
}
