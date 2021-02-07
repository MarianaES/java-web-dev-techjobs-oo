package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job test_job1;
    private Job test_job2;
    private Job test_job3;
    private Job test_job4;
    private Job test_job5;
    private Job test_job6;

    @Before
    public void createJobObject() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job5 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertTrue((test_job2.getId() - test_job1.getId()) == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().toString());
        assertEquals("Desert", test_job3.getLocation().toString());
        assertEquals("Quality control", test_job3.getPositionType().toString());
        assertEquals("Persistence", test_job3.getCoreCompetency().toString());
        assertTrue(test_job3 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringForBlankLinesBeforeAndAfter() {
        assertTrue(test_job3.toString().startsWith("\n"));
        assertTrue(test_job3.toString().endsWith("\n"));
    }

    @Test
    public void testToStringAllLabels() {
        String expectedString = "\n" +
                                "ID: " + test_job4.getId() + "\n" +
                                "Name: " + "Product tester" + "\n" +
                                "Employer: " + "ACME" + "\n" +
                                "Location: " + "Desert" + "\n" +
                                "Position Type: " + "Quality control" + "\n" +
                                "Core Competency: " + "Persistence" +
                                "\n";
        assertEquals(expectedString, test_job4.toString());
    }

    @Test
    public void testToStringOneFieldEmpty() {
        String expectedString = "\n" +
                "ID: " + test_job5.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(expectedString, test_job5.toString());
    }

    @Test
    public void testToStringAllFieldsEmpty() {
        String expectedString = "OOPS! This job does not seem to exist.";
        assertEquals(expectedString, test_job1.toString());
        assertEquals(expectedString, test_job6.toString());
    }

}
