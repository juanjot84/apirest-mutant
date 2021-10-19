package com.erParcial.apirestmutant.entitiesTest;

import com.erParcial.apirestmutant.entities.Mutant;
import com.erParcial.apirestmutant.entities.SearchMutant;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchMutantTest {
    SearchMutant searchMutant;
    String[] dna = new String[]{"AAAAG","AAGGT","AGATG","AGTAG","ATGGG"};

    @BeforeAll
    public static void beforeAll() {

    }

    @AfterAll
    public static void afterAll() {

    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("finaliza " + testInfo.getDisplayName());
    }

    @BeforeEach
    public void beforeEach( TestInfo testInfo) {
        searchMutant = new SearchMutant();
        System.out.println("inicio " + testInfo.getDisplayName());
    }

    @Test
    @Order(1)
    public void busquedaHorizontalTest() {
        String fila = dna[0];
        int contSecuencia = 0;
        int resultadoEsperado = 1;

        contSecuencia = searchMutant.busquedaHorizontal(fila, contSecuencia);
        Assertions.assertEquals(resultadoEsperado,contSecuencia);
        System.out.println("Resultado Horizontal: "+contSecuencia);
    }

    @Test
    @Order(2)
    public void busquedaVertical() {
        int colum = 0;
        int contSecuencia = 0;
        int resultadoEsperado = 1;

        contSecuencia = searchMutant.busquedaVertical(dna, colum, contSecuencia);
        Assertions.assertEquals(resultadoEsperado,contSecuencia);
        System.out.println("Resultado Vertical: "+contSecuencia);
    }

    @Test
    @Order(3)
    public void busquedaOblicuaTest() {
        int colum = 0;
        int size1 = dna.length - 1;
        int size2 = dna.length;
        int contSecuencia = 0;
        int resultadoEsperado = 1;

        contSecuencia = searchMutant.busquedaOblicua(dna, colum, size1, size2, contSecuencia);
        Assertions.assertEquals(resultadoEsperado,contSecuencia);
        System.out.println("Resultado Oblicua: "+contSecuencia);
    }

    @Test
    @Order(4)
    public void busquedaOblicuaInvTest() {
        int contSecuencia = 0;
        int resultadoEsperado = 1;

        contSecuencia = searchMutant.busquedaOblicuaInv(dna, contSecuencia);
        Assertions.assertEquals(resultadoEsperado,contSecuencia);
        System.out.println("Resultado Oblicua Inversa: "+contSecuencia);
    }

    @Test
    @Order(5)
    public void buscarMutanteTest() throws Exception {
        Mutant mutant;
        String calificacion;
        String resultadoEsperado = "mutante";
        mutant = searchMutant.buscarMutante(dna);

        calificacion = mutant.getClasificacion();
        Assertions.assertEquals(resultadoEsperado,calificacion);
        System.out.println("Resultado Buscar Mutante: "+calificacion);
    }

}
