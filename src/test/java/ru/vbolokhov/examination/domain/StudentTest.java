package ru.vbolokhov.examination.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Student.
 * @author Vadim Bolokhov
 */
public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        this.student = new Student();
    }

    @Test
    public void testSetId() {
        assertEquals(this.student.getId(), 0);
        this.student.setId(10);
        assertEquals(this.student.getId(), 10);
    }

    @Test
    public void testSetFirstname() {
        assertNull(this.student.getFirstname());
        this.student.setFirstname("Test name");
        assertEquals(this.student.getFirstname(), "Test name");
    }

    @Test
    public void testSetLastName() {
        assertNull(this.student.getLastname());
        this.student.setLastname("Last name");
        assertEquals(this.student.getLastname(), "Last name");
    }
}