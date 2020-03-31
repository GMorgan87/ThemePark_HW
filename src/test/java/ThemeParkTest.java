import attractions.DodgemTest;
import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    RollerCoaster rollerCoaster;
    Dodgems dodgems;
    CandyflossStall candyflossStall;
    Visitor visitor;

    @Before
    public void before(){
        themePark = new ThemePark("Thorpe Park");
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 5);
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

}
