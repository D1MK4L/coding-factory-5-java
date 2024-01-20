package gr.aueb.cf.ch14;

/**
 * To test the singleton SaintGeorgeKnight
 * embarks on a mission.
 *
 * @author  D1MK4L
 */
public class mission {

    public static void main(String[] args) {
        SaintGeorgeKnight saintGeorgeKnight = SaintGeorgeKnight.getInstance();
        saintGeorgeKnight.embarkOnMission("He ride's his horse and...");
    }
}
