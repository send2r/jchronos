/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jtodo.ui;

/*
 * SimpleJXListDemo.java is a 1.5 application that requires no other files. It is derived from
 * SimpleTableDemo in the Swing tutorial.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXList;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.FilterPipeline;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.jdesktop.swingx.decorator.PatternFilter;
import org.jdesktop.swingx.decorator.ShuttleSorter;




/**
 * This SimpleJXListDemo is a very simple example of how to use the extended features of the
 * JXList in the SwingX project. The major features are covered, step-by-step. You can run
 * this demo from the command-line without arguments
 * java org.jdesktop.demo.sample.SimpleJXListDemo
 *
 * If looking at the source, the interesting code is in configureJXList().
 *
 * This is derived from the SimpleTableDemo in the Swing tutorial.
 *
 * @author Patrick Wright (with help from the Swing tutorial :))
 */
public class SimpleJXListDemo extends JPanel {
    public SimpleJXListDemo() {
        super(new BorderLayout());
        initUI();
    }

    private void initUI() {
        JXList JXList = initList();
        configureJXList(JXList);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(JXList);

        //Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);

        // add our search panel
        // TODO: not ready yet
        // add(initSearchPanel(JXList), BorderLayout.NORTH);
        add(initConfigPanel(JXList), BorderLayout.NORTH);
    }

    /** Initialize our JXList; this is standard stuff, just as with JTable */
    private JXList initList() {
        // boilerplate table-setup; this would be the same for a JTable
        JXList list = new JXList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(25);
        SampleListModel model = new SampleListModel();
        model.loadData();
        list.setModel(model);
        return list;
    }

    /**
     * For demo purposes, the special features of the JXList are configured here. There is
     * otherwise no reason not to do this in initList().
     */
    private void configureJXList(JXList jxList) {
        // We'll add a highlighter to offset different row numbers
        // Note the setHighlighters() takes a varargs parameter; you can chain these together.
        jxList.setHighlighters(
                HighlighterFactory.createSimpleStriping(HighlighterFactory.CLASSIC_LINE_PRINTER));

        // ...oops! we forgot one
        //jxList.addHighlighter(new ColorHighlighter(Color.CYAN, Color.WHITE,
        //        HighlightPredicate.ROLLOVER_ROW));
        jxList.setRolloverEnabled(true);

        // add a filter--filter on name starting with A,
        // and add a descending shuttle sort
        // first need to enable the filtering, it's off by default
        jxList.setFilterEnabled(true);
        jxList.setFilters(new FilterPipeline(new PatternFilter("^A", 0, 0),
                new ShuttleSorter(0, false)));
    }

    /** This shows off some additional JXList configuration, controlled by checkboxes in a Panel. */
    private JPanel initConfigPanel(final JXList JXList) {
        JPanel config = new JPanel();
        FlowLayout fll = (FlowLayout)config.getLayout();
        fll.setAlignment(FlowLayout.LEFT);
        fll.setHgap(30);


        // This shows or hides the column control--note this is possible at runtime
        final JCheckBox rollover = new JCheckBox();
        rollover.setSelected(JXList.isRolloverEnabled());
        rollover.setAction(new AbstractAction("Rollover") {
            public void actionPerformed(ActionEvent e) {
                JXList.setRolloverEnabled(rollover.isSelected());
            }
        });

        config.add(rollover);
        return config;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("SimpleJXListDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        SimpleJXListDemo newContentPane = new SimpleJXListDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // we are lazy - use the same data as in the JXTable example
    // expose the country column as list item
    class SampleListModel extends DefaultTableModel implements ListModel {

        void loadData() {
            try {
                URL url = SampleListModel.class.getResource("/org/jdesktop/demo/sample/resources/weather.txt");
                loadDataFromCSV(url);
            } catch ( Exception e ) {
                e.printStackTrace();
                loadDefaultData();
            }
        }

        private void loadDataFromCSV(URL url) {
            try {
                LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
                String line = lnr.readLine();
                String[] cols = line.split("\t");
                for ( String col : cols ) {
                    addColumn(col);
                }
                while (( line = lnr.readLine()) != null ) {
                    addRow(line.split("\t"));
                }
            } catch ( Exception e ) {
                e.printStackTrace();
                loadDefaultData();
            }
        }

        private void loadDefaultData() {
            int colCnt = 6;
            int rowCnt = 10;
            for ( int i=0; i < colCnt; i++ ) {
                addColumn("Column-" + (i + 1));
            }
            for ( int i=0; i <= rowCnt; i++ ) {
                String[] row = new String[colCnt];
                for ( int j=0; j < colCnt; j++ ) {
                    row[j] = "Row-" + i + "Column-" + (j + 1);
                }
                addRow(row);
            }
        }


        public Object getElementAt(int index) {
            return getValueAt(index, 3);
        }

        public int getSize() {
            return getRowCount();
        }

        public void addListDataListener(ListDataListener l) {
            // do nothing - we are not editable/mutable after loading
        }

        public void removeListDataListener(ListDataListener l) {
            // do nothing - we are not editable/mutatable after loading

        }
    }

//    class SampleListModel extends DefaultListModel {
//        void loadData() {
//            try {
//                URL url = SampleListModel.class.getResource("/org/jdesktop/demo/sample/resources/countries.txt");
//                loadData(url);
//            } catch ( Exception e ) {
//                e.printStackTrace();
//                loadDefaultData();
//            }
//        }
//
//        private void loadData(URL url) {
//            try {
//                List<String> list = new ArrayList<String>();
//                LineNumberReader lnr = new LineNumberReader(new InputStreamReader(url.openStream()));
//                String line = null;
//                while (( line = lnr.readLine()) != null ) {
//                    if ( line.trim().length() > 0 )
//                        list.add(line);
//                }
//                Collections.sort(list);
//                for ( String e : list ) {
//                    addElement(e);
//                }
//            } catch ( Exception e ) {
//                e.printStackTrace();
//                loadDefaultData();
//            }
//        }
//
//        private void loadDefaultData() {
//            int rowCnt = 10;
//            for ( int i=0; i <= rowCnt; i++ ) {
//                addElement( "Row-" + i );
//            }
//        }
//    }
}
