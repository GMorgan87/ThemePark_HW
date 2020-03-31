import attractions.Attraction;
import people.Visitor;
import behaviours.IReviewed;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<IReviewed> attractionsAndStalls;
    private String name;

    public ThemePark(String name){
        this.name = name;
        this. attractionsAndStalls = new ArrayList<IReviewed>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return attractionsAndStalls;
    }

    public void addAttraction(IReviewed attraction){
        attractionsAndStalls.add(attraction);
    }

    public int numberOfAttractions(){
        return getAllReviewed().size();
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.visit(attraction);
        attraction.addVisit();
    }
}
