package com.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class SeleniumTests {
	static WebDriver driver;
	static String baseUrl = "http://localhost:8090";
	protected static int timeout = 4;

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
		driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	// Inicio de sesión con datos inválidos (usuario no existente en la aplicación)
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
		assertTrue(driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "/login?error=true"));
	}

	// Inicio de sesión con datos válidos (user: admin, pwd: admin)
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
		assertTrue(driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "/dashboard"));
	}

	// Acceso al dashboard sin autentificación
	public void PR03() {
		// Tratamos de navegar al dashboard
		driver.navigate().to(baseUrl + "/dashboard");
		wait(driver, 1);
		// Comprobamos que hemos sido redirigidos al login
		assertTrue(driver.getCurrentUrl().equalsIgnoreCase(baseUrl + "/login"));
	}
}
