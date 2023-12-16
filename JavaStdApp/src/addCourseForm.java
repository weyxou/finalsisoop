import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addCourseForm extends JFrame {
    private course c = new course();
    private JButton jButtonAddCourse;
    private JButton jButtonCancel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JSpinner jSpinner1;
    private JTextField jTextField_CourseLabel;

    public addCourseForm() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField_CourseLabel = new JTextField();
        jLabel3 = new JLabel();
        jSpinner1 = new JSpinner();
        jButtonAddCourse = new JButton();
        jButtonCancel = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 205, 100));

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 36));
        jLabel1.setText("Add Course");

        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabel2.setText("Label:");

        jTextField_CourseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

        jLabel3.setFont(new Font("Tahoma", Font.BOLD, 14));
        jLabel3.setText("Hours:");

        jSpinner1.setFont(new Font("Tahoma", Font.BOLD, 14));
        jSpinner1.setModel(new SpinnerNumberModel(4, 4, 300, 1));

        jButtonAddCourse.setFont(new Font("Tahoma", Font.BOLD, 12));
        jButtonAddCourse.setIcon(new ImageIcon(getClass().getResource("/images/add.png")));
        jButtonAddCourse.setText("Add");
        jButtonAddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddCourseActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        jButtonCancel.setIcon(new ImageIcon(getClass().getResource("/images/Delete.png")));
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel2)
                                        .addGap(12, 12, 12)
                                        .addComponent(jTextField_CourseLabel, -2, 183, -2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel3)
                                        .addGap(7, 7, 7)
                                        .addComponent(jSpinner1, -2, 70, -2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jButtonCancel, -2, 120, -2)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonAddCourse, -2, 109, -2)))
                        .addContainerGap(64, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jTextField_CourseLabel, -2, -1, -2))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                .addComponent(jSpinner1, -2, -1, -2))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(jButtonCancel, -2, 37, -2)
                                .addComponent(jButtonAddCourse, -2, 37, -2))
                        .addContainerGap(54, 32767)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel1, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(jPanel1, -2, -1, -2));

        pack();
    }

    private void jButtonAddCourseActionPerformed(ActionEvent evt) {
        try {
            if (!c.isCourseExist(jTextField_CourseLabel.getText())) {
                String label = jTextField_CourseLabel.getText();
                int hours = Integer.parseInt(jSpinner1.getValue().toString());
                c.insertUpdateDeleteStudent('i', null, label, hours);
                MainForm.jLabel_CrsCount.setText(" Course Count = " + Integer.toString(MyFunction.countData("course")));

                try {
                    manageCourseForm.jTable1.setModel(new DefaultTableModel(null, new Object[]{"Id", "Label", "Hours"}));
                    c.fillCourseJtable(manageCourseForm.jTable1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Course Already Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void jButtonCancelActionPerformed(ActionEvent evt) {
        dispose();
    }

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                UIManager.LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException var5) {
            Logger.getLogger(addCourseForm.class.getName()).log(Level.SEVERE, null, var5);
        }

        EventQueue.invokeLater(() -> new addCourseForm().setVisible(true));
    }
}
