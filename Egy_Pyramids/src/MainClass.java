package src;

import java.util.List;
import java.io.File;
import java.nio.file.Files;

public class MainClass {
    static String Path = "D:\\k\\iti ai\\1-3\\java\\Java and UML_Amr Elshafey\\pyramids.csv";
    public static void main(String[] args){
        
        PyramidCSVDAO pDAO = new PyramidCSVDAO(Path);
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV();
        
        int i=0;
        for (Pyramid p:pyramids)
        {
           System.out.println("#"+(i++) 
        + " pharaoh Name : "+p.getPharaoh()
        + ", Modern Name : "+p.getModern_name()
        + ", Site : "+p.getSite()
        + ", Height : "+p.getHight());
        
        }
        
    }
    
}
