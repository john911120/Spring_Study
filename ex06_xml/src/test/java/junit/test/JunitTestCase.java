package junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.test.main.JunitMain;

public class JunitTestCase {

    JunitMain jm;
	 @BeforeClass
	 public static void setUpBeforeClass() throws Exception {
	  System.out.println("setUpBeforeClass()");
	 }
	 @AfterClass
	 public static void tearDownAfterClass() throws Exception {
	  System.out.println("tearDownAfterClass()");
	 }
	 @Before
	 public void setUp() throws Exception {
	  System.out.println("setUp()");
	 }
	 @After
	 public void tearDown() throws   Exception {
	  System.out.println("tearDown()");
	 }
	 @Test
	 public void test() {
		 jm = new JunitMain();
		 assertEquals(3, jm.add(1, 2));
     }
	 @Test
	 public void test2() {
		 jm = new JunitMain();
		 assertSame(3, jm.add(1, 2));
	 }
	 
//	 assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
//	 assertEquals(a,b) : 객체 a와b의 값이 같은지 확인
//	 assertSame(a,b) : 객체 a와b가 같은 객체임을 확인
//	 assertTrue(a) : a가 참인지 확인
//	 assertNotNull(a) : a객체가 null이 아님을 확인
}
