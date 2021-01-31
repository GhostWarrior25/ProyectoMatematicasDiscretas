/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomatematicasdiscretas.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luidbrav
 */
public class Prueba {

    public static ArrayList<Pregunta> obtenerPreguntasTema(String tema) throws IOException, ClassNotFoundException {
        ArrayList<Pregunta> preg;
        ArrayList<Pregunta> pregMezcladas = new ArrayList();
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream("src/recursos/datos/Datos.dat"))) {
            preg = (ArrayList<Pregunta>) file.readObject();

            for (Pregunta P : preg) {
                if (P.getTema().equals(tema)) {
                    pregMezcladas.add(P);
                }
            }
            Collections.shuffle(pregMezcladas);
        }
        System.out.println("tamaño de lista a ingresar(tema): " + pregMezcladas.size());
        return pregMezcladas;
    }

    public static ArrayList<Pregunta> obtenerPreguntasDificultad(String dificultad) throws IOException, ClassNotFoundException {
        ArrayList<Pregunta> preg;
        ArrayList<Pregunta> pregMezcladas = new ArrayList();
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream("src/recursos/datos/Datos.dat"))) {
            preg = (ArrayList<Pregunta>) file.readObject();

            for (Pregunta P : preg) {
                if (P.getDificultad().equals(dificultad)) {
                    pregMezcladas.add(P);
                }
            }
            System.out.println("tamaño de lista a ingresar(deif): " + pregMezcladas.size());
            Collections.shuffle(pregMezcladas);
        }
        return pregMezcladas;
    }

    /*public static void cargarPreguntasPrueba() {
        ArrayList<Pregunta> listaPreg = new ArrayList();

        //Pregunta 1
        ArrayList<String> opciones = new ArrayList();
        String enunciado1 = "En los polos el frío es intenso únicamente si los planetas giran en torno al sol. ";
        String opcionA = "p → q";
        String opcionB = "q ∨ p";
        String opcionC = "p ∧ q";
        String opcionD = "¬ p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg1 = new Pregunta(enunciado1, opciones, "p → q", "Facil ", "Operadores Logico ");
        listaPreg.add(preg1);

        //Pregunta 2
        opciones = new ArrayList();
        String enunciado2 = "Siempre que los herbívoros corren o el frío en los polos es intenso, los planetas giran en torno al sol.";
        opcionA = "p ∨ q ∧ r ";
        opcionB = "p ∧ q ∧ r";
        opcionC = "p ∧ q ∧ r";
        opcionD = "r →p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg2 = new Pregunta(enunciado2, opciones, "p ∨ q → r", "Media ", "Operadores Logico ");
        listaPreg.add(preg2);

        //Pregunta 3    
        opciones = new ArrayList();
        String enunciado3 = "No vi la película, pero leí la novela.";
        opcionA = "p → q";
        opcionB = "¬ p ∧ q";
        opcionC = "q ∨ ¬p";
        opcionD = "p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg3 = new Pregunta(enunciado3, opciones, "¬ p ∧ q", "Facil ", "Preposiciones ");
        listaPreg.add(preg3);

        //Pregunta 4;
        opciones = new ArrayList();
        String enunciado4 = "Ni vi la película ni leí la novela. ";
        opcionA = "¬p → q";
        opcionB = "q ∨ ¬p";
        opcionC = "p ∧ q";
        opcionD = "¬ p ∧ ¬q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg4 = new Pregunta(enunciado4, opciones, "¬ p ∧ ¬q", "Facil ", "Operadores Logico ");
        listaPreg.add(preg4);

        //Pregunta 5
        opciones = new ArrayList();
        String enunciado5 = "No es cierto que viese la película y leyese la novela. ";
        opcionA = "¬p → q";
        opcionB = "q ∨ ¬p";
        opcionC = "p ∧ q";
        opcionD = "¬ (p ∧ q)";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg5 = new Pregunta(enunciado5, opciones, "¬ (p ∧ q)", "Media ", "Operadores Logico ");
        listaPreg.add(preg5);

        //Pregunta 6
        opciones = new ArrayList();
        String enunciado6 = "Vi la película aunque no leí la novela";
        opcionA = "¬p → q";
        opcionB = "q ∨ ¬p";
        opcionC = "p ∧ ¬ q";
        opcionD = "¬ (p ∧ q)";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg6 = new Pregunta(enunciado6, opciones, "p ∧ ¬ q", "Facil ", "Operadores Logico ");
        listaPreg.add(preg6);

        //Pregunta 7
        opciones = new ArrayList();
        String enunciado7 = "No me gusta trasnochar ni madrugar";
        opcionA = "¬p → q";
        opcionB = "q ∨ ¬p";
        opcionC = "p ∧ q";
        opcionD = "¬ p ∧ ¬q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg7 = new Pregunta(enunciado7, opciones, "¬ p ∧ ¬q ", "Facil ", "Operadores Logico ");
        listaPreg.add(preg7);

        //Pregunta 8
        opciones = new ArrayList();
        String enunciado8 = "O estás equivocado o es falsa la noticia que has leído";
        opcionA = "p → q";
        opcionB = "¬ p ∧ q";
        opcionC = "p ∨ q";
        opcionD = "p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg8 = new Pregunta(enunciado8, opciones, "p ∨ q", "Facil ", "Operadores Logico ");
        listaPreg.add(preg8);

        //Pregunta 9
        opciones = new ArrayList();
        String enunciado9 = "Si no estuvieras loca, no habrías venido aquí.";
        opcionA = "¬p →¬ q";
        opcionB = "q ∨ ¬p";
        opcionC = "p ∧ q";
        opcionD = "¬ p ∧ ¬q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg9 = new Pregunta(enunciado9, opciones, "¬p →¬ q", "Facil ", "Preposiciones ");
        listaPreg.add(preg9);

        //Pregunta 10
        opciones = new ArrayList();
        String enunciado10 = "Llueve y o bien nieva o sopla el viento.";
        opcionA = "(p ∨ q) ∧ r";
        opcionB = "p ∧ (q ∨ r)";
        opcionC = "(p ∨ q) → r";
        opcionD = "r →p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg10 = new Pregunta(enunciado10, opciones, "p ∧ (q ∨ r)", "Media ", "Operadores Logico ");
        listaPreg.add(preg10);

        //Pregunta 11
        opciones = new ArrayList();
        String enunciado11 = "O está lloviendo y nevando o está soplando el viento.";
        opcionA = "p ∨ q ∧ r";
        opcionB = "(p ∧ q) ∨ r";
        opcionC = "(p ∨ q) → r";
        opcionD = "r →p ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg11 = new Pregunta(enunciado11, opciones, "(p ∧ q) ∨ r", "Media ", "Operadores Logico ");
        listaPreg.add(preg11);

        //Pregunta 12
        opciones = new ArrayList();
        String enunciado12 = "14.	Si acepto este trabajo o dejo de pintar por falta de tiempo, entonces no realizaré mis sueños. He aceptado el trabajo y he dejado de pintar. Por lo tanto, no realizaré mis sueños.";
        opcionA = "(p ∨ q) → ¬ r, (p ∧ q) → ¬ r";
        opcionB = "(p ∨ ¬ q) → ¬ r, (¬p ∧ q) → ¬ r";
        opcionC = "(p ∨ q) → r, (p ∧ ¬q) → r";
        opcionD = "(p ∨ q) → r, (¬p ∧ q) → r";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg12 = new Pregunta(enunciado12, opciones, "(p ∨ q) → ¬ r, (p ∧ q) → ¬ r", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg12);

        //Pregunta 13
        opciones = new ArrayList();
        String enunciado13 = "Si vamos a Asia, entonces llegaremos hasta la India. Si vamos a Asia entonces, si llegamos hasta la India visitaremos Varanasi. Si vamos a India entonces, si visitamos Varanasi podremos ver el Ganges. Por lo tanto, si vamos a Asia veremos el Ganges.";
        opcionA = "p → q, p∨ (q ∧r), [ q→ (r ∨ s)] → (p→ s)";
        opcionB = "p ∧ q, p→ (q →r), [ q→ (r ∧ s)] → (p ∨ s)";
        opcionC = "p → q, p→ (q →r), [ q→ (r → s)] → (p→ s)";
        opcionD = "p ∨q, p→ (q →r), [ q→ (r ∨ s)] → (p→ s)";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg13 = new Pregunta(enunciado13, opciones, "p → q, p→ (q →r), [ q→ (r → s)] → (p→ s)", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg13);

        //Pregunta 14
        opciones = new ArrayList();
        String enunciado14 = "Todo número entero o es primo o es compuesto. Si es compuesto, es un producto de factores primos, y si es un producto de factores primos, entonces es divisible por ellos. Pero si un número entero es primo, no es compuesto, aunque es divisible por sí mismo y por la unidad, y consiguientemente, también divisible por números primos. Por tanto, todo número entero es divisible por números primos.";
        opcionA = "p ∨q, (q→ r) ∧ (r → s), {[(p→¬q) ∧ (t ∧ u)] → r} → (p ∨ q) →s";
        opcionB = "p →q, (q→¬ r) ∧ (r → s), {[(p→ q) ∧ (t ∧ u)] → r} → (p ∨ q) →s";
        opcionC = "p →q, (q∧¬ r) ∧ (r → s), {[(p→ q) ∧ (t → u)] → r} → (p ∨ q) →s";
        opcionD = "p ∨ q, (q ∨ ¬ r) ∧ (r → s), {[(p→ q) ∧ (t → u)] ∨ r} → (p ∨ q) ∨ s";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg14 = new Pregunta(enunciado14, opciones, "p ∨q, (q→ r) ∧ (r → s), {[(p→¬q) ∧ (t ∧ u)] → r} → (p ∨ q) →s", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg14);

        //Pregunta 15
        opciones = new ArrayList();
        String enunciado15 = "Si la tormenta continúa o anochece, nos quedaremos a cenar o a dormir. Si nos quedamos a cenar o a dormir, no iremos mañana al concierto. Pero sí iremos mañana al concierto. Así pues, la tormenta no continúa.";
        opcionA = "{[(p → ¬ q) → (r ∨ s)] ∧ [(r → ¬s) → ¬t] ∧ t} ∧ p";
        opcionB = "{[(p → q) → (r → ¬ s)] ∧ [(r ∨ s) ∧ t] ∧ t} → ¬p";
        opcionC = "{[(p ∧  q) → (r ∨ s)] ∧ [(r → ¬ s) → ¬t] ∧ t} ∧ p";
        opcionD = "{[(p ∨ q) → (r ∨ s)] ∧ [(r ∨ s) → ¬t] ∧ t} → ¬p";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg15 = new Pregunta(enunciado15, opciones, "{[(p ∨ q) → (r ∨ s)] ∧ [(r ∨ s) → ¬t] ∧ t} → ¬p", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg15);

        //Pregunta 16
        opciones = new ArrayList();
        String enunciado16 = "Si x = 1 e y = 2, entonces z = 3. Si, si y = 2, z = 3 entonces w = 0. x = 1. Por consiguiente, w = 0";
        opcionA = "{[(p ∧ q) → r] ∧ [(q → r) → s] ∧ p} → s";
        opcionB = "{[(p ∧ ¬q) ∧ r] ∧ [(q ∧ r) → s] ∧ p} → p";
        opcionC = "{[(p →¬q) → r] ∧ [(q ∧ r) → s] ∧ p} v p";
        opcionD = "{[(p → q) → r] ∧ [(q ∧ r) → s] ∧ p} ∧ q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg16 = new Pregunta(enunciado16, opciones, "{[(p ∧ q) → r] ∧ [(q → r) → s] ∧ p} → s", "Media ", "Operadores Logico ");
        listaPreg.add(preg16);

        //Pregunta 17
        opciones = new ArrayList();
        String enunciado17 = "Si un triángulo tiene tres ángulos, un cuadrado tiene cuatro ángulos rectos. Un triángulo tiene tres ángulos y su suma vale dos ángulos rectos. Si los rombos tienen cuatro ángulos rectos, los cuadrados no tienen cuatro ángulos rectos. Por tanto los rombos no tienen cuatro ángulos rectos.";
        opcionA = "[(p → q) ∧ (p ∧ r) ∧ (s→ ¬q)] → ¬s";
        opcionB = "[(p ∧ q) ∧ (p ∧ r) ∧ (s ∧ ¬q)] → ¬p";
        opcionC = "[(p v q) ∧ (p ∧ r) ∧ (s ∧ ¬q)] → p";
        opcionD = "[(p → q) ∧ (p v r) ∧ (s v ¬q)] → q";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg17 = new Pregunta(enunciado17, opciones, "[(p → q) ∧ (p ∧ r) ∧ (s→ ¬q)] → ¬s", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg17);

        //Pregunta 18
        opciones = new ArrayList();
        String enunciado18 = "Si no es cierto que se puede ser rico y dichoso a la vez, entonces la vida está llena de frustraciones y no es un camino de rosas. Sí se es feliz, no se puede tener todo. Por consiguiente, la vida está llena de frustraciones.";
        opcionA = "{[¬ (p → q) → (r ∧ ¬s)] ∧ (q ∧¬p)} ∧s";
        opcionB = "{[(p ∧ q) → (r → ¬s)] ∧ (q →¬p)} →r";
        opcionC = "{[ (p →q) → (r ∧ ¬s)] ∧ (q ∧¬p)} →r";
        opcionD = "{[ ¬ (p ∧ q) → (r ∧ ¬s)] ∧ (q →¬p)} →r";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg18 = new Pregunta(enunciado18, opciones, "{[ ¬ (p ∧ q) → (r ∧ ¬s)] ∧ (q →¬p)} →r", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg18);

        //Pregunta 19
        opciones = new ArrayList();
        String enunciado19 = "La vida no tiene cosas así de fuertes o yo te puedo contar cómo es una llama por dentro. Si yo te puedo contar cómo es una llama por dentro, entonces pienso entregarte mi tiempo y pienso entregarte mi fe. No es cierto que piense entregarte mi tiempo y piense entregarte mi fe. Por lo tanto, la vida no tiene cosas así de fuertes.";
        opcionA = "{(¬p ∨ q) → [ q → (r ∧ s)] ∧ ¬ (r ∧ s)} ∧ p";
        opcionB = "{(p ∧ q) → [ q → (r ∧ s)] ∧ ¬ (r ∧ s)} → s";
        opcionC = "{(¬p ∨ q) ∧ [ q → (r ∧ s)] ∧ ¬ (r ∧ s)} → ¬p";
        opcionD = "{(p → q) ∧ [ q → (r ∧ s)] ∧ ¬ (r ∧ s)} ∧ ¬p";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg19 = new Pregunta(enunciado19, opciones, "{(¬p ∨ q) ∧ [ q → (r ∧ s)] ∧ ¬ (r ∧ s)} → ¬p", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg19);

        //Pregunta 20
        opciones = new ArrayList();
        String enunciado20 = "Si el euro está fuerte, el petróleo está barato pero las exportaciones resultan caras. Si Europa se endeuda o la economía no crece, el petróleo no estará barato. La economía crece si y sólo si ni las exportaciones resultan caras ni la inflación aumenta. Por tanto, si la inflación aumenta, el euro no está fuerte.";
        opcionA = "{[ p ∧ (q ∧ r)] ∧ [(s ∨ ¬t) →¬q] ∧ [t ∧ (¬q ∧ ¬u)]} → (u ∧¬p)";
        opcionB = "{[ p → (q → r)] ∧ [(s ∨ ¬t) →¬q] ∧ [t ↔ (¬q ∧ ¬u)]} → (u→¬p)";
        opcionC = "{[ p ∧ (q ∧ r)] ∧ [(s ∨ ¬t) →¬q] ∧ [t ↔ (¬q → ¬u)]} → (u→¬p)";
        opcionD = "{[ p → (q ∧ r)] ∧ [(s ∨ ¬t) →¬q] ∧ [t ↔ (¬q ∧ ¬u)]} → (u→¬p)";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg20 = new Pregunta(enunciado20, opciones, "{[ p → (q ∧ r)] ∧ [(s ∨ ¬t) →¬q] ∧ [t ↔ (¬q ∧ ¬u)]} → (u→¬p)", "Dificil ", "Operadores Logico ");
        listaPreg.add(preg20);

        opciones = new ArrayList<>();
        String enunciado21 = "Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de A^c ";
        String opcionA21 = "{1,3,5,7,9}";
        String opcionB21 = "{1,2,3}";
        String opcionC21 = "{2,4,5,7,9}";
        String opcionD21 = "{1,4,5,6,7}";

        opciones.add(opcionA21);
        opciones.add(opcionB21);
        opciones.add(opcionC21);
        opciones.add(opcionD21);

        Pregunta preg21 = new Pregunta(enunciado21, opciones, "{1,3,5,7,9}", "Facil ", "Conjuntos ");
        listaPreg.add(preg21);
        //pregunta22 
        opciones = new ArrayList();

        String enunciado22 = "Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de B^c ";
        String opcionA22 = "{1,2,3,4}";
        String opcionB22 = "{6,7,8,9,10}";
        String opcionC22 = "{4,5,6,7}";
        String opcionD22 = "{1,5,7,10}";

        opciones.add(opcionA22);
        opciones.add(opcionB22);
        opciones.add(opcionC22);
        opciones.add(opcionD22);

        Pregunta preg22 = new Pregunta(enunciado22, opciones, "{6,7,8,9,10}", "Facil ", "Conjuntos ");
        listaPreg.add(preg22);
        //pregunta23 
        opciones = new ArrayList();
        String enunciado23 = "Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de C^c ";
        String opcionA23 = "{1,2,3,4,5}";
        String opcionB23 = "{6,7,8,9}";
        String opcionC23 = "{2,3,4,6,8,10}";
        String opcionD23 = "{1,2,4,7,8}";

        opciones.add(opcionA23);
        opciones.add(opcionB23);
        opciones.add(opcionC23);
        opciones.add(opcionD23);

        Pregunta preg23 = new Pregunta(enunciado23, opciones, "{2,3,4,6,8,10}", "Facil ", "Conjuntos ");
        listaPreg.add(preg23);

        //pregunta24 
        opciones = new ArrayList();
        String enunciado24 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de U^c ";
        String opcionA24 = "{1,2,3,4,5}";
        String opcionB24 = "{6,7,8,9}";
        String opcionC24 = "{2,3,4,6,8,10}";
        String opcionD24 = "∅";

        opciones.add(opcionA24);
        opciones.add(opcionB24);
        opciones.add(opcionC24);
        opciones.add(opcionD24);

        Pregunta preg24 = new Pregunta(enunciado24, opciones, "∅", "Facil ", "Conjuntos ");
        listaPreg.add(preg24);

        //pregunta25 
        opciones = new ArrayList();
        String enunciado25 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de A∪B";
        String opcionA25 = "{1,2,3,4,5,6,8,10}";
        String opcionB25 = "{1,3,5,7,8,9}";
        String opcionC25 = "{2,4,5,6,7,8}";
        String opcionD25 = "{1,2,3,4,5,6,7,8,9,10}";

        opciones.add(opcionA25);
        opciones.add(opcionB25);
        opciones.add(opcionC25);
        opciones.add(opcionD25);

        Pregunta preg25 = new Pregunta(enunciado25, opciones, "{1,2,3,4,5,6,8,10}", "Media ", "Conjuntos ");
        listaPreg.add(preg25);
        //pregunta26
        opciones = new ArrayList();
        String enunciado26 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de A∩B";
        String opcionA26 = "{1,2,3}";
        String opcionB26 = "{2,4}";
        String opcionC26 = "{5,10}";
        String opcionD26 = "{2,4,5}";

        opciones.add(opcionA26);
        opciones.add(opcionB26);
        opciones.add(opcionC26);
        opciones.add(opcionD26);

        Pregunta preg26 = new Pregunta(enunciado26, opciones, "{2,4}", "Media ", "Conjuntos ");
        listaPreg.add(preg26);
        //pregunta27
        opciones = new ArrayList();
        String enunciado27 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de A-B";
        String opcionA27 = "{2,4}";
        String opcionB27 = "{1,5,10}";
        String opcionC27 = "{2,4,6,8,10}";
        String opcionD27 = "{3,8}";

        opciones.add(opcionA27);
        opciones.add(opcionB27);
        opciones.add(opcionC27);
        opciones.add(opcionD27);

        Pregunta preg27 = new Pregunta(enunciado27, opciones, "{2,4,6,8,10}", "Media ", "Conjuntos ");
        listaPreg.add(preg27);

        //pregunta28
        opciones = new ArrayList();
        String enunciado28 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de B-A";
        String opcionA28 = "{3,5,9,10}";
        String opcionB28 = "{1,3,5,6,7,8}";
        String opcionC28 = "{1,2,5,9,10}";
        String opcionD28 = "{1,2,3,4,5}";

        opciones.add(opcionA28);
        opciones.add(opcionB28);
        opciones.add(opcionC28);
        opciones.add(opcionD28);

        Pregunta preg28 = new Pregunta(enunciado28, opciones, "{1,2,3,4,5}", "Media ", "Conjuntos ");
        listaPreg.add(preg28);

        //pregunta29
        opciones = new ArrayList();
        String enunciado29 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de A∆B";
        String opcionA29 = "{1,3,5,6,8,10}";
        String opcionB29 = "{1,2,3,5}";
        String opcionC29 = "{6,7,8,9}";
        String opcionD29 = "{1,2,3,4}";

        opciones.add(opcionA29);
        opciones.add(opcionB29);
        opciones.add(opcionC29);
        opciones.add(opcionD29);

        Pregunta preg29 = new Pregunta(enunciado29, opciones, "{1,3,5,6,8,10}", "Dificil ", "Conjuntos ");
        listaPreg.add(preg29);

        //pregunta30
        opciones = new ArrayList();
        String enunciado30 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de B∆C";
        String opcionA30 = "{1,2,4,7,9}";
        String opcionB30 = "{1,2,3,5,7,8}";
        String opcionC30 = "{3,4,5,7,8}";
        String opcionD30 = "{3,4,5,7,9}";

        opciones.add(opcionA30);
        opciones.add(opcionB30);
        opciones.add(opcionC30);
        opciones.add(opcionD30);

        Pregunta preg30 = new Pregunta(enunciado30, opciones, "{1,3,4,7,9}", "Dificil ", "Conjuntos ");
        listaPreg.add(preg30);
        //pregunta31
        opciones = new ArrayList();
        String enunciado31 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de B-(A∪C)";
        String opcionA31 = "{6,7,8,9,10}";
        String opcionB31 = "{5,6,7,8,9}";
        String opcionC31 = "{1,2,3,4,5}";
        String opcionD31 = "{3,4,5,6,7}";

        opciones.add(opcionA31);
        opciones.add(opcionB31);
        opciones.add(opcionC31);
        opciones.add(opcionD31);

        Pregunta preg31 = new Pregunta(enunciado31, opciones, "{6,7,8,9,10}", "Dificil ", "Conjuntos ");
        listaPreg.add(preg31);

        //pregunta32
        opciones = new ArrayList();
        String enunciado32 = " Dado el conjunto u= {1,2,3,4,5,6,7,8,9,10}\n"
                + "A= {2,4,6,8,10}\n"
                + "B= {1,2,3,4,5}\n"
                + "C= {1,3,5,7,9}Seleccione la opcioon correcta de  (A∩B)-C";
        String opcionA32 = "{1,2,3,4,5,7,9}";
        String opcionB32 = "{2,4}";
        String opcionC32 = "{1,3,4,6,7}";
        String opcionD32 = "{2,5,6,8}";

        opciones.add(opcionA32);
        opciones.add(opcionB32);
        opciones.add(opcionC32);
        opciones.add(opcionD32);

        Pregunta preg32 = new Pregunta(enunciado32, opciones, "{6,7,8,9,10}", "Dificil ", "Conjuntos ");
        listaPreg.add(preg32);

        //Pregunta 37
        opciones = new ArrayList();
        String enunciado37 = "Indique cual de las siguientes opciones contiene propiedades de Relaciones: ";
        opcionA = "Conmutativa, reflexiva, transitiva";
        opcionB = "Antisimétrica, reflexiva, distributiva";
        opcionC = "Reflexiva, antisimétrica, transitiva";
        opcionD = "Reflexiva, antisimétrica, asociativa";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg37 = new Pregunta(enunciado37, opciones, "Reflexiva, antisimétrica, transitiva", "Facil ", "Relaciones ");
        listaPreg.add(preg37);

        //Pregunta 38
        opciones = new ArrayList();
        String enunciado38 = "A que propiedad pertenece la siguiente definición : Para toda x, y ∈ X, si (x, y) ∈ R y x ≠ y, entonces (y, x) ∉  R";
        opcionA = "Transitiva";
        opcionB = "Antisimétrica";
        opcionC = "Reflexiva";
        opcionD = "Distributiva";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg38 = new Pregunta(enunciado38, opciones, "Antisimétrica", "Facil ", "Relaciones ");
        listaPreg.add(preg38);

        //Pregunta 39   
        opciones = new ArrayList();
        String enunciado39 = "Una manera informativa de visualizar una relación en un conjunto es dibujar su:";
        opcionA = "Digráfica";
        opcionB = "Función";
        opcionC = "Matriz";
        opcionD = "Ninguna de las opciones es correcta";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg39 = new Pregunta(enunciado39, opciones, "Digráfica", "Facil ", "Relaciones ");
        listaPreg.add(preg39);

        //Pregunta 40;
        opciones = new ArrayList();
        String enunciado40 = "Una relación R en un conjunto X se llama orden parcial si R es: ";
        opcionA = "reflexiva, antisimétrica y transitiva";
        opcionB = "reflexiva y antisimétrica";
        opcionC = "reflexiva y transitiva";
        opcionD = "transitiva";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg40 = new Pregunta(enunciado40, opciones, "reflexiva, antisimétrica y transitiva", "Facil ", "Relaciones ");
        listaPreg.add(preg40);

        //Pregunta 41
        opciones = new ArrayList();
        String enunciado41 = "Sea R una relación de X a Y. La inversa de R, denotada por R^(-1) , es la relación de Y a X definida por:";
        opcionA = "R^(-1)={(x,y) | (y,x)∈R";
        opcionB = "R^(-1)={(y,y) | (x,x)∈R";
        opcionC = "R^(-1)={(y,x) | (x,y)∈R";
        opcionD = "R^(-1)={(y,x) | (y,x)∈R";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg41 = new Pregunta(enunciado41, opciones, "R^(-1)={(y,x) | (x,y)∈R", "Media ", "Relaciones ");
        listaPreg.add(preg41);

        //Pregunta 42
        opciones = new ArrayList();
        String enunciado42 = "Sea R_1una relación de X a Y y R_2 una relación de Y a Z. La composición de R_1 y R_2 , denotada por R_2∘R_1 , es la relación de X a Z definida por:";
        opcionA = "R_2∘R_1={(x,z) | (x,x)∈R_1  y (y,z)∈R_2  para alguna y∈Y}";
        opcionB = "R_2∘R_1={(x,z) | (x,y)∈R_1  y (y,z)∈R_1  para alguna y∈Y}";
        opcionC = "R_2∘R_1={(x,z) | (y,x)∈R_1  y (y,z)∈R_2  para alguna y∈Y)}";
        opcionD = "R_2∘R_1={(x,z) | (x,y)∈R_1  y (y,z)∈R_2  para alguna y∈Y})";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg42 = new Pregunta(enunciado42, opciones, "	R_2∘R_1={(x,z)|(x,y)∈R_1  y (y,z)∈R_2  para alguna y∈Y}", "Media ", "Relaciones ");
        listaPreg.add(preg42);

        //Pregunta 43
        opciones = new ArrayList();
        String enunciado43 = "Si se define una relación R de X = {2, 3, 4} a Y = {3, 4, 5, 6, 7} por (x, y) ∈ R si x divide a y se obtiene R = {(2, 4), (2, 6), (3, 3), (3, 6), (4, 4)} El inverso de esta relacion es :";
        opcionA = "R^(-1)={(4,2),(2,6),(3,3),(6,3),(4,4)";
        opcionB = "R^(-1)={(2,2),(6,2),(3,3),(6,3),(4,4)";
        opcionC = "R^(-1)={(4,2),(2,6),(3,3),(3,6),(4,4)";
        opcionD = "R^(-1)={(4,2),(6,2),(3,3),(6,3),(4,4)";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg43 = new Pregunta(enunciado43, opciones, "	R^(-1)={(4,2),(6,2),(3,3),(6,3),(4,4)", "Media ", "Relaciones ");
        listaPreg.add(preg43);

        //Pregunta 44
        opciones = new ArrayList();
        String enunciado44 = "Sean las R_1 y R_2 relaciones en {1, 2, 3, 4} dadas por  R_1 = {(1, 1), (1, 2), (3, 4), (4, 2)}   y  R_2= {(1, 1), (2, 1), (3, 1), (4, 4), (2, 2)}. Los elementos de R_2∘R_1 son:";
        opcionA = "R_2∘R_1= {(1, 1), (1, 2), (2, 1), (2, 2), (1, 3), (3, 2), (4, 2)}";
        opcionB = "R_2∘R_1= {(1, 1), (1, 2), (3, 4), (4, 1), (4, 2)}";
        opcionC = "R_2∘R_1={(1, 1), (1, 2), (2, 1), (2, 2), (3, 1), (3, 2), (4, 2)}";
        opcionD = "R_2∘R_1= {(1, 1), (1, 2), (4, 4), (4, 1), (4, 2)}";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg44 = new Pregunta(enunciado44, opciones, "R_2∘R_1= {(1, 1), (1, 2), (3, 4), (4, 1), (4, 2)}", "Media ", "Relaciones ");
        listaPreg.add(preg44);

        //Pregunta 45
        opciones = new ArrayList();
        String enunciado45 = "La composición de las relaciones  R_1= {(1, 2), (1, 6), (2, 4), (3, 4), (3, 6), (3, 8)}  y  R_2= {(2, u), (4, s), (4, t), (6, t), (8, u)} es:";
        opcionA = "	R_2∘R_1={(1, u), (1, t), (2, s), (2, t), (3, s), (3, t), (3, u)}";
        opcionB = "	R_2∘R_1={(u,1), (1, t), (2, s), (2, t), (3, s), (3, t), (3, u)}";
        opcionC = "	R_2∘R_1={(1, u), (1, t), (2, s), (t,2), (3, s), (3, t), (3, u)}";
        opcionD = "	R_2∘R_1={(u, 1), (t, 1), (s, 2), (t, 2), (s, 3), (t, 3), (u, 3)}";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg45 = new Pregunta(enunciado45, opciones, "	R_2∘R_1={(1, u), (1, t), (2, s), (2, t), (3, s), (3, t), (3, u)}", "Dificil ", "Relaciones ");
        listaPreg.add(preg45);

        //Pregunta 46
        opciones = new ArrayList();
        String enunciado46 = "¿Cómo se denota una clase de equivalencia?";
        opcionA = "{(y, x) | (x, y) ∈ R}";
        opcionB = "{x ∈ X | (x, y) ∈ R para alguna y ∈ Y}";
        opcionC = "{x ∈ X | xRa}";
        opcionD = "{x ∈ X | xRy}";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg46 = new Pregunta(enunciado46, opciones, "{x ∈ X | xRa}", "Dificil ", "Relaciones ");
        listaPreg.add(preg46);

        //Pregunta 47
        opciones = new ArrayList();
        String enunciado47 = "A partir de la matriz de una relación, ¿cómo se puede determinar si la relación es reflexiva?";
        opcionA = " si y sólo si siempre que el elemento i, j en A^2 es diferente de cero, el elemento i,j en A también es diferente de cero";
        opcionB = "si y sólo si su matriz tiene ceros en la diagonal principal";
        opcionC = "si y sólo si su matriz A satisface lo siguiente: Para toda i y j, el elemento ij de A es igual al elemento ji de A";
        opcionD = "si y sólo si su matriz tiene unos en la diagonal principal";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg47 = new Pregunta(enunciado47, opciones, "si y sólo si su matriz tiene unos en la diagonal principal", "Dificil ", "Relaciones ");
        listaPreg.add(preg47);

        //Pregunta 48
        opciones = new ArrayList();
        String enunciado48 = " ¿Cuando una relación R sobre un conjunto X se llama simétrica?";
        opcionA = "Si para toda x, y ∈ X, si (x, y) ∈ R, entonces (y, x) ∉ R.";
        opcionB = "Si para toda x, y ∈ X, si (x, y) ∈ R, entonces (y, x) ∈ R";
        opcionC = "Si para toda x, y ∈ X, si (x, y) ∈ R y x ≠ y, entonces (y, x) € R";
        opcionD = "Si para toda x, y ∈ X, si (x, y) ∈ R y x = y, entonces (y, x) € R";
        opciones.add(opcionA);
        opciones.add(opcionB);
        opciones.add(opcionC);
        opciones.add(opcionD);

        Pregunta preg48 = new Pregunta(enunciado48, opciones, "Si para toda x, y ∈ X, si (x, y) ∈ R, entonces (y, x) ∈ R.", "Dificil ", "Relaciones ");
        listaPreg.add(preg48);

        try {
            File f = new File("src/recursos/datos/Datos.dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listaPreg);
            oos.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("error");
        }
    }*/

}
