package com.company;
import org.junit.Test;

import static org.junit.Assert.*;

public class StosTest {

    @Test
    public void test_isEmpty_notUsedStack_returnTrue(){
        //given
        Stos stos = new Stos();
        //when
        assertTrue(stos.isEmpty());
    }

    @Test(expected = Exception.class)
    public void test_pop_notUsedStack_returnException() throws Exception{
        //given
        Stos stos = new Stos();
        //when
        stos.pop();
    }

    @Test(expected = Exception.class)
    public void test_top_notUsedStack_returnException() throws Exception{
        //given
        Stos stos = new Stos();
        //when
        stos.top();
    }

    @Test
    public void test_top_StackContainOneItem_returnTopItem() throws Exception{
        //given
        Stos stos = new Stos();
        String item1 = "String";


        stos.push(item1);
        //when
        assertEquals(item1,stos.top());
        assertEquals(item1,stos.top());
        assertEquals(item1,stos.top());
        assertEquals(item1,stos.top());

        assertFalse(stos.isEmpty());
    }

    @Test(expected = Exception.class)
    public void test_pop_StackContainOneItem_returnLastItem() throws Exception{
        //given
        Stos stos = new Stos();
        String item1 = "String";

        stos.push(item1);

        //when
        assertSame(item1,stos.pop());


        assertTrue(stos.isEmpty());

        stos.pop();
    }
    @Test
    public void test_pop_StackContainFewItems_returnPopItem() throws Exception{
        //given
        Stos stos = new Stos();
        String item1 = "String";
        String item2 = "is";
        String item3 = "on";
        String item4 = "stack";
        stos.push(item1);
        stos.push(item2);
        stos.push(item3);
        stos.push(item4);
        //when
        assertSame(item4,stos.pop());
        assertSame(item3,stos.pop());
        assertSame(item2,stos.pop());
        assertSame(item1,stos.pop());
        assertTrue(stos.isEmpty());
    }

    @Test
    public void test_pop_nullOnStack_returnNull() throws Exception{
        //given
        Stos stos = new Stos();
        stos.push(null);
        //when
        assertNull(stos.pop());
    }

    @Test
    public void test_StackThrowsException_still_working() throws Exception{
        //given
        Stos stos = new Stos();

        try{
            stos.top();
        }catch(Exception e){
            assertEquals(e.getMessage(),"Stack is empty");
        }finally {
            String item1 = "item1";
            String item2 = "item2";
            stos.push(item1);
            //when
            assertFalse(stos.isEmpty());
            assertNotSame(item2,stos.top());
            assertSame(item1,stos.top());
        }
    }



}
