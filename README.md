# Injector-1

Injector-1 è un progetto template progettato per gli studenti che desiderano imparare Java e i principi dell'unit testing. È un progetto pratico dove gli studenti possono scrivere codice, eseguire i test e ricevere feedback immediato sul loro lavoro.

## Struttura del Progetto

Il progetto contiene due classi principali su cui lavorare. Ogni classe è annotata con l'annotazione `@Exercise`, che contiene informazioni come il nome dell'esercizio, il tipo di esercizio, e se l'unit test corrispondente è abilitato o meno.

```java
@Exercise(name = "F.1-TABLE", type = ExerciseType.FREE, testEnabled = false)
public class Table {

}
```
## Come clonare il Progetto

Essendo un progetto template, potresti voler clonarlo per iniziare a lavorare sul tuo esercizio. Ecco i passaggi per farlo:

1. Sulla pagina principale del progetto GitHub, clicca sul bottone verde `Use this template`.
2. Dà un nome al tuo nuovo repository e scegli se renderlo pubblico o privato. Clicca su `Create a new repository`.
3. Ora hai una copia del progetto nel tuo account GitHub. Puoi clonare il repository sul tuo computer locale utilizzando il comando `git clone`. Ad esempio, `git clone https://github.com/username/repo.git`, dove `username` è il tuo username di GitHub e `repo` è il nome del tuo nuovo repository.

## Classi dell'Esercizio

Nel progetto, all'interno del package `com.jinjection.basic`, troverete due classi principali su cui lavorare:

- `Monster`
- `Table`

Ogni classe contiene un commento all'inizio con le istruzioni per l'esercizio. Assicurati di leggere attentamente queste istruzioni prima di iniziare a lavorare sulla classe.

## Abilitare i test

La prima cosa che gli studenti devono fare è abilitare la suite di test per la classe su cui stanno lavorando. Questo può essere fatto cambiando il valore dell'attributo `testEnabled` dell'annotazione `@Exercise` a `true`.

## Esecuzione dei test

Una volta abilitati i test, gli studenti possono eseguirli utilizzando Maven da riga di comando. Basta eseguire il seguente comando:

```bash
mvn clean install
```

Questo eseguirà tutti i test abilitati e mostrerà l'output nella console.

## Interpretare l'output dei test

Dopo aver eseguito i test, gli studenti vedranno un output simile al seguente nella console:

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
Test on exercise:F.0-MONSTER is [ENABLED]

[INFO] Running com.jinjection.monster.MonsterTest
[JUnit][Classi e Oggetti][F.0-MONSTER](1/3) Easy: attributo brutality [existence]:      [SUCCESS][+5.0]
[JUnit][Classi e Oggetti][F.0-MONSTER](2/3) Easy: attributo brutality [private]:        [SUCCESS][+5.0]
[JUnit][Classi e Oggetti][F.0-MONSTER](3/3) Easy: attributo brutality [initialization]: [SUCCESS][+3.0]
---------------------------------------------------------------------------------------------------
[JUnit][Classi e Oggetti][F.0-MONSTER](1/2) Easy: attributo nome [existence]:           [SUCCESS][+4.0]
[JUnit][Classi e Oggetti][F.0-MONSTER](2/2) Easy: attributo nome [type]:                [SUCCESS][+3.0]

...
===========================================================
                        YOUR VOTE: 30 e Lode !
===========================================================
```

Questo output mostra il risultato di ogni test unitario. Se un test ha successo, gli studenti vedranno un messaggio di `[SUCCESS]` con un punteggio corrispondente. Se tutti i test hanno successo, l'esercizio può essere considerato completato.

## Completamento dell'esercizio
L'esercizio è considerato completato quando tutte le suite di test attivate sono completate con successo. Ricorda, la pratica rende perfetti, quindi continua a provare e a migliorare il tuo codice!
