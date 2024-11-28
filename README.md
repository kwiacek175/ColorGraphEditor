# Prosty Edytor Kolorowego Grafu

## 1. Opis projektu

Projekt "Prosty Edytor Kolorowego Grafu" jest aplikacją umożliwiającą tworzenie i edytowanie grafów za pomocą interfejsu graficznego. Aplikacja pozwala użytkownikom na dodawanie węzłów i krawędzi do grafu, a także na modyfikowanie ich właściwości, takich jak kolor czy nazwa. Użytkownicy mogą tworzyć zarówno czarne, jak i kolorowe węzły oraz krawędzi, a także zmieniać ich wygląd za pomocą okien dialogowych.

## 2. Narzędzia wykorzystane

Projekt wykorzystuje następujące narzędzia i technologie:

- **Java**: Język programowania, w którym napisano aplikację.
- **Swing**: Biblioteka graficzna do tworzenia interfejsów użytkownika w Javie.
- **JColorChooser**: Komponent Swing do wyboru koloru.
- **Java AWT**: Używana do obsługi zdarzeń myszki i klawiatury oraz rysowania grafiki.

## 3. Struktura projektu
 **Edge.java** – Plik zawiera klasę `Edge`, która reprezentuje krawędź w grafie. Klasa ta przechowuje informacje o dwóch węzłach (punktach), które łączy, oraz o kolorze krawędzi. Zapewnia także metody do modyfikacji koloru i uzyskiwania informacji o połączeniu.

- **Node.java** – Plik zawiera klasę `Node`, która reprezentuje pojedynczy węzeł w grafie. Każdy węzeł przechowuje swoje położenie (współrzędne), nazwę oraz kolor. Oferuje metody do edytowania tych właściwości i rysowania węzła na ekranie.

- **Graph.java** – Plik zawiera klasę `Graph`, która reprezentuje całą strukturę grafu. Utrzymuje listę węzłów i krawędzi, zarządza ich dodawaniem, usuwaniem i edytowaniem. Klasa ta jest odpowiedzialna za logikę manipulacji grafem, jak również za przekazywanie informacji między obiektami `Node` i `Edge`.

- **GraphPanel.java** – Plik zawiera klasę `GraphPanel`, która odpowiada za rysowanie grafu na ekranie. Jest to komponent Swing, który wykorzystuje metody klasy `Graph` do wizualizacji węzłów i krawędzi. Obsługuje także zdarzenia myszy, umożliwiając użytkownikowi interakcję z grafem (dodawanie, edytowanie, usuwanie węzłów i krawędzi).

- **ColorGraphEditor.java** – Plik zawiera klasę `ColorGraphEditor`, która łączy funkcjonalności tworzenia, edytowania i rysowania grafu w jednym interfejsie. Umożliwia użytkownikowi zarządzanie kolorami węzłów i krawędzi oraz interakcję z grafem poprzez wybór kolorów z palety. Zawiera funkcje takie jak zmiana koloru krawędzi i węzłów oraz edycja nazw.

- **GraphWindowDialog.java** – Plik zawiera klasę `GraphWindowDialog`, która zarządza interfejsem graficznym aplikacji. To główne okno programu, które umożliwia dodawanie węzłów, krawędzi, ich edytowanie oraz usuwanie. Zawiera także metody do obsługi zdarzeń, takich jak kliknięcia myszy, wybór kolorów oraz modyfikowanie właściwości grafu.


## 4. Funkcjonalności projektu

Projekt oferuje następujące funkcjonalności:

- **Tworzenie węzłów**: Użytkownicy mogą tworzyć nowe węzły w grafie klikając w wybranym miejscu na obszarze roboczym.
  - Węzły mogą być standardowe (czarne) lub kolorowe, w zależności od wyboru użytkownika.
  - Każdy węzeł może mieć przypisaną nazwę, którą użytkownik może edytować.

- **Tworzenie krawędzi**: Użytkownicy mogą tworzyć krawędzie łączące węzły w grafie.
  - Krawędzie mogą być czarne lub kolorowe, zgodnie z preferencjami użytkownika.

- **Zmienianie kolorów**: Zarówno węzły, jak i krawędzie mogą mieć zmieniany kolor w dowolnym momencie. Użytkownik może wybrać kolor z palety kolorów.

- **Edycja węzłów i krawędzi**: Użytkownicy mogą zmieniać nazwę węzła oraz kolor zarówno węzła, jak i krawędzi za pomocą okien dialogowych.

- **Usuwanie węzłów i krawędzi**: Użytkownicy mogą usuwać istniejące węzły i krawędzie z grafu.

## 5. Używanie aplikacji

1. **Uruchomienie aplikacji**:
   - Skopiuj projekt na swoje lokalne środowisko.
   - Skompiluj pliki źródłowe i uruchom aplikację poprzez plik `Main.java`.

2. **Tworzenie węzłów**:
   - Kliknij prawym przyciskiem myszy na obszarze roboczym, aby wybrać opcję "Create new node".
   - Możesz wybrać, czy węzeł ma być czarny, czy kolorowy. W przypadku kolorowego węzła wybierz odpowiedni kolor z palety.

3. **Tworzenie krawędzi**:
   - Kliknij prawym przyciskiem myszy na węźle, z którego chcesz utworzyć krawędź.
   - Wybierz opcję "Create new edge from this node". Zostanie wyświetlony wybór, czy chcesz utworzyć krawędź czarną, czy kolorową.

4. **Edycja węzłów i krawędzi**:
   - Kliknij prawym przyciskiem myszy na węźle lub krawędzi, aby uzyskać menu kontekstowe.
   - Z menu wybierz opcje zmiany koloru lub nazwy węzła/krawędzi.

5. **Usuwanie węzłów i krawędzi**:
   - Kliknij prawym przyciskiem myszy na węźle lub krawędzi, aby usunąć go z grafu.

6. **Zmiana kolorów**:
   - Możesz zmieniać kolory węzłów i krawędzi w trakcie interakcji, wybierając odpowiednią opcję z menu kontekstowego.
