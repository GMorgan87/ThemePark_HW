import attractions.Attraction;
import com.sun.xml.internal.bind.v2.runtime.output.FastInfosetStreamWriterOutput;
import people.Visitor;
import behaviours.IReviewed;
import behaviours.ISecurity;

import java.util.ArrayList;

import java.util.HashMap;

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

    public HashMap<String, Integer> getReviews() {
        HashMap<String, Integer> reviews = new HashMap<String, Integer>();
        for (IReviewed attraction : attractionsAndStalls){
            reviews.put(attraction.getName(), attraction.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allowed = new ArrayList<IReviewed>();
        for (IReviewed attraction : attractionsAndStalls){
            if (attraction instanceof ISecurity){
                if (((ISecurity) attraction).isAllowedTo(visitor)) {
                    allowed.add(attraction);
                    }
            } else {
                allowed.add(attraction);
            }
        }
        return allowed;
    }
}
