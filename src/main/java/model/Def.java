package model;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Def {
    public String text;
    public String pos;
    public String ts;
    public List<Tr> tr;


}
