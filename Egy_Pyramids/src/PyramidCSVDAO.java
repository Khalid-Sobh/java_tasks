package src;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

public class PyramidCSVDAO {
    List<Pyramid> Pyramids;
    String Path;
    
    public PyramidCSVDAO(String fileName){
        this.Path = fileName ;
        this.Pyramids = new ArrayList<Pyramid>();
    }
    
    public List<Pyramid> readPyramidsFromCSV(){
        File pyrfile = new File(Path);
        List<String> lines = new ArrayList<String>();
        
        try {
            lines =Files.readAllLines(pyrfile.toPath());
        } catch (Exception e){
            System.out.println( "an issue has been happened during reading " + e);
        }
        for(int index=1 ; index< lines.size() ; index++){
           String record = lines.get(index);
           String[] fields = record.split(",");
           
           Pyramid pyr = createPyramid(fields);
           Pyramids.add(pyr);
        }
        return Pyramids;
        
}
    public Pyramid createPyramid(String[] fields ){
        double height;
        String pharouh = fields[0].trim();
        String modern_name = fields[2].trim();
        String site = fields[4].trim();
        try{
            height = Double.parseDouble(fields[7].trim()); 
            }catch (Exception e ){
             height = -1;
            }
        Pyramid new_pyramid = new Pyramid(pharouh,modern_name,site,height);
        return new_pyramid;
        
        
    }
}
