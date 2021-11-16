package nju.java.logic.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import nju.java.logic.element.Unit;
import nju.java.logic.element.UnitBrother;
import nju.java.logic.element.UnitMonster;
import nju.java.logic.element.UnitWall;

public class UnitCreator {
    public List<Unit> getUnits() throws IOException{
        List<Unit> units = new LinkedList<Unit>();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        InputStream is = UnitCreator.class.getClassLoader().getResource("element/UnitWall.json").openStream();
        UnitWall unitWall = mapper.readValue(is, UnitWall.class);
        units.add(unitWall);

        is = UnitCreator.class.getClassLoader().getResource("element/UnitBrother.json").openStream();
        UnitBrother unitBroter = mapper.readValue(is, UnitBrother.class);
        units.add(unitBroter);

        is = UnitCreator.class.getClassLoader().getResource("element/UnitMonster.json").openStream();
        UnitMonster unitMonster = mapper.readValue(is, UnitMonster.class);
        units.add(unitMonster);
        
        return units;
    }
}
