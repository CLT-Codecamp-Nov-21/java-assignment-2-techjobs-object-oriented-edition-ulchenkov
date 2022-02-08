package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        var job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals(job.getName(), "Product tester");

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");

        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {

        var job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        var job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        var charactersArray = job.toString().toCharArray();
        assertEquals('\n', charactersArray[0]);
        assertEquals('\n', charactersArray[charactersArray.length - 1]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        var expectedString = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(expectedString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        var job = new Job("Product tester", new Employer("ACME"), null,
                new PositionType("Quality control"), new CoreCompetency(""));

        var expectedString = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Data not available\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available\n";

        assertEquals(expectedString, job.toString());
    }

    @Test
    public void testToStringHandlesJobWithOnlyIdField() {
        var job = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }

}
