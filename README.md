# ColorGraphEditor

**ColorGraphEditor** to prosty graficzny edytor kolorowego grafu, który umożliwia tworzenie, edytowanie oraz modyfikowanie grafów. Użytkownicy mogą dodawać węzły, krawędzie, zmieniać ich kolory i modyfikować inne właściwości grafu. Program obsługuje również interakcję za pomocą myszki i klawiatury.

## Pliki w projekcie

### `GraphWindowDialog.java`
Klasa `GraphWindowDialog` odpowiada za obsługę okien dialogowych umożliwiających tworzenie i edytowanie węzłów i krawędzi w grafie. Umożliwia dodawanie nowych węzłów oraz krawędzi (zarówno czarnych, jak i kolorowych), jak również ich modyfikowanie (zmiana koloru, usuwanie).

### `GraphPanel.java`
Klasa odpowiedzialna za renderowanie grafu na ekranie. Zawiera logikę rysowania węzłów, krawędzi i umożliwia interakcję z użytkownikiem. Umożliwia kliknięcie węzłów i krawędzi, a także ich przeciąganie. `GraphPanel` jest częścią głównego okna programu, zapewniając płynne wyświetlanie grafu oraz jego edytowanie w czasie rzeczywistym.

### `ColorGraphEditor.java`
Klasa główna aplikacji, która tworzy główne okno programu, zawiera menu oraz zarządza interakcją użytkownika. Umożliwia zapis i odczyt grafów z plików, wyświetlanie listy węzłów i krawędzi oraz pokazywanie informacji o autorze i instrukcji obsługi programu.

### `Edge.java`
Reprezentuje krawędź w grafie. Krawędź łączy dwa węzły i może mieć przypisany kolor.

### `Graph.java`
Klasa zawierająca reprezentację grafu, zarządza zbiorami węzłów i krawędzi.

### `Node.java`
Reprezentuje węzeł w grafie. Węzły mogą mieć przypisane kolory i nazwy.

## Funkcjonalności

1. **Tworzenie grafu**:
   - Użytkownicy mogą tworzyć nowe węzły i krawędzie poprzez kliknięcie prawym przyciskiem myszy na panelu.
   - Węzły mogą być dodawane w dwóch trybach: czarne lub kolorowe. Kolor węzła można wybrać z palety kolorów.
   - Krawędzie mogą być dodawane pomiędzy węzłami i również mogą być kolorowane.

2. **Edycja grafu**:
   - Klikając prawym przyciskiem myszy na węzeł lub krawędź, użytkownik ma możliwość edytowania właściwości obiektu, takich jak:
     - Zmiana koloru węzła lub krawędzi.
     - Zmiana nazwy węzła.
     - Usuwanie węzła lub krawędzi.

3. **Interakcja z myszką**:
   - Program pozwala na interakcję z grafem za pomocą myszy, umożliwiając dodawanie węzłów, tworzenie krawędzi oraz edytowanie ich właściwości poprzez kliknięcia prawym przyciskiem.
   - Węzły i krawędzie mogą być przeciągane i przesuwane na obszarze roboczym.

4. **Interakcja z klawiaturą**:
   - Klawiatura umożliwia szybkie zmienianie kolorów węzłów i krawędzi za pomocą klawiszy: `r`, `g`, `b`, `y`, `c`, `m`, `w` (dla czerwonego, zielonego, niebieskiego, żółtego, cyjanowego, magenta i białego).
   - `DEL` pozwala na usuwanie węzłów i krawędzi.

5. **Menu**:
   - Program zawiera menu umożliwiające zapis i otwieranie grafów z plików, a także wyświetlanie listy węzłów i krawędzi.

6. **Przesuwanie grafu**:
   - Graf można przesuwać za pomocą strzałek na klawiaturze. Użycie `SHIFT` umożliwia szybsze przesuwanie.

## Uruchomienie

Aby uruchomić program, wystarczy skompilować i uruchomić klasę `ColorGraphEditor`. Program stworzy interfejs graficzny, w którym użytkownik może manipulować grafem.

### Wymagania

- Java SE 8 lub nowsza.
- Środowisko z obsługą GUI (np. system operacyjny z obsługą Swing).




## Instrukcja obsługi

W programie dostępne są skróty klawiszowe oraz instrukcja dostępna z menu programu, która szczegółowo wyjaśnia wszystkie operacje.


