package bigProject;

import java.io.*;
import java.util.ArrayList;

public class DSXang {
    public void writeToData(ArrayList<Xang> dsXang) {
        try {
            FileWriter fw = new FileWriter("DSXang.txt");
            for (Xang x: dsXang) {
                fw.write(x.toString() + "\n");
            }
            fw.close();
        } catch ( Exception e) {
        }
    }

    public ArrayList<Xang> FetchXang () {
        ArrayList<Xang> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("DSXang.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                String line = br.readLine();
                if ( line == null)
                    break;
                String txt[] =  line.split(",");
                String id = txt[0];
                String name = txt[1];
                float cost = Float.parseFloat(txt[2]);
                float priceMarket = Float.parseFloat(txt[3]);
                float inventory = Float.parseFloat(txt[4]);
                float sold = Float.parseFloat(txt[5]);
                Xang tempXang = new Xang(id, name, cost, priceMarket, inventory, sold);
                list.add(tempXang);

            }
        } catch (Exception e) {
        }

        return list;
    }
}
