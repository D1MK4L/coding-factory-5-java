package gr.aueb.cf.ch14;

/**
 * Singleton SaintGeorgeKnight
 * that embarks on  a mission with his horse (clip-et-clop)
 *
 * @author D1MK4L
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight INSTANCE = new SaintGeorgeKnight();

    private SaintGeorgeKnight() {
    }

    public static SaintGeorgeKnight getInstance() { return INSTANCE; }

    /**
     * single message that signals the start of the mission.
     *
     * @author D1MK4L
     * @param message       The message
     */
    public void embarkOnMission(String message) {
        System.out.println("clip-et-clop");
    }
}
