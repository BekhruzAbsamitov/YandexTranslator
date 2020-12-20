package model;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Tr {
    public String text;
    public String pos;
    public String gen;
    public List<Syn> syn;
    public List<Mean> mean;
    public List<Ex> ex;
    public String asp;
}
