import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.DesignPanel;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class PanelToXmlTest {
    @Test
    public void testPanelToXml() throws FileNotFoundException, ClassNotFoundException {
        DesignPanel panel = new DesignPanel();
        panel.addComponent("javax.swing.JButton", "hello", 50, 50, 50, 50);
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("test.xml")));
        e.writeObject(panel);
        e.close();
    }

    @Test
    public void testPanelFromXml() throws FileNotFoundException {
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("test.xml")));
        DesignPanel panel = (DesignPanel) d.readObject();
        JButton button = (JButton) panel.getComponentList().get(0);
        Assert.assertEquals("hello", button.getText());
    }
}
