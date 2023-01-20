package fgroupindonesia.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author fgroupindonesia
 */
public class CustomListener implements ActionListener {

    JComboBox myCombo;
    String findBy;
    SimpleFilter sf;
    ColumnLink cl;

    public CustomListener(JComboBox b, SimpleFilter sfNa, ColumnLink clNa) {
        myCombo = b;
        myCombo.addActionListener(this);
        sf = sfNa;
        cl = clNa;
    }

    public String getFindBy() {
        return findBy;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // stored the non dashes value
        if (!myCombo.getSelectedItem().toString().equals("-")) {
            //findBy = myCombo.getSelectedItem().toString();
            cl.setSkipMe(false);
        } else {
            cl.setSkipMe(true);
        }
        
        sf.skipThisColumn(cl);
        sf.render();
    }

}
