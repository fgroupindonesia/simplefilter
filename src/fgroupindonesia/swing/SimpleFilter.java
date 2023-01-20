package fgroupindonesia.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fgroupindonesia
 */
public class SimpleFilter {

    boolean debugMode;
    JTable tableRef;
    JComboBox combo;
    JComboBox multiCombo[];
    String findBy;
    String multiFindBy[];
    boolean automatic;
    ArrayList<Object> dataStored = new ArrayList<>();
    ArrayList<Object> dataRender = new ArrayList<>();
    DefaultTableModel skeleton;
    int manyColumns;
    int positionsColumn[];
    CustomListener[] listeners;

    public SimpleFilter(boolean atu) {
        automatic = atu;
    }

    public SimpleFilter(boolean automat, boolean deb) {
        automatic = automat;
        debugMode = deb;
    }

    public void setColumnPositionRef(int... posts) {
        positionsColumn = posts;

        intermediariesColumn = new ColumnLink[multiCombo.length];
        for (int i = 0; i < posts.length; i++) {
            // store the links
            ColumnLink cl = new ColumnLink();
            cl.setCombobox(multiCombo[i]);
            cl.setPositionRef(posts[i]);

            intermediariesColumn[i] = cl;
        }

        // once intermediaries have done set
        // we activate the events
        if (multiCombo.length > 1) {
            setMultiComboboxEvents();
        }

    }

    public void setFindBy(String n) {
        findBy = n;
    }

    private boolean isDebug() {
        return debugMode;
    }

    private boolean isAutomatic() {
        return automatic;
    }

    private void printDebug(String msg) {
        if (isDebug()) {
            System.out.println(msg);
        }
    }

    private void setComboboxEvents() {
        if (combo != null) {
            combo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // item selected
                    printDebug("terklik");

                    if (combo.getSelectedIndex() != -1) {
                        if (!combo.getSelectedItem().toString().equals("-")) {
                            findBy = combo.getSelectedItem().toString();
                            printDebug("Mencari " + findBy);

                            render();

                        } else {
                            // if it is the default one
                            // then render back
                            restoreBack();
                        }

                    }
                }
            });
        }
    }

    private void setMultiComboboxEvents() {
        if (multiCombo != null) {

            if (isAutomatic()) {

                listeners = new CustomListener[multiCombo.length];

                for (int index = 0; index < multiCombo.length; index++) {
                    listeners[index] = new CustomListener(multiCombo[index], this, intermediariesColumn[index]);
                }
            }
        }
    }

    public void setFilterComponent(JComboBox comb) {
        combo = comb;
        if (combo != null) {
            if (isAutomatic()) {
                setComboboxEvents();
            }
        }
    }

    public void setFilterComponents(JComboBox... combs) {
        multiCombo = combs;

    }

    public void setTable(JTable tab) {
        tableRef = tab;
        if (tableRef != null) {
            backupData();
        }
    }

    private void backupData() {
        dataStored = new ArrayList<>();
        int rownum = tableRef.getRowCount();
        int colnum = tableRef.getColumnCount();
        manyColumns = colnum;

        String cols[] = new String[colnum];

        for (int i = 0; i < rownum; i++) {

            for (int y = 0; y < colnum; y++) {
                cols[y] = tableRef.getModel().getValueAt(i, y).toString();
                printDebug("Storing data dulu " + i + " " + cols[y]);
            }

            dataStored.add(cols);
            cols = new String[colnum];

        }

    }

    private boolean isMultiFinding() {
        return (multiCombo != null);
    }

    public void skipThisColumn(ColumnLink cl) {
        // update the skipped column
        int i = 0;
        for (ColumnLink cls : intermediariesColumn) {
            if (cls.getPositionRef() == cl.getPositionRef()) {
                cls.setSkipMe(cl.isSkipMe());
                // update it back
                intermediariesColumn[i] = cls;
                break;
            }

            i++;
        }
    }

    public void render() {

        dataRender = new ArrayList<>();

        if (tableRef != null) {
            if (isTableFilled()) {

                printDebug("Pencarian dimulai!");

                if (!isMultiFinding()) {
                    // for single finding
                    for (Object n : dataStored) {
                        String nx[] = (String[]) n;
                        // start searching

                        innerLoop:
                        for (String inner : nx) {
                            printDebug("Cari di non-multifinding " + inner);
                            if (inner.equalsIgnoreCase(findBy)) {
                                printDebug("Ketemu!");
                                dataRender.add(nx);
                                break innerLoop;
                            }
                        }
                    }
                } else {

                    // for multifinding
                    for (Object n : dataStored) {
                        String nx[] = (String[]) n;
                        // start searching

                        if (rowMatchMultiFinding(nx)) {
                            printDebug("Baris ini cocok!");
                            dataRender.add(nx);
                        }

                    }

                }

                if (isDataReady(dataRender)) {
                    showTable();
                }

            }
        }

    }

    ColumnLink intermediariesColumn[];

    private boolean rowMatchMultiFinding(String dataIn[]) {
        // this data in is actually a set of string
        boolean res = false;

        for (ColumnLink cl : intermediariesColumn) {
            // we do matching for the normal columnLink otherwise
            // we accepted it whatever the value is
            if (!cl.isSkipMe()) {
                res = findMatching(cl, dataIn);
                if (res == false) {
                    break;
                }
            } else {
                res = true;
            }
        }

        return res;
    }

    private boolean findMatching(ColumnLink cl, String dataIn[]) {
        boolean r = false;
        String dataCombo = cl.getCombobox().getSelectedItem().toString();
        printDebug("gue nyari " + dataCombo + " yang ada malah " + dataIn[cl.getPositionRef()]);
        if (dataIn[cl.getPositionRef()].equals(dataCombo)) {
            printDebug("data bener ada!");
            r = true;
        }

        return r;
    }

    private void clearData() {
        // clear first
        skeleton = (DefaultTableModel) tableRef.getModel();
        skeleton.setRowCount(0);
    }

    private void showTable() {

        clearData();

        fillDataFrom(dataRender);

    }

    private void restoreBack() {
        clearData();

        fillDataFrom(dataStored);
    }

    private void fillDataFrom(ArrayList<Object> entries) {
        Object[] rowData = new Object[manyColumns];

        for (Object nx : entries) {
            String[] nxInside = (String[]) nx;
            for (int i = 0; i < nxInside.length; i++) {
                rowData[i] = nxInside[i];
            }

            skeleton.addRow(rowData);
            rowData = new Object[manyColumns];
        }
    }

    private boolean isDataReady(ArrayList<Object> names) {
        return names.size() > 0;
    }

    private boolean isTableFilled() {
        return tableRef.getRowCount() > 0;
    }

}
