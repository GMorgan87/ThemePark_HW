import attractions.DodgemTest;
import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    RollerCoaster rollerCoaster;
    Dodgems dodgems;
    CandyflossStall candyflossStall;
    Visitor visitor;
    TobaccoStall tobaccoStall;

    @Before
    public void before(){
        themePark = new ThemePark("Thorpe Park");
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void canAddAttraction(){
        themePark.addAttraction(rollerCoaster);
        assertEquals(1, themePark.numberOfAttractions());
    }
    @Test
    public void canAddStall(){
        themePark.addAttraction(candyflossStall);
        assertEquals(1, themePark.numberOfAttractions());
    }

    @Test
    public void visitorCanVisitAttraction(){
        themePark.addAttraction(rollerCoaster);
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canGetAllReviews(){
        themePark.addAttraction(rollerCoaster);
        themePark.addAttraction(dodgems);
        themePark.addAttraction(candyflossStall);
        assertEquals(3, themePark.getReviews().size());
        System.out.println(themePark.getReviews());
    }

    @Test
    public void canGetAllAllowedForVisitor(){
        themePark.addAttraction(rollerCoaster);
        themePark.addAttraction(dodgems);
        themePark.addAttraction(candyflossStall);
        themePark.addAttraction(tobaccoStall);
        assertEquals(2, themePark.getAllAllowedFor(visitor).size());
    }

}
