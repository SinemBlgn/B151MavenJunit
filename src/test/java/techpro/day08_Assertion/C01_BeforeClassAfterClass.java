package techpro.day08_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("her classtan once beforeclass method'u bir kez calisir ");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("her classde sonra afterclass methodu bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her methodtan once before method bir kez calisir ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her method dan sonra after(teardown) method u bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("test01 calisti");

    }

    @Test
    public void test02() {
        System.out.println("test02 calisti");
    }

    @Test
    public void test03() {
        System.out.println("test03 calisti");
    }
}
