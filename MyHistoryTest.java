/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testovani2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 2016-e-prusek
 */
public class MyHistoryTest {

    private MyHistory h;
    Path p;

    public MyHistoryTest() {
    }

    @Before
    public void init() throws IOException {
        p = Files.createTempFile(null, null);
        h = new MyHistory(p.toString());
    }

    @After
    public void reset() {
        File f = new File(p.toString());
        f.delete();
    }

    @Test
    public void write1() {
        h.addLine("ahoj");
        try {
            h.save();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void write0() {
        try {
            h.save();
        } catch (Exception e) {
            fail();

        }
    }

    @Test
    public void write3() {
        h.addLine("ahoj");
        h.addLine("ahoj");
        h.addLine("ahoj");

        try {
            h.save();
        } catch (IOException e) {
            fail();
        }
    }

}
