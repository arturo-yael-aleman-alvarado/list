package uaslp.objetos.list.hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotSuchElementException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class HashSetTest {

    @Test
    public void givenANewHashSet_whenTheSizeIsInitial(){
        //Given:
        HashSet<String> hashSet = new HashSet<>();

        //When:
        int size = hashSet.size();

        //Then:
        Assertions.assertEquals(0,size,"Size of list after creation must be zero.");
    }

    @Test
    public void givenAHashSet_withTwoEqualElements_thenAddOnlyElement() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        HashSet<String> hashSet = new HashSet<>();

        //When:
        hashSet.add("Ruta");
        hashSet.add("Ruta");

        //Then:
        int size = hashSet.size();
        Assertions.assertEquals(1, size);
        Assertions.assertTrue(hashSet.contains("Ruta"));
    }

    @Test
    public void givenANewHashSet_addOneElement() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        HashSet<String> hashSet = new HashSet<>();

        //When:
        hashSet.add("Hola");

        //Then:
        int size = hashSet.size();
        Assertions.assertEquals(1, size);
        Assertions.assertTrue(hashSet.contains("Hola"));
    }

    @Test
    public void givenANewHashSet_addThreeElements_verifyIfOneElementExists() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        HashSet<String> hashSet = new HashSet<>();

        //When:
        hashSet.add("Adios");
        hashSet.add("Mundo");
        hashSet.add("Cruel");

        //Then:
        int size = hashSet.size();
        Assertions.assertEquals(3, size);
        Assertions.assertFalse(hashSet.contains("Hola"));
    }

    @Test
    public void givenASetWithThreeElements_whenGetIterator_thenIterator() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");
        hashSet.add("Mundo");
        hashSet.add("Cruel");

        //When
        Iterator<String> iterator = hashSet.iterator();

        //Then
        int size = hashSet.size();
        HashSet<String> iterations = new HashSet<>();

        Assertions.assertEquals(3, size);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertTrue(hashSet.contains("Hola"));
        Assertions.assertTrue(hashSet.contains("Mundo"));
        Assertions.assertTrue(hashSet.contains("Cruel"));
        Assertions.assertThrows(NotSuchElementException.class, iterator::next);
    }

    @Test
    public void givenASetWithTwoElements_whenGetIterator_thenIterator() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");
        hashSet.add("Mundo");

        //When
        Iterator<String> iterator = hashSet.iterator();

        //Then
        int size = hashSet.size();
        HashSet<String> iterations = new HashSet<>();

        Assertions.assertEquals(2, size);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertTrue(hashSet.contains("Hola"));
        Assertions.assertTrue(hashSet.contains("Mundo"));
        Assertions.assertThrows(NotSuchElementException.class, iterator::next);
    }

    @Test
    public void givenAHashSetWithTwoElements_whenRemoveOneElement_thenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hola");
        hashSet.add("Mundo");

        //When:
        hashSet.remove("Hola");

        //Then:
        int size = hashSet.size();
        Assertions.assertEquals(1,size);
    }

    @Test
    public void givenASetWithOneElement_whenRemove_thenSizeIsZero() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Adios");

        //When
        hashSet.remove("Adios");

        //Then
        int size = hashSet.size();
        Assertions.assertEquals(0, size);
        Assertions.assertFalse(hashSet.contains("Adios"));
    }

    @Test
    public void givenANewHashSet_add200Elements_andReorganize() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given
        HashSet<String> hashSet = new HashSet<>();
        int i=0;
        while(i<100){
            hashSet.add("->: " + i);
            i++;
        }

        //when
        Iterator<String> iterator = hashSet.iterator();

        //Then
        int size = hashSet.size();
        HashSet<String> iterations = new HashSet<>();
        Assertions.assertEquals(100, size);
        Assertions.assertNotNull(iterator);
        while(iterator.hasNext()){
            iterations.add(iterator.next());
        }
        i=0;
        while(i<100){
            Assertions.assertTrue(hashSet.contains("->: " + i));
            i++;
        }
    }
}
