/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovani2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2016-e-prusek
 */
public class MyHistory {

    Path fileName;
    private List<String> arr;

    public MyHistory(String fileName) {
        this.fileName = Paths.get(fileName);
    }

    public void read() throws IOException {
        arr = (ArrayList<String>) Files.readAllLines(fileName);

    }

    public void save() throws IOException {
        if(arr !=null){
        Files.write(fileName, arr);
        }
    }

    public void addLine(String str) {
        if (arr == null) {
            arr = new ArrayList<>();
        }
        if (!arr.contains(str)) {
            arr.add(str);
        }

    }

    @Override
    public String toString() {
        if(arr == null){
            try {
                arr = (ArrayList<String>) Files.readAllLines(fileName);
            } catch (IOException ex) {
                Logger.getLogger(MyHistory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return String.join("\n", arr);
    }}
