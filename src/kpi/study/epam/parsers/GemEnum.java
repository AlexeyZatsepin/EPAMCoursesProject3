package kpi.study.epam.parsers;

/**
 * EPAM_Project_3_XML
 * Created 7/13/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public enum GemEnum {
    id("id"),
    gemstone("gemstone"),
    name("name"),
    preciosness("preciosness"),
    origin("origin"),
    visualParameters("visualParameters"),
    color("color"),
    transparency("transparency"),
    verges("verges"),
    value("value");
    private String val;

    GemEnum(String val) {
        this.val = val;
    }

    public String get() {
        return val;
    }
}
