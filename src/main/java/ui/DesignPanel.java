package ui;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DesignPanel extends JPanel {
    List<JComponent> componentList;

    public List<JComponent> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<JComponent> componentList) {
        this.componentList = componentList;
    }

    public DesignPanel() {
        componentList = new ArrayList<>();
        setLayout(null);
    }

    public void addComponent(String className, String text, int w, int h, int x, int y) throws ClassNotFoundException {
        try {
            Class clazz = Class.forName(className);
            JComponent component = (JComponent) clazz.newInstance();

            try {
                Method addText = clazz.getMethod("setText", String.class);
                addText.invoke(component, text);
            } catch (NoSuchMethodException ignored) {}
            catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            componentList.add(component);
            add(component);
            component.setBounds(x, y, w, h);
            revalidate();
        } catch(IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
