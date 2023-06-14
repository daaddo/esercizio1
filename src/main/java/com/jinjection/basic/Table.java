package com.jinjection.basic;

import org.jinjection.ann.Exercise;
import org.jinjection.ann.ExerciseType;

/**
 * F.1-TABLE
 * [1] Inserire come attributi privati una stringa per il 'name' del tavolo e due interi, uno per la 'width'
 * e l'altro per la 'height'.
 * [2] Si crei (senza usare le shortcut) il costruttore vuoto
 * [3] Poi si crei il costruttore con tutti gli argomenti (nell'ordine: name, width e height)
 * [4] Si crei poi il costrurreo con solo 'width' e 'height'.
 * [5] Si crei un metodo pubblico 'area' che calcoli l'area del tavolo restituendo semplicemente il prodotto
 * di width * height.
 * [6] Si crei un metodo 'changeName', che permetta, da fuori, di cambiare l'attributo'name', assicurandosi che se
 * il parametro si prova a settare null, il 'name' venga sovrascritto con
 * "INVALID".
 *
 * @author Luca Coraci
 */
@Exercise(name = "F.1-TABLE", type = ExerciseType.FREE, testEnabled = false)
public class Table {

}

