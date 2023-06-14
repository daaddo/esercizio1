package com.jinjection.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jinjection.ann.ConditionToExecute;
import org.jinjection.ann.Exercise;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@ConditionToExecute(classToCheck = Table.class)
public class TableTest {

    private String message;
    private String result;
    private static float vote = 0;
    private static final String title;
    public static final String UNKNOWN_EXERCIZE = "<UNKNOWN EXERCIZE>";
    private static boolean nameExisting = false;
    private static boolean widthExisting = false;
    private static boolean heightExisting = false;
    private static boolean areaExisting = false;
    private static boolean changeNameExisting = false;
    private static boolean areaReturnsInt = false;
    private static boolean changeNameReturnsVoid = false;
    private static final String BREAKLINE = "\n---------------------------------------------------------------------------------------------------";

    static {
        Exercise annotation = Table.class.getAnnotation(Exercise.class);
        title = annotation == null ? UNKNOWN_EXERCIZE : annotation.name();
    }

    public TableTest() {
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {

    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("\n\n===========================================================");
        if (vote > 30) {
            System.out.println("\t\t\tYOUR VOTE: 30 e Lode ! ");
        } else {
            System.out.println("\t\t\tYOUR VOTE: " + round(vote, 1) + "/30");
        }

        System.out.println("===========================================================\n\n");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("[JUnit][Classi e Oggetti]" + message + ": " + result);

    }

    @Test
    @DisplayName("(1/2) Easy: attributo name [existence]")
    void test1a1(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Field fieldName = Table.class.getDeclaredField("name");
            Assertions.assertNotNull(fieldName);
            nameExisting = true;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo name");
            return;
        } catch (SecurityException ex) {
            return;
        }

        result = "\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(2/2) Easy: attributo name [private & type]")
    void test1a2(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]";
        Assumptions.assumeTrue(nameExisting);
        result = "\t[FAIL]";
        try {
            Field fieldName = Table.class.getDeclaredField("name");
            int modifiers = fieldName.getModifiers();
            Assertions.assertTrue(Modifier.isPrivate(modifiers), "la variabile name non ha accesso privato.");
            Assertions.assertEquals(String.class, fieldName.getType(), "L'attributo 'name' non è String. ");
        } catch (SecurityException ex) {
            return;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo name");
            return;
        }

        result = "\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("(1/2) Easy: attributo width [existence]")
    void test2a(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Field fieldName = Table.class.getDeclaredField("width");
            Assertions.assertNotNull(fieldName);
            widthExisting = true;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo width");
            return;
        } catch (SecurityException ex) {
            return;
        }

        result = "\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(2/2) Easy: attributo width [private & type]")
    void test2b(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]";
        Assumptions.assumeTrue(widthExisting);
        result = "\t[FAIL]";
        try {
            Field fieldName = Table.class.getDeclaredField("width");
            int modifiers = fieldName.getModifiers();
            Assertions.assertTrue(Modifier.isPrivate(modifiers), "la variabile width non ha accesso privato.");
            Assertions.assertEquals(int.class, fieldName.getType(), "L'attributo 'width' non è String. ");
        } catch (SecurityException ex) {
            return;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo width");
            return;
        }

        result = "\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(1/2) Easy: attributo height [existence]")
    void test3a(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Field fieldName = Table.class.getDeclaredField("height");
            Assertions.assertNotNull(fieldName);
            heightExisting = true;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo height");
            return;
        } catch (SecurityException ex) {
            return;
        }

        result = "\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(2/2) Easy: attributo height [private & type]")
    void test3b(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]" + BREAKLINE;
        Assumptions.assumeTrue(heightExisting);
        result = "\t[FAIL]" + BREAKLINE;
        try {
            Field fieldName = Table.class.getDeclaredField("height");
            int modifiers = fieldName.getModifiers();
            Assertions.assertTrue(Modifier.isPrivate(modifiers), "la variabile height non ha accesso privato.");
            Assertions.assertEquals(int.class, fieldName.getType(), "L'attributo 'height' non è String. ");
        } catch (SecurityException ex) {
            return;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "Non esiste l'attributo height");
            return;
        }

        result = "\t[SUCCESS][+2.0]" + BREAKLINE;
        vote += 2.0f;
    }

    @Test
    @DisplayName("(1/3) Easy: check constructor [empty]")
    void test4a(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Constructor<Table> constructor = Table.class.getConstructor();
            Assertions.assertNotNull(constructor);

            int modifiers = constructor.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il costruttore senza argomenti non è pubblico o non è accessibile");

        } catch (SecurityException ex) {
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.fail("Il costruttore senza argomenti non è accessibile");
            return;
        } catch (IllegalArgumentException ex) {
            Assertions.fail("argomenti invalidi");
            return;
        }

        result = "\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(2/3) Easy: check constructor [width,height]")
    void test4b(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]";
        Assumptions.assumeTrue(heightExisting);
        Assumptions.assumeTrue(widthExisting);
        result = "\t[FAIL]";
        try {
            Constructor<Table> constructor = Table.class.getConstructor(int.class, int.class);
            Assertions.assertNotNull(constructor);

            int modifiers = constructor.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il costruttore senza argomenti non è pubblico o non è accessibile");

            Table table = constructor.newInstance(3, 5);
            Field width_field = table.getClass().getDeclaredField("width");
            width_field.setAccessible(true);
            Assertions.assertEquals(int.class, width_field.getType(), "L'attributo width non è int. ");
            Field height_field = table.getClass().getDeclaredField("height");
            height_field.setAccessible(true);
            Assertions.assertEquals(int.class, height_field.getType(), "L'attributo height non è int. ");

            Assertions.assertEquals(3, width_field.getInt(table), "il costruttore con due argomenti non salva bene i dati");
            Assertions.assertEquals(5, height_field.getInt(table), "il costruttore con due argomenti non salva bene i dati");

        } catch (SecurityException ex) {
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "Il costruttore senza argomenti non è accessibile");
            return;
        } catch (InstantiationException ex) {
            Assertions.assertTrue(false, "Errore nell'istanziazione del costruttore");
            return;
        } catch (IllegalAccessException ex) {
            Assertions.assertTrue(false, "accesso illegale al costruttore");
            return;
        } catch (IllegalArgumentException ex) {
            Assertions.assertTrue(false, "argomenti invalidi");
            return;
        } catch (InvocationTargetException ex) {
            Assertions.assertTrue(false, "target invocation invalid");
            return;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "attributo width o height non trovato");
            return;
        }

        result = "\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("(3/3) Easy: check constructor [n,w,h]")
    void test4c(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[SKIPPED]";
        Assumptions.assumeTrue(heightExisting);
        Assumptions.assumeTrue(widthExisting);
        Assumptions.assumeTrue(nameExisting);
        result = "\t\t[FAIL]";
        try {
            Constructor<Table> constructor = Table.class.getConstructor(String.class, int.class, int.class);
            Assertions.assertNotNull(constructor);

            int modifiers = constructor.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il costruttore pieno non è pubblico o non è accessibile");

            Table table = constructor.newInstance("ciao", 3, 5);
            Field width_field = table.getClass().getDeclaredField("width");
            width_field.setAccessible(true);
            Assertions.assertEquals(int.class, width_field.getType(), "L'attributo width non è int. ");
            Field height_field = table.getClass().getDeclaredField("height");
            height_field.setAccessible(true);
            Assertions.assertEquals(int.class, height_field.getType(), "L'attributo height non è int. ");
            Field name_field = table.getClass().getDeclaredField("name");
            name_field.setAccessible(true);
            Assertions.assertEquals(String.class, name_field.getType(), "L'attributo name non è int. ");

            Assertions.assertEquals(3, width_field.getInt(table), "il costruttore con due argomenti non salva bene i dati");
            Assertions.assertEquals(5, height_field.getInt(table), "il costruttore con due argomenti non salva bene i dati");
            Assertions.assertEquals("ciao", (String) name_field.get(table), "il costruttore con due argomenti non salva bene i dati");

        } catch (SecurityException ex) {
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "Il costruttore senza argomenti non è accessibile");
            return;
        } catch (InstantiationException ex) {
            Assertions.assertTrue(false, "Errore nell'istanziazione del costruttore");
            return;
        } catch (IllegalAccessException ex) {
            Assertions.assertTrue(false, "accesso illegale al costruttore");
            return;
        } catch (IllegalArgumentException ex) {
            Assertions.assertTrue(false, "argomenti invalidi");
            return;
        } catch (InvocationTargetException ex) {
            Assertions.assertTrue(false, "target invocation invalid");
            return;
        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "attributo width o height non trovato");
            return;
        }

        result = "\t\t[SUCCESS][+3.0]" + BREAKLINE;
        vote += 3.0f;
    }

    @Test
    @DisplayName("(1/3) Easy: method area [existence]")
    void test5A(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Method areaMethod = Table.class.getDeclaredMethod("area");
            Assertions.assertNotNull(areaMethod);
            int modifiers = areaMethod.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il metodo area non è pubblico o non è accessibile");
            areaExisting = true;

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'area' non esiste");
            return;
        }

        result = "\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("(2/3) Easy: method area [return type]")
    void test5B(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[SKIPPED]";
        Assumptions.assumeTrue(areaExisting);
        result = "\t\t[FAIL]";
        try {
            Method areaMethod = Table.class.getDeclaredMethod("area");
            Assertions.assertNotNull(areaMethod);

            int modifiers = areaMethod.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il metodo 'area' non è pubblico");
            Assertions.assertEquals(int.class, areaMethod.getReturnType(), "il metodo non ritorna int");
            areaReturnsInt = true;

        } catch (SecurityException ex) {
            Assertions.fail("violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.fail("il metodo 'area' non esiste");
            return;
        }

        result = "\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }

    @Test
    @DisplayName("(3/3) Easy: method area [logic]")
    void test5C(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t\t[SKIPPED]" + BREAKLINE;
        Assumptions.assumeTrue(areaExisting);
        Assumptions.assumeTrue(areaReturnsInt);
        Assumptions.assumeTrue(widthExisting);
        Assumptions.assumeTrue(heightExisting);
        result = "\t\t\t[FAIL]" + BREAKLINE;
        try {

            Constructor<Table> constructor = Table.class.getConstructor(int.class, int.class);
            Assertions.assertNotNull(constructor);
            Table table = constructor.newInstance(5, 2);
            Method areaMethod = Table.class.getDeclaredMethod("area");
            Assertions.assertNotNull(areaMethod);
            int returnValue = (int) areaMethod.invoke(table);

            Assertions.assertEquals(10, returnValue, "il metodo non ritorna il valore corretto");

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'roar' non esiste");
            return;
        } catch (InstantiationException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        result = "\t\t\t[SUCCESS][+2.0]" + BREAKLINE;
        vote += 2.0f;
    }

    @Test
    @DisplayName("(1/3) Easy: method changeName [existence]")
    void test6A(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Method changeName = Table.class.getDeclaredMethod("changeName", String.class);
            Assertions.assertNotNull(changeName);
            int modifiers = changeName.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il metodo changeName non è pubblico o non è accessibile");
            changeNameExisting = true;

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'changeName' non esiste");
            return;
        }

        result = "\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("(2/3) Easy: method changeName [return type]")
    void test6B(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]";
        Assumptions.assumeTrue(changeNameExisting);
        result = "\t[FAIL]";
        try {
            Method areaMethod = Table.class.getDeclaredMethod("changeName",String.class);
            Assertions.assertNotNull(areaMethod);

            int modifiers = areaMethod.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il metodo 'changeName' non è pubblico");
            Assertions.assertEquals(void.class, areaMethod.getReturnType(), "il metodo dovrebbe essere void..");
            changeNameReturnsVoid = true;

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'changeName' non esiste");
            return;
        }

        result = "\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("(3/3) Easy: method changeName [logic]")
    void test6C(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[SKIPPED]" + BREAKLINE;
        Assumptions.assumeTrue(changeNameExisting);
        Assumptions.assumeTrue(changeNameReturnsVoid);
        Assumptions.assumeTrue(nameExisting);
        result = "\t\t[FAIL]" + BREAKLINE;
        try {

            Constructor<Table> constructor = Table.class.getConstructor(String.class, int.class, int.class);
            Assertions.assertNotNull(constructor);
            Table table = constructor.newInstance("Alfonso", 5, 2);
            Method changeName_Method = Table.class.getDeclaredMethod("changeName",String.class);
            Assertions.assertNotNull(changeName_Method);

            Field name_field = table.getClass().getDeclaredField("name");
            name_field.setAccessible(true);
            Assertions.assertEquals("Alfonso", name_field.get(table), "L'attributo name non è stato inizializzato correttamente ");

            changeName_Method.invoke(table, "Albicocco");
            Assertions.assertEquals("Albicocco", name_field.get(table), "L'attributo name non è stato cambiato correttamente");

            changeName_Method.invoke(table, new Object[]{ null });
            Assertions.assertEquals("INVALID", name_field.get(table), "L'attributo name se è null dovrebbe essere INVALID");

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'changeName' non esiste");
            return;
        } catch (InstantiationException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(TableTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        result = "\t\t[SUCCESS][+2.0]" + BREAKLINE;
        vote += 2.0f;
    }

}
