package fgroupindonesia.swing;

import javax.swing.JComboBox;

/**
 *
 * @author fgroupindonesia
 */
public class ColumnLink {

    private boolean skipMe = true;
    private int positionRef;
    private JComboBox combobox;

    /**
     * @return the positionRef
     */
    public int getPositionRef() {
        return positionRef;
    }

    /**
     * @param positionRef the positionRef to set
     */
    public void setPositionRef(int positionRef) {
        this.positionRef = positionRef;
    }

    /**
     * @return the combobox
     */
    public JComboBox getCombobox() {
        return combobox;
    }

    /**
     * @param combobox the combobox to set
     */
    public void setCombobox(JComboBox combobox) {
        this.combobox = combobox;
    }

    /**
     * @return the skipMe
     */
    public boolean isSkipMe() {
        return skipMe;
    }

    /**
     * @param skipMe the skipMe to set
     */
    public void setSkipMe(boolean skipMe) {
        this.skipMe = skipMe;
    }
    
}
