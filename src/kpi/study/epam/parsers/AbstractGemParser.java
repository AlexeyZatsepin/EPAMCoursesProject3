package kpi.study.epam.parsers;

import kpi.study.epam.entity.Gemstone;

import java.util.List;

/**
 * EPAM_Project_3_XML
 * Created 7/14/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public interface AbstractGemParser {

    void buildData(String filename);
    List<Gemstone> getStones();
}
