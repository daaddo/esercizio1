package com.jinjection.basic;

import org.jinjection.ann.ConditionToExecute;
import org.jinjection.ann.Exercise;
import org.junit.jupiter.api.*;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@ConditionToExecute(classToCheck = Monster.class)
class MonsterTest {

    private String message;
    private String result;
    private static float vote = 0;
    private static final String title;
    public static final String UNKNOWN_EXERCIZE = "<UNKNOWN EXERCIZE>";
    private static boolean brutalityExisting = false;
    private static boolean nomeExisting = false;
    private static boolean roarExisting = false;
    private static boolean roarReturnsInt = false;
    private Field fieldBrutality = null;
    private static final String BREAKLINE = "\n---------------------------------------------------------------------------------------------------";

    static {
        Exercise annotation = Monster.class.getAnnotation(Exercise.class);
        title = annotation == null ? UNKNOWN_EXERCIZE : annotation.name();
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
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
    @DisplayName("(1/3) Easy: attributo brutality [existence]")
    void test1a1(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[FAIL]";
        try {
            fieldBrutality = Monster.class.getDeclaredField("brutality");
            Assertions.assertNotNull(fieldBrutality);
            brutalityExisting = true;
        } catch (NoSuchFieldException ex) {
            return;
        } catch (SecurityException ex) {
            return;
        }

        result = "\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("(2/3) Easy: attributo brutality [private]")
    void test1a2(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "\t[SKIPPED]";
        Assumptions.assumeTrue(brutalityExisting);
        result = "\t[FAIL]";
        try {
            fieldBrutality = Monster.class.getDeclaredField("brutality");
            int modifiers = fieldBrutality.getModifiers();
            Assertions.assertTrue(Modifier.isPrivate(modifiers), "la variabile brutality non ha accesso privato.");
            brutalityExisting = true;
        } catch (SecurityException ex) {
            return;
        } catch (NoSuchFieldException ex) {
            return;
        }

        result = "\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("(3/3) Easy: attributo brutality [initialization]")
    void test1a3(TestInfo info) {
        message = "[" + title + "]" + info.getDisplayName();
        result = "[SKIPPED]"+BREAKLINE;;
        Assumptions.assumeTrue(brutalityExisting);
        result = "[FAIL]"+BREAKLINE;;
        try {
            Constructor<Monster> constructor = Monster.class.getConstructor();
            Assertions.assertNotNull(constructor);

            int modifiers = constructor.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il costruttore senza argomenti non è pubblico o non è accessibile");

            Monster monster = constructor.newInstance();
            Field brut_field = monster.getClass().getDeclaredField("brutality");
            brut_field.setAccessible(true);
            Assertions.assertEquals(int.class, brut_field.getType(), "L'attributo non è int. ");

            Assertions.assertEquals(3, brut_field.getInt(monster));

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
            Assertions.assertTrue(false, "attributo brutality non trovato");
            return;
        }

        result = "[SUCCESS][+3.0]"+BREAKLINE;
        vote += 3.0f;
    }

    @Test
    @DisplayName("(1/2) Easy: attributo nome [existence]")
    void test2nome1(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Field nome = Monster.class.getDeclaredField("nome");
            Assertions.assertNotNull(nome);
            nomeExisting = true;

        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "attributo [nome] non trovato");
            return;
        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        }

        result = "\t\t[SUCCESS][+4.0]";
        vote += 4.0f;
    }

    @Test
    @DisplayName("(2/2) Easy: attributo nome [type]")
    void test2nome2(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[SKIPPED]"+BREAKLINE;;
        Assumptions.assumeTrue(nomeExisting);
        result = "\t\t[FAIL]"+BREAKLINE;;

        try {
            Field nome = Monster.class.getDeclaredField("nome");
            Assertions.assertNotNull(nome);

            int modifiers = nome.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "l'attributo 'nome' non è pubblico");

        } catch (NoSuchFieldException ex) {
            Assertions.assertTrue(false, "attributo [nome] non trovato");
            return;
        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        }

        result = "\t\t[SUCCESS][+3.0]"+BREAKLINE;
        vote += 3.0f;
    }

    @Test
    @DisplayName("(1/3) Easy: method roar [existence]")
    void test3method1(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[FAIL]";
        try {
            Method printMethod = Monster.class.getDeclaredMethod("roar", int.class);
            Assertions.assertNotNull(printMethod);
            roarExisting = true;

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'print' non esiste");
            return;
        }

        result = "\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("(2/3) Easy: method roar [return type]")
    void test3method2(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t[SKIPPED]";
        Assumptions.assumeTrue(roarExisting);
//        Assumptions.assumeTrue(printIsString);
        result = "\t\t[FAIL]";
        try {
            Method printMethod = Monster.class.getDeclaredMethod("roar", int.class);
            Assertions.assertNotNull(printMethod);

            int modifiers = printMethod.getModifiers();
            Assertions.assertTrue(Modifier.isPublic(modifiers), "il metodo 'roar' non è pubblico");
            Assertions.assertEquals(int.class, printMethod.getReturnType(), "il metodo non ritorna int");
            roarReturnsInt = true;

        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'print' non esiste");
            return;
        }

        result = "\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }

    @Test
    @DisplayName("(3/3) Easy: method roar [logic]")
    void test3method3(TestInfo info) {

        message = "[" + title + "]" + info.getDisplayName();
        result = "\t\t\t[SKIPPED]";
        Assumptions.assumeTrue(roarExisting);
        Assumptions.assumeTrue(roarReturnsInt);
        Assumptions.assumeTrue(brutalityExisting);
        result = "\t\t\t[FAIL]";
        try {
            Method printMethod = Monster.class.getDeclaredMethod("roar", int.class);
            Assertions.assertNotNull(printMethod);

            Constructor<Monster> constructor = Monster.class.getConstructor();
            Assertions.assertNotNull(constructor);
            Monster monster = constructor.newInstance();
            int returnValue = (int)printMethod.invoke(monster, 8);

            Assertions.assertEquals(24,returnValue,"il metodo non ritorna il valore corretto");


        } catch (SecurityException ex) {
            Assertions.assertTrue(false, "violate le norme di sicurezza");
            return;
        } catch (NoSuchMethodException ex) {
            Assertions.assertTrue(false, "il metodo 'roar' non esiste");
            return;
        } catch (InstantiationException ex) {
            Logger.getLogger(MonsterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MonsterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MonsterTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(MonsterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     result = "\t\t\t[SUCCESS][+5.0]";
        vote += 5.0f;
    }
}