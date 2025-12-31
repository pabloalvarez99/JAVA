# Common Errors & Solutions

Quick fixes for the most frequent Java errors.

---

## COMPILATION ERRORS

### 1. "cannot find symbol"

```
error: cannot find symbol
   symbol: variable nombre
```

**Causes:**
- Variable not declared
- Typo in variable name
- Variable declared in different scope
- Missing import

**Solutions:**
```java
// WRONG
System.out.println(nombre);

// RIGHT - declare first
String nombre = "Juan";
System.out.println(nombre);

// WRONG - wrong scope
if (true) {
    String msg = "hola";
}
System.out.println(msg);  // ERROR: msg not visible here

// RIGHT
String msg;
if (true) {
    msg = "hola";
}
System.out.println(msg);
```

---

### 2. "class X is public, should be declared in a file named X.java"

```
error: class Ejercicio1 is public, should be declared in a file named Ejercicio1.java
```

**Cause:** Class name doesn't match filename

**Solution:** Rename file or class to match exactly (case-sensitive)

---

### 3. "';' expected"

```
error: ';' expected
   int x = 5
           ^
```

**Cause:** Missing semicolon

**Solution:** Add `;` at end of statement

---

### 4. "incompatible types"

```
error: incompatible types: String cannot be converted to int
   int numero = "123";
```

**Solutions:**
```java
// WRONG
int numero = "123";

// RIGHT - parse string
int numero = Integer.parseInt("123");

// WRONG
String texto = 123;

// RIGHT - convert to string
String texto = String.valueOf(123);
String texto = "" + 123;
```

---

### 5. "method X in class Y cannot be applied to given types"

```
error: method sumar(int,int) cannot be applied to given types
   sumar("1", "2");
```

**Cause:** Wrong argument types or count

**Solution:** Check method signature and pass correct types

---

### 6. "non-static method cannot be referenced from a static context"

```
error: non-static method saludar() cannot be referenced from a static context
```

**Solutions:**
```java
// WRONG
public class Main {
    public void saludar() { }

    public static void main(String[] args) {
        saludar();  // ERROR
    }
}

// RIGHT - make method static
public static void saludar() { }

// RIGHT - create instance
public static void main(String[] args) {
    Main obj = new Main();
    obj.saludar();
}
```

---

### 7. "unreported exception; must be caught or declared to be thrown"

```
error: unreported exception IOException; must be caught or declared to be thrown
```

**Solutions:**
```java
// WRONG
public void leerArchivo() {
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));
}

// RIGHT - try-catch
public void leerArchivo() {
    try {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// RIGHT - throws declaration
public void leerArchivo() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));
}
```

---

## RUNTIME ERRORS

### 8. NullPointerException

```
Exception in thread "main" java.lang.NullPointerException
```

**Cause:** Calling method or accessing field on null object

**Solutions:**
```java
// WRONG
String texto = null;
System.out.println(texto.length());  // NPE

// RIGHT - check for null
if (texto != null) {
    System.out.println(texto.length());
}

// RIGHT - use Optional
Optional.ofNullable(texto)
    .ifPresent(t -> System.out.println(t.length()));

// COMMON TRAP
ArrayList<String> lista = null;
lista.add("hola");  // NPE!

// RIGHT
ArrayList<String> lista = new ArrayList<>();
lista.add("hola");
```

---

### 9. ArrayIndexOutOfBoundsException

```
Exception: ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```

**Cause:** Accessing array index that doesn't exist

**Solutions:**
```java
int[] arr = {1, 2, 3, 4, 5};  // indices 0-4

// WRONG
System.out.println(arr[5]);  // ERROR: index 5 doesn't exist

// WRONG
for (int i = 0; i <= arr.length; i++) {  // <= is wrong
    System.out.println(arr[i]);
}

// RIGHT
for (int i = 0; i < arr.length; i++) {  // < not <=
    System.out.println(arr[i]);
}

// SAFEST
for (int num : arr) {
    System.out.println(num);
}
```

---

### 10. NumberFormatException

```
Exception: NumberFormatException: For input string: "abc"
```

**Cause:** Parsing non-numeric string as number

**Solutions:**
```java
// WRONG
int num = Integer.parseInt("abc");

// RIGHT - validate first
String input = "abc";
try {
    int num = Integer.parseInt(input);
} catch (NumberFormatException e) {
    System.out.println("Invalid number: " + input);
}

// RIGHT - check if numeric
if (input.matches("-?\\d+")) {
    int num = Integer.parseInt(input);
}
```

---

### 11. ConcurrentModificationException

```
Exception: ConcurrentModificationException
```

**Cause:** Modifying collection while iterating

**Solutions:**
```java
// WRONG
for (String s : lista) {
    if (s.equals("remove")) {
        lista.remove(s);  // ERROR during iteration
    }
}

// RIGHT - use Iterator
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    if (it.next().equals("remove")) {
        it.remove();  // Safe removal
    }
}

// RIGHT - use removeIf (Java 8+)
lista.removeIf(s -> s.equals("remove"));
```

---

### 12. StackOverflowError

```
Exception: StackOverflowError
```

**Cause:** Infinite recursion

**Solutions:**
```java
// WRONG - no base case
public int factorial(int n) {
    return n * factorial(n - 1);  // Never stops!
}

// RIGHT - with base case
public int factorial(int n) {
    if (n <= 1) return 1;  // BASE CASE
    return n * factorial(n - 1);
}
```

---

### 13. ClassCastException

```
Exception: ClassCastException: class Dog cannot be cast to class Cat
```

**Cause:** Invalid type casting

**Solutions:**
```java
// WRONG
Animal a = new Dog();
Cat c = (Cat) a;  // ERROR: Dog is not a Cat

// RIGHT - check with instanceof
if (a instanceof Cat) {
    Cat c = (Cat) a;
}

// RIGHT - Java 16+ pattern matching
if (a instanceof Cat c) {
    c.meow();
}
```

---

## LOGIC ERRORS

### 14. Infinite Loop

**Symptom:** Program never terminates

```java
// WRONG - i never changes
int i = 0;
while (i < 10) {
    System.out.println(i);
    // forgot i++
}

// RIGHT
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}

// WRONG - wrong condition
for (int i = 10; i > 0; i++) {  // i++ should be i--
    System.out.println(i);
}
```

---

### 15. Off-by-One Errors

```java
// WRONG - skips first element
for (int i = 1; i < arr.length; i++) { }

// WRONG - includes non-existent element
for (int i = 0; i <= arr.length; i++) { }

// RIGHT
for (int i = 0; i < arr.length; i++) { }
```

---

### 16. String Comparison

```java
// WRONG - compares references, not content
String a = new String("hello");
String b = new String("hello");
if (a == b) { }  // FALSE!

// RIGHT - compares content
if (a.equals(b)) { }  // TRUE

// For null-safe comparison
if (Objects.equals(a, b)) { }
```

---

### 17. Integer Division

```java
// WRONG - integer division truncates
double result = 5 / 2;  // 2.0, not 2.5

// RIGHT - cast to double
double result = (double) 5 / 2;  // 2.5
double result = 5.0 / 2;  // 2.5
```

---

## FILE I/O ERRORS

### 18. FileNotFoundException

```java
// Check file exists
File f = new File("data.txt");
if (!f.exists()) {
    System.out.println("File not found: " + f.getAbsolutePath());
}

// Use correct path
// Relative: from project root
// Absolute: full path
```

### 19. Resource Leak

```java
// WRONG - resource not closed
BufferedReader br = new BufferedReader(new FileReader("file.txt"));
// if exception occurs, br never closed

// RIGHT - try-with-resources (auto-closes)
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // use br
}  // automatically closed here
```

---

## QUICK DEBUGGING TIPS

### Print Everything
```java
System.out.println("Variable x = " + x);
System.out.println("Entering method X");
System.out.println("Loop iteration: " + i);
```

### Check Array Contents
```java
System.out.println(Arrays.toString(arr));
System.out.println(Arrays.deepToString(matrix));  // 2D
```

### Check Collection Contents
```java
System.out.println(lista);  // ArrayList, etc.
System.out.println(mapa);   // HashMap
```

### VS Code Debugger
1. Set breakpoint (click left of line number)
2. Press F5 to debug
3. Step through with F10 (over) or F11 (into)
4. Watch variables in sidebar

---

## ERROR PREVENTION CHECKLIST

- [ ] All variables declared before use
- [ ] All semicolons in place
- [ ] Braces `{}` matched
- [ ] Array indices within bounds (0 to length-1)
- [ ] Objects initialized before use (not null)
- [ ] Correct loop conditions (`<` not `<=` for arrays)
- [ ] Base case in recursive methods
- [ ] Resources closed (use try-with-resources)
- [ ] String comparison with `.equals()` not `==`
- [ ] Exceptions handled or declared
