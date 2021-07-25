import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Writing {

//    Create Json obj and write it to file "parsed.json" with Gson library
    public static void writeFile(List<Map> list) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path path = null;
        try {
            path = Paths.get(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        } catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }
        File newFile =  new File(path + File.separator + "parsed.json");
        try (FileWriter fw = new FileWriter(newFile)){
            fw.write(gson.toJson(list));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
