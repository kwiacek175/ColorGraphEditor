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
