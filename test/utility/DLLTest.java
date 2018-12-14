/**
 * 
 */
package utility;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import linkedList.DLL;

/**
 * @author Omar Villanueva
 *
 */
class DLLTest extends DLL {
	DLL list;
	String a, b, c, d, e;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new DLL();
		a = "A";
		b = "B";
		c = "C";
		d = "D";
		e = "E";
	}

	/**
	 * Test method for {@link linkedList.DLL#append(java.lang.Object)}.
	 * Append to an empty list
	 */
	@Test
	void testAppendObject1() {
		assertTrue(list.append(a));
		assertEquals(1, list.size());
		assertEquals(a, list.getLast());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#append(java.lang.Object)}.
	 *  Multiple append to an empty list
	 */
	@Test
	void testAppendObject2() {
		assertTrue(list.append(a));
		assertTrue(list.append(b));
		assertTrue(list.append(c));
		assertEquals(3, list.size());
		assertEquals(c, list.getLast());
	}

	/**
	 * Test method for {@link linkedList.DLL#add(java.lang.Object)}.
	 * Add to an empty list
	 */
	@Test
	void testAddObject1() {
		assertTrue(list.append(a));
		assertEquals(1, list.size());
		assertEquals(a, list.getLast());
		assertEquals(a, list.get());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#add(java.lang.Object)}.
	 * Multiple Add to an empty list
	 */
	@Test
	void testAddObject2() {
		assertTrue(list.append(a));
		assertTrue(list.append(b));
		assertTrue(list.append(c));
		assertEquals(3, list.size());
		assertEquals(a, list.get());
	}

	/**
	 * Test method for {@link linkedList.DLL#add(java.lang.Object, int)}.
	 * add(indx) to an empty list
	 */
	@Test
	void testAddObjectInt1() {
		assertEquals(true,list.add(a,0));
		assertEquals(1, list.size());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#add(java.lang.Object, int)}.
	 * Multiple add(indx) to an empty list
	 */
	@Test
	void testAddObjectInt2() {
		list.append(b);
		list.append(c);
		list.append(d);
		assertEquals(true,list.add(a,1));
		assertEquals("[B, A, C, D]",list.toString());
		assertEquals(true,list.add(e,2));
		assertEquals("[B, A, E, C, D]",list.toString());
		assertEquals(true,list.add(b,4));
		assertEquals("[B, A, E, C, B, D]",list.toString());
		assertEquals(6,list.size());
	}

	/**
	 * Test method for {@link linkedList.DLL#clear()}.
	 */
	@Test
	void testClear() {
		list.add(a);
		list.add(a);
		list.add(a);
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
	}
	/**
	 * Test method for {@link linkedList.DLL#remove()}.
	 * Remove from an empty list
	 */
	@Test
	void testRemove1() {
		list.append(a);
		assertEquals(a,list.remove());
		assertEquals(null,list.remove());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#remove()}.
	 * Remove from a non empty list
	 */
	@Test
	void testRemove2() {
		list.append(a);
		list.append(b);	
		assertEquals("A", list.remove());
		assertEquals(1, list.size());
		assertEquals("[B]",list.toString());
		assertEquals("B", list.remove());
		assertEquals(0, list.size());
	}
	/**
	 * Test method for {@link linkedList.DLL#removeLast()}.
	 * RemoveLast from an empty list
	 */
	@Test
	void testRemoveLast1() {
		assertEquals(null, list.removeLast());
		assertEquals(0, list.size());
		assertEquals("[]",list.toString());
	}
	/**
	 * Test method for {@link linkedList.DLL#removeLast()}.
	 * RemoveLast from a non empty list 
	 */
	@Test
	void testRemoveLast2() {
		list.append(b);//1
		list.append(c);	//2
		list.append(d);	//3
		assertEquals("D", list.removeLast());
		assertEquals(2, list.size());
		assertEquals("[B, C]",list.toString());
		assertEquals("C", list.removeLast());
		assertEquals(1, list.size());
	}

	/**
	 * Test method for {@link linkedList.DLL#remove(int)}.
	 * RemoveInt from a empty list
	 */
	@Test
	void testRemoveInt1() {
//		assertThrows(IndexOutOfBoundsException.class, list.remove(1));
		assertEquals(0, list.size());
		assertEquals("[]",list.toString());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#remove(int)}.
 	 * RemoveInt from a non empty list 
	 */
	@Test
	void testRemoveInt2() {
		list.append(c);	
		list.append(d);	
		list.append(e);
		assertEquals(e, list.remove(2));
		assertEquals(d, list.remove(1));
		assertEquals("[C]",list.toString());
		assertEquals(1, list.size());
		assertEquals(c, list.remove(0));
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link linkedList.DLL#get()}.
	 * Get from an empty list
	 */
	@Test
	void testGet1() {
		assertEquals(null, list.get());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#get()}.
	 * Multiple Get from a non empty list
	 */
	@Test
	void testGet2() {
		list.append(b);//1
		list.append(c);	//2
		list.append(d);	//3
		assertEquals("B", list.get());
		list.remove();
		assertEquals("C", list.get());
	}

	/**
	 * Test method for {@link linkedList.DLL#getLast()}.
	 * GetLast from an empty list
	 */
	@Test
	void testGetLast1() {
		assertEquals(null, list.getLast());
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link linkedList.DLL#getLast()}.
	 * multiple GetLast from a non empty list
	 */
	@Test
	void testGetLast2() {
		list.append(b);//1
		list.append(c);	//2
		list.append(d);	//3
		assertEquals("D", list.getLast());
		list.removeLast();
		assertEquals("C", list.getLast());
	}

	/**
	 * Test method for {@link linkedList.DLL#get(int)}.
	 * Get int from a non empty list
	 */
	@Test
	void testGetInt2() {
		list.append(a);//0
		assertEquals("A", list.get(0));
		list.append(b);//1
		assertEquals("B", list.get(1));
		list.append(c);	//2
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		list.append(d);	//3
		assertEquals("D", list.get(3));
	}

	/**
	 * Test method for {@link linkedList.DLL#set(java.lang.Object, int)}.
	 */
	@Test
	void testSet() {
		list.append(a);//0
		assertEquals("A", list.set("Z",0));
		list.append(b);//1
		assertEquals("B", list.set("X",1));
		list.append(c);	//2
		assertEquals("C", list.set("Y",2));
		assertEquals("[Z, X, Y]",list.toString());
		assertEquals("Y", list.set(c,2));
		assertEquals("Z", list.set(a,0));
		assertEquals("X", list.set(b,1));
		assertEquals("[A, B, C]",list.toString());
	}

	/**
	 * Test method for {@link linkedList.DLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		list.append(a);//0
		list.append(b);//1
		list.append(c);	//2
		list.append(d);	//3
		assertEquals(true, list.contains("C"));
		assertEquals(true, list.contains(d));
		assertEquals(false, list.contains("x"));
		assertEquals(true, list.contains(a));
	}

	/**
	 * Test method for {@link linkedList.DLL#indexOf(java.lang.Object)}.
	 */
	@Test
	void testIndexOf() {
		list.append(a);//0
		list.append(b);//1
		list.append(c);	//2
		list.append(d);	//3
		assertEquals(2, list.indexOf("C"));
		assertEquals(3, list.indexOf(d));
		assertEquals(-1, list.indexOf("x"));
		assertEquals(0, list.indexOf(a));
	}

	/**
	 * Test method for {@link linkedList.DLL#size()}.
	 */
	@Test
	void testSize() {
		assertEquals(0, list.size());
		list.append(b);//1
		list.append(c);	//2
		assertEquals(2, list.size());
	}

	/**
	 * Test method for {@link linkedList.DLL#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertEquals(true,list.isEmpty());
		list.append(a);
		assertEquals(false,list.isEmpty());
	}

	/**
	 * Test method for {@link linkedList.DLL#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("[]",list.toString());
		list.append(a);
		list.append(b);
		list.append(c);
		list.append(d);
		assertEquals(4,list.size());
		assertEquals("[A, B, C, D]",list.toString());
	}

	/**
	 * Test method for {@link linkedList.DLL#append(java.util.ArrayList)}.
	 */
	@Test
	void testAppendArrayListOfObject() {
		ArrayList<Object> arr = new ArrayList<Object>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		arr.add(d);
		list.append(a);
		list.append(b);
		list.append(c);
		assertEquals(4,list.append(arr));
	}

	/**
	 * Test method for {@link linkedList.DLL#getList()}.
	 */
	@Test
	void testGetList() {
		list.append(a);
		list.append(b);
		list.append(c);
		ArrayList arr=list.getList();
		assertEquals("[A, B, C]",arr.toString());
		
	}

}
