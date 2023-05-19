package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job bob = new Job();
        Job bobby = new Job();
        assertNotEquals(bob, bobby);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job billy = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String nameData = billy.getName();
        Employer employerData = billy.getEmployer();
        Location locationData = billy.getLocation();
        PositionType positionTypeData = billy.getPositionType();
        CoreCompetency coreCompetencyData = billy.getCoreCompetency();

        assertEquals("Product tester", nameData);
        assertEquals("ACME", employerData.getValue());
        assertEquals("Desert", locationData.getValue());
        assertEquals("Quality control", positionTypeData.getValue());
        assertEquals("Persistence", coreCompetencyData.getValue());


        assertTrue(nameData instanceof String);
        assertTrue(employerData instanceof Employer);
        assertTrue(locationData instanceof Location);
        assertTrue(positionTypeData instanceof PositionType);
        assertTrue(coreCompetencyData instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality(){
        Job carl = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job greg = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(carl == greg);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job bobo = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        char firstLine = bobo.toString().charAt(0);
        char lastline = bobo.toString().charAt(bobo.toString().length() - 1);

        assertEquals(firstLine, '\n');
        assertEquals(lastline, '\n');
    }

@Test
public void testToStringContainsCorrectLabelsAndData(){
    Job myJob = new Job("TheDarkKnight", new Employer("God"),
            new Location("Earth"), new PositionType("Controller"),
            new CoreCompetency("Bossness"));

    assertEquals("\nID: " + myJob.getId() + "\nName: TheDarkKnight\nEmployer: God\nLocation: Earth" +
                    "\nPosition Type: Controller\nCore Competency: Bossness\n",
            myJob.toString());
}

    @Test
    public void testToStringHandlesEmptyField(){
        Job blankJob = new Job("TheDarkKnight", new Employer("God"),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));

        assertEquals("\nID: " + blankJob.getId() + "\nName: TheDarkKnight\nEmployer: God\nLocation: Data not available" +
                        "\nPosition Type: Data not available\nCore Competency: Data not available\n",
                blankJob.toString());
    }

}
