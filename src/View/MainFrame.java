package View;

import javax.swing.DefaultComboBoxModel;
import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.Action;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author A456U
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    TableCellListener tableCellListener;
    Logic control = new Logic();
    public String type = "Borrowing";
    public String query = "";

    public MainFrame() {
        initComponents();

        detailEntityBox.setModel(new DefaultComboBoxModel<>(new String[]{"Borrowing", "Book", "Member", "Category", "Author", "Publisher"}));
        resetTable();

        detailMainTable.getTableHeader().setBackground(new Color(93, 64, 55));
        detailMainTable.getTableHeader().setForeground(new Color(255, 255, 255));
        detailMainTable.getTableHeader().setOpaque(false);

        setTableCellListener(detailMainTable);

        detailMainTable.putClientProperty("terminateEditOnFocusLost", Boolean.FALSE);

        detailEntityListTable.getTableHeader().setBackground(new Color(93, 64, 55));
        detailEntityListTable.getTableHeader().setForeground(new Color(255, 255, 255));
        detailEntityListTable.getTableHeader().setOpaque(false);
        
        setTableCellListener(detailEntityListTable);

    }

    public void setTableCellListener(JTable table) {
        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                TableCellListener tcl = (TableCellListener) e.getSource();
                System.out.println(tcl.getOldValue()+" = "+tcl.getNewValue());
                if(tcl.getOldValue() != tcl.getNewValue()) {
                    int check = JOptionPane.showConfirmDialog(null, "Are you sure want to update the edited data ?");
                    if (check == 0) {
                        int row = tcl.getRow();
                        switch (type) {
                            case "Book":
                                Book book = new Book();
                                book.setId(detailMainTable.getValueAt(row, 0).toString());
                                book.setTitle(detailMainTable.getValueAt(row, 1).toString());
                                book.setPublishedYear(detailMainTable.getValueAt(row, 2).toString());
                                book.setCategory(detailMainTable.getValueAt(row, 3).toString());
                                book.setAuthor(detailMainTable.getValueAt(row, 5).toString());
                                book.setPublisher(detailMainTable.getValueAt(row, 7).toString());
                                book.setTotalPage(Integer.parseInt(detailMainTable.getValueAt(row, 9).toString()));
                                control.updateBook(book);
                                break;
                            case "Category":
                                Category category = new Category();
                                category.setId(detailMainTable.getValueAt(row, 0).toString());
                                category.setName(detailMainTable.getValueAt(row, 1).toString());
                                category.setLabel(detailMainTable.getValueAt(row, 2).toString());
                                control.updateCategory(category);
                                break;
                            case "Author":
                                Author author = new Author();
                                author.setId(detailMainTable.getValueAt(row, 0).toString());
                                author.setName(detailMainTable.getValueAt(row, 1).toString());
                                author.setGender(detailMainTable.getValueAt(row, 2).toString());
                                author.setCountry(detailMainTable.getValueAt(row, 3).toString());
                                control.updateAuthor(author);
                                break;
                            case "Member":
                                Member member = new Member();
                                member.setId(detailMainTable.getValueAt(row, 0).toString());
                                member.setName(detailMainTable.getValueAt(row, 1).toString());
                                member.setAddress(detailMainTable.getValueAt(row, 2).toString());
                                member.setPhoneNumber(detailMainTable.getValueAt(row, 3).toString());
                                member.setGender(detailMainTable.getValueAt(row, 4).toString());
                                control.updateMember(member);
                                break;
                            case "Publisher":
                                Publisher publisher = new Publisher();
                                publisher.setId(detailMainTable.getValueAt(row, 0).toString());
                                publisher.setName(detailMainTable.getValueAt(row, 1).toString());
                                publisher.setAddress(detailMainTable.getValueAt(row, 2).toString());
                                publisher.setPhoneNumber(detailMainTable.getValueAt(row, 3).toString());
                                publisher.setCountry(detailMainTable.getValueAt(row, 4).toString());
                                control.updatePublisher(publisher);
                                break;
                            case "Borrowing":
                                Borrowing borrowing = new Borrowing();
                                borrowing.setId(detailMainTable.getValueAt(row, 0).toString());
                                borrowing.setIdMember(detailMainTable.getValueAt(row, 1).toString());
                                borrowing.setMember(detailMainTable.getValueAt(row, 2).toString());
                                borrowing.setIdBook(detailMainTable.getValueAt(row, 3).toString());
                                borrowing.setBook(detailMainTable.getValueAt(row, 4).toString());
                                borrowing.setBorrowingDate(detailMainTable.getValueAt(row, 5).toString());
                                borrowing.setReturningDate(detailMainTable.getValueAt(row, 6).toString());
                                borrowing.setBorrowingDuration(Integer.parseInt(detailMainTable.getValueAt(row, 7).toString()));
                                control.updateBorrowing(borrowing);
                                break;
                            default:
                                break;
                        }
                    } else {
                        resetTable();
                    }
                }
            }
        };

        tableCellListener = new TableCellListener(table, action);
    }

    public void resetTable() {
        setTable();
    }

    public void setTable() {
        this.type = type;
        switch (this.type) {
            case "Book":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTableBook(query));
                } else {
                    detailMainTable.setModel(control.setTableBook());
                }
                detailDetailBtn.setText("Detail (Book)");
                detailCreateBtn.setText("Create new entry (Book)");
                hideColumnBook();
                break;
            case "Category":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTableCategory(query));
                } else {
                    detailMainTable.setModel(control.setTableCategory());
                }
                detailDetailBtn.setText("Detail (Category)");
                detailCreateBtn.setText("Create new entry (Category)");
                break;
            case "Author":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTableAuthor(query));
                } else {
                    detailMainTable.setModel(control.setTableAuthor());
                }
                detailDetailBtn.setText("Detail (Author)");
                detailCreateBtn.setText("Create new entry (Author)");
                break;
            case "Member":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTableMember(query));
                } else {
                    detailMainTable.setModel(control.setTableMember());
                }
                detailDetailBtn.setText("Detail (Member)");
                detailCreateBtn.setText("Create new entry (Member)");
                break;
            case "Publisher":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTablePublisher(query));
                } else {
                    detailMainTable.setModel(control.setTablePublisher());
                }
                detailDetailBtn.setText("Detail (Publisher)");
                detailCreateBtn.setText("Create new entry (Publisher)");
                break;
            case "Borrowing":
                if (!query.equals("")) {
                    detailMainTable.setModel(control.setTableBorrowing(query));
                } else {
                    detailMainTable.setModel(control.setTableBorrowing());
                }
                detailDetailBtn.setText("-");
                detailCreateBtn.setText("Create new entry (Borrowing)");
                hideColumnBorrowing();
                break;
            default:
                break;
        }
    }

    public void hideColumnBook() {
        detailMainTable.getColumnModel().getColumn(3).setMinWidth(0);
        detailMainTable.getColumnModel().getColumn(3).setMaxWidth(0);
        detailMainTable.getColumnModel().getColumn(3).setWidth(0);

        detailMainTable.getColumnModel().getColumn(5).setMinWidth(0);
        detailMainTable.getColumnModel().getColumn(5).setMaxWidth(0);
        detailMainTable.getColumnModel().getColumn(5).setWidth(0);

        detailMainTable.getColumnModel().getColumn(7).setMinWidth(0);
        detailMainTable.getColumnModel().getColumn(7).setMaxWidth(0);
        detailMainTable.getColumnModel().getColumn(7).setWidth(0);
    }

    public void hideColumnBorrowing() {
        detailMainTable.getColumnModel().getColumn(1).setMinWidth(0);
        detailMainTable.getColumnModel().getColumn(1).setMaxWidth(0);
        detailMainTable.getColumnModel().getColumn(1).setWidth(0);

        detailMainTable.getColumnModel().getColumn(3).setMinWidth(0);
        detailMainTable.getColumnModel().getColumn(3).setMaxWidth(0);
        detailMainTable.getColumnModel().getColumn(3).setWidth(0);
    }

    public void hideDetailColumnBook() {
        detailEntityListTable.getColumnModel().getColumn(3).setMinWidth(0);
        detailEntityListTable.getColumnModel().getColumn(3).setMaxWidth(0);
        detailEntityListTable.getColumnModel().getColumn(3).setWidth(0);

        detailEntityListTable.getColumnModel().getColumn(5).setMinWidth(0);
        detailEntityListTable.getColumnModel().getColumn(5).setMaxWidth(0);
        detailEntityListTable.getColumnModel().getColumn(5).setWidth(0);

        detailEntityListTable.getColumnModel().getColumn(7).setMinWidth(0);
        detailEntityListTable.getColumnModel().getColumn(7).setMaxWidth(0);
        detailEntityListTable.getColumnModel().getColumn(7).setWidth(0);
    }

    public void hideDetailColumnBorrowing() {
        detailEntityListTable.getColumnModel().getColumn(1).setMinWidth(0);
        detailEntityListTable.getColumnModel().getColumn(1).setMaxWidth(0);
        detailEntityListTable.getColumnModel().getColumn(1).setWidth(0);

        detailEntityListTable.getColumnModel().getColumn(3).setMinWidth(0);
        detailEntityListTable.getColumnModel().getColumn(3).setMaxWidth(0);
        detailEntityListTable.getColumnModel().getColumn(3).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detailFrame = new javax.swing.JFrame();
        detailTitlePanel = new javax.swing.JPanel();
        detailTitleLabel = new javax.swing.JLabel();
        detailMainPanel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        detailEntityBox = new javax.swing.JComboBox<>();
        jPanel29 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        detailSearchField = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailMainTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        detailRemoveBtn = new javax.swing.JButton();
        detailDetailBtn = new javax.swing.JButton();
        detailCreateBtn = new javax.swing.JButton();
        insertBookFrame = new javax.swing.JFrame();
        detailTitlePanel1 = new javax.swing.JPanel();
        insertBooklTitleLabel = new javax.swing.JLabel();
        insertBookSubtitleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        insertBookIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        insertBookTitleField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        insertBookPublishedDateYearBox = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        insertBookAuthorBox = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        insertBookPublisherBox = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        insertBookCategoryBox = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        insertBookTotalPageSpinner = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        insertBookCancelBtn = new javax.swing.JButton();
        insertBookGoBtn = new javax.swing.JButton();
        insertCategoryFrame = new javax.swing.JFrame();
        insertCategoryTitlePanel = new javax.swing.JPanel();
        insertCategoryTitleLabel = new javax.swing.JLabel();
        insertCategorySubtitleLabel = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        insertCategoryIdField = new javax.swing.JTextField();
        insertCategoryNameField = new javax.swing.JTextField();
        insertCategoryLabelField = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        insertCategoryCancelBtn = new javax.swing.JButton();
        insertCategoryGoBtn = new javax.swing.JButton();
        insertMemberFrame = new javax.swing.JFrame();
        insertMemberTitlePanel = new javax.swing.JPanel();
        insertMemberTitleLabel = new javax.swing.JLabel();
        insertMemberSubtitleLabel = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        insertMemberIdField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        insertMemberNameField = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        insertMemberAddressArea = new javax.swing.JTextArea();
        insertMemberPhoneField = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        insertMemberMaleRadio = new javax.swing.JRadioButton();
        insertMemberFemaleRadio = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        insertMemberCancelBtn = new javax.swing.JButton();
        insertMemberGoBtn = new javax.swing.JButton();
        insertAuthorFrame = new javax.swing.JFrame();
        insertMemberTitlePanel1 = new javax.swing.JPanel();
        insertAuthorTitleLabel = new javax.swing.JLabel();
        insertAuthorSubtitleLabel = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        insertAuthorIdField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        insertAuthorNameField = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        insertAuthorMaleRadio = new javax.swing.JRadioButton();
        insertAuthorFemaleRadio = new javax.swing.JRadioButton();
        insertAuthorCountryField = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        insertAuthorCancelBtn = new javax.swing.JButton();
        insertAuthorGoBtn = new javax.swing.JButton();
        insertPublisherFrame = new javax.swing.JFrame();
        insertPublisherTitlePanel = new javax.swing.JPanel();
        insertPublisherTitleLabel = new javax.swing.JLabel();
        insertPublisherSubtitleLabel = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        insertPublisherIdField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        insertPublisherNameField = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        insertPublisherAddressArea = new javax.swing.JTextArea();
        insertPublisherPhoneField = new javax.swing.JTextField();
        insertPublisherCountryField = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        insertPublisherCancelBtn = new javax.swing.JButton();
        insertPublisherGoBtn = new javax.swing.JButton();
        insertBorrowingFrame = new javax.swing.JFrame();
        insertPublisherTitlePanel1 = new javax.swing.JPanel();
        insertPublisherTitleLabel1 = new javax.swing.JLabel();
        insertPublisherSubtitleLabel1 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        insertBorrowingIdField = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        insertBorrowingIdMemberBox = new javax.swing.JComboBox<>();
        jPanel37 = new javax.swing.JPanel();
        insertBorrowingIdBookBox = new javax.swing.JComboBox<>();
        jPanel35 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        insertBorrowingBorrowingDayBox = new javax.swing.JComboBox<>();
        jPanel39 = new javax.swing.JPanel();
        insertBorrowingBorrowingMonthBox = new javax.swing.JComboBox<>();
        jPanel40 = new javax.swing.JPanel();
        insertBorrowingBorrowingYearBox = new javax.swing.JComboBox<>();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        insertBorrowingReturningDayBox = new javax.swing.JComboBox<>();
        jPanel43 = new javax.swing.JPanel();
        insertBorrowingReturningMonthBox = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        insertBorrowingReturningYearBox = new javax.swing.JComboBox<>();
        jPanel45 = new javax.swing.JPanel();
        insertBorrowingDurationSpinner = new javax.swing.JSpinner();
        jPanel36 = new javax.swing.JPanel();
        insertBorrowingCancelBtn = new javax.swing.JButton();
        insertBorrowingGoBtn = new javax.swing.JButton();
        insertMemberGenderRadioGroup = new javax.swing.ButtonGroup();
        insertAuthorGenderRadioGroup = new javax.swing.ButtonGroup();
        detailEntityFrame = new javax.swing.JFrame();
        insertCategoryTitlePanel1 = new javax.swing.JPanel();
        detailEntityTitleName = new javax.swing.JLabel();
        detailEntitySubtitleName = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        detailEntityIconLabel = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        detailEntityTitle = new javax.swing.JLabel();
        detailEntitySubtitle = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        detailEntityListTable = new javax.swing.JTable();
        detailEntityTableName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        detailBookBackBtn = new javax.swing.JButton();
        mainTitlePanel = new javax.swing.JPanel();
        mainTitleLabel = new javax.swing.JLabel();
        mainSubtitleLabel = new javax.swing.JLabel();
        mainCenterPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mainBtnPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        mainGetStartedBtn = new javax.swing.JButton();

        detailFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        detailFrame.setMinimumSize(new java.awt.Dimension(639, 600));
        detailFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                detailFrameWindowClosed(evt);
            }
        });

        detailTitlePanel.setBackground(new java.awt.Color(93, 64, 55));
        detailTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        detailTitlePanel.setForeground(new java.awt.Color(255, 255, 255));
        detailTitlePanel.setLayout(new java.awt.BorderLayout());

        detailTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        detailTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        detailTitleLabel.setText("Home");
        detailTitlePanel.add(detailTitleLabel, java.awt.BorderLayout.NORTH);

        detailMainPanel.setForeground(new java.awt.Color(255, 255, 255));
        detailMainPanel.setText("Hey Administrator, what would you like to do ?");
        detailTitlePanel.add(detailMainPanel, java.awt.BorderLayout.SOUTH);

        detailFrame.getContentPane().add(detailTitlePanel, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 1, 1, 1));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 24, 24, 24));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setText("Entity");
        jPanel2.add(jLabel2);

        detailEntityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        detailEntityBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailEntityBoxActionPerformed(evt);
            }
        });
        jPanel2.add(detailEntityBox);

        jPanel4.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 24, 24));
        jPanel29.setLayout(new java.awt.GridLayout(2, 1));

        jLabel8.setText("Search");
        jPanel29.add(jLabel8);

        detailSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailSearchFieldActionPerformed(evt);
            }
        });
        detailSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                detailSearchFieldKeyReleased(evt);
            }
        });
        jPanel29.add(detailSearchField);

        jPanel4.add(jPanel29, java.awt.BorderLayout.SOUTH);

        jPanel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 24, 24));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(null);

        detailMainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        detailMainTable.setGridColor(new java.awt.Color(255, 255, 255));
        detailMainTable.setSelectionBackground(new java.awt.Color(80, 70, 55));
        detailMainTable.getTableHeader().setReorderingAllowed(false);
        detailMainTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detailMainTableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                detailMainTableFocusLost(evt);
            }
        });
        detailMainTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                detailMainTablePropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(detailMainTable);

        jPanel30.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel9.setText("*This column is not editable");
        jLabel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 4, 1, 1));
        jPanel30.add(jLabel9, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel30, java.awt.BorderLayout.CENTER);

        detailFrame.getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(93, 64, 55));
        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        detailRemoveBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        detailRemoveBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailRemoveBtn.setText("Remove selected entries");
        detailRemoveBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        detailRemoveBtn.setContentAreaFilled(false);
        detailRemoveBtn.setFocusable(false);
        detailRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailRemoveBtnActionPerformed(evt);
            }
        });
        jPanel3.add(detailRemoveBtn);

        detailDetailBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        detailDetailBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailDetailBtn.setText("Detail");
        detailDetailBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        detailDetailBtn.setContentAreaFilled(false);
        detailDetailBtn.setFocusable(false);
        detailDetailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailDetailBtnActionPerformed(evt);
            }
        });
        jPanel3.add(detailDetailBtn);

        detailCreateBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        detailCreateBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailCreateBtn.setText("Create new entry (Book)");
        detailCreateBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        detailCreateBtn.setContentAreaFilled(false);
        detailCreateBtn.setFocusable(false);
        detailCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailCreateBtnActionPerformed(evt);
            }
        });
        jPanel3.add(detailCreateBtn);

        detailFrame.getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        detailFrame.setLocationRelativeTo(null);

        insertBookFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertBookFrame.setMinimumSize(new java.awt.Dimension(495, 600));
        insertBookFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertBookFrameWindowClosed(evt);
            }
        });

        detailTitlePanel1.setBackground(new java.awt.Color(93, 64, 55));
        detailTitlePanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        detailTitlePanel1.setForeground(new java.awt.Color(255, 255, 255));
        detailTitlePanel1.setLayout(new java.awt.BorderLayout());

        insertBooklTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertBooklTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertBooklTitleLabel.setText("Create new entry");
        detailTitlePanel1.add(insertBooklTitleLabel, java.awt.BorderLayout.NORTH);

        insertBookSubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertBookSubtitleLabel.setText("Book");
        detailTitlePanel1.add(insertBookSubtitleLabel, java.awt.BorderLayout.SOUTH);

        insertBookFrame.getContentPane().add(detailTitlePanel1, java.awt.BorderLayout.NORTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel1.setLayout(new java.awt.GridLayout(7, 1));

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel25.setLayout(new java.awt.BorderLayout());

        insertBookIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertBookIdField.setBorder(null);
        jPanel25.add(insertBookIdField, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("B");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jPanel25.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel1.add(jPanel25);

        insertBookTitleField.setBackground(new java.awt.Color(240, 240, 240));
        insertBookTitleField.setBorder(javax.swing.BorderFactory.createTitledBorder("Title"));
        insertBookTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookTitleFieldActionPerformed(evt);
            }
        });
        insertBookTitleField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                insertBookTitleFieldPropertyChange(evt);
            }
        });
        insertBookTitleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                insertBookTitleFieldKeyPressed(evt);
            }
        });
        jPanel1.add(insertBookTitleField);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Published Date"));
        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 12, 0));

        insertBookPublishedDateYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        insertBookPublishedDateYearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookPublishedDateYearBoxActionPerformed(evt);
            }
        });
        jPanel5.add(insertBookPublishedDateYearBox);

        jPanel1.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Author"));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        insertBookAuthorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        insertBookAuthorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookAuthorBoxActionPerformed(evt);
            }
        });
        jPanel6.add(insertBookAuthorBox);

        jPanel1.add(jPanel6);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Publisher"));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        insertBookPublisherBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        insertBookPublisherBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookPublisherBoxActionPerformed(evt);
            }
        });
        jPanel9.add(insertBookPublisherBox);

        jPanel1.add(jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));
        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        insertBookCategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(insertBookCategoryBox);

        jPanel1.add(jPanel10);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Page"));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        insertBookTotalPageSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000000, 1));
        jPanel11.add(insertBookTotalPageSpinner);

        jPanel1.add(jPanel11);

        insertBookFrame.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(93, 64, 55));
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        insertBookCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertBookCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBookCancelBtn.setText("Cancel");
        insertBookCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertBookCancelBtn.setContentAreaFilled(false);
        insertBookCancelBtn.setFocusable(false);
        insertBookCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookCancelBtnActionPerformed(evt);
            }
        });
        jPanel8.add(insertBookCancelBtn);

        insertBookGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertBookGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBookGoBtn.setText("Go");
        insertBookGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertBookGoBtn.setContentAreaFilled(false);
        insertBookGoBtn.setFocusable(false);
        insertBookGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBookGoBtnActionPerformed(evt);
            }
        });
        jPanel8.add(insertBookGoBtn);

        insertBookFrame.getContentPane().add(jPanel8, java.awt.BorderLayout.SOUTH);

        insertBookFrame.setLocationRelativeTo(null);

        insertCategoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertCategoryFrame.setMinimumSize(new java.awt.Dimension(495, 400));
        insertCategoryFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertCategoryFrameWindowClosed(evt);
            }
        });

        insertCategoryTitlePanel.setBackground(new java.awt.Color(93, 64, 55));
        insertCategoryTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertCategoryTitlePanel.setForeground(new java.awt.Color(255, 255, 255));
        insertCategoryTitlePanel.setLayout(new java.awt.BorderLayout());

        insertCategoryTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertCategoryTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertCategoryTitleLabel.setText("Create new entry");
        insertCategoryTitlePanel.add(insertCategoryTitleLabel, java.awt.BorderLayout.NORTH);

        insertCategorySubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertCategorySubtitleLabel.setText("Category");
        insertCategoryTitlePanel.add(insertCategorySubtitleLabel, java.awt.BorderLayout.SOUTH);

        insertCategoryFrame.getContentPane().add(insertCategoryTitlePanel, java.awt.BorderLayout.NORTH);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel12.setLayout(new java.awt.GridLayout(3, 1));

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("CTG");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jLabel3.setOpaque(true);
        jPanel23.add(jLabel3, java.awt.BorderLayout.WEST);

        insertCategoryIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertCategoryIdField.setBorder(null);
        jPanel23.add(insertCategoryIdField, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel23);

        insertCategoryNameField.setBackground(new java.awt.Color(240, 240, 240));
        insertCategoryNameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));
        insertCategoryNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCategoryNameFieldActionPerformed(evt);
            }
        });
        jPanel12.add(insertCategoryNameField);

        insertCategoryLabelField.setBackground(new java.awt.Color(240, 240, 240));
        insertCategoryLabelField.setBorder(javax.swing.BorderFactory.createTitledBorder("Label"));
        insertCategoryLabelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCategoryLabelFieldActionPerformed(evt);
            }
        });
        jPanel12.add(insertCategoryLabelField);

        insertCategoryFrame.getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel18.setBackground(new java.awt.Color(93, 64, 55));
        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        insertCategoryCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertCategoryCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertCategoryCancelBtn.setText("Cancel");
        insertCategoryCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertCategoryCancelBtn.setContentAreaFilled(false);
        insertCategoryCancelBtn.setFocusable(false);
        insertCategoryCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCategoryCancelBtnActionPerformed(evt);
            }
        });
        jPanel18.add(insertCategoryCancelBtn);

        insertCategoryGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertCategoryGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertCategoryGoBtn.setText("Go");
        insertCategoryGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertCategoryGoBtn.setContentAreaFilled(false);
        insertCategoryGoBtn.setFocusable(false);
        insertCategoryGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCategoryGoBtnActionPerformed(evt);
            }
        });
        jPanel18.add(insertCategoryGoBtn);

        insertCategoryFrame.getContentPane().add(jPanel18, java.awt.BorderLayout.SOUTH);

        insertCategoryFrame.setLocationRelativeTo(null);

        insertMemberFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertMemberFrame.setMinimumSize(new java.awt.Dimension(495, 496));
        insertMemberFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertMemberFrameWindowClosed(evt);
            }
        });

        insertMemberTitlePanel.setBackground(new java.awt.Color(93, 64, 55));
        insertMemberTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertMemberTitlePanel.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberTitlePanel.setLayout(new java.awt.BorderLayout());

        insertMemberTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertMemberTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberTitleLabel.setText("Create new entry");
        insertMemberTitlePanel.add(insertMemberTitleLabel, java.awt.BorderLayout.NORTH);

        insertMemberSubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberSubtitleLabel.setText("Member");
        insertMemberTitlePanel.add(insertMemberSubtitleLabel, java.awt.BorderLayout.SOUTH);

        insertMemberFrame.getContentPane().add(insertMemberTitlePanel, java.awt.BorderLayout.NORTH);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel13.setLayout(new java.awt.GridLayout(5, 1));

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel26.setLayout(new java.awt.BorderLayout());

        insertMemberIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertMemberIdField.setBorder(null);
        jPanel26.add(insertMemberIdField, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("M");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jPanel26.add(jLabel5, java.awt.BorderLayout.WEST);

        jPanel13.add(jPanel26);

        insertMemberNameField.setBackground(new java.awt.Color(240, 240, 240));
        insertMemberNameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));
        insertMemberNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMemberNameFieldActionPerformed(evt);
            }
        });
        jPanel13.add(insertMemberNameField);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        jPanel14.setPreferredSize(new java.awt.Dimension(447, 200));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        insertMemberAddressArea.setColumns(20);
        insertMemberAddressArea.setRows(5);
        insertMemberAddressArea.setPreferredSize(new java.awt.Dimension(164, 200));
        jScrollPane1.setViewportView(insertMemberAddressArea);

        jPanel14.add(jScrollPane1);

        jPanel13.add(jPanel14);

        insertMemberPhoneField.setBackground(new java.awt.Color(240, 240, 240));
        insertMemberPhoneField.setBorder(javax.swing.BorderFactory.createTitledBorder("Phone Number"));
        insertMemberPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMemberPhoneFieldActionPerformed(evt);
            }
        });
        jPanel13.add(insertMemberPhoneField);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Gender"));
        jPanel15.setLayout(new java.awt.GridLayout(1, 2));

        insertMemberGenderRadioGroup.add(insertMemberMaleRadio);
        insertMemberMaleRadio.setText("Male");
        jPanel15.add(insertMemberMaleRadio);

        insertMemberGenderRadioGroup.add(insertMemberFemaleRadio);
        insertMemberFemaleRadio.setText("Female");
        jPanel15.add(insertMemberFemaleRadio);

        jPanel13.add(jPanel15);

        insertMemberFrame.getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel19.setBackground(new java.awt.Color(93, 64, 55));
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        insertMemberCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertMemberCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberCancelBtn.setText("Cancel");
        insertMemberCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertMemberCancelBtn.setContentAreaFilled(false);
        insertMemberCancelBtn.setFocusable(false);
        insertMemberCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMemberCancelBtnActionPerformed(evt);
            }
        });
        jPanel19.add(insertMemberCancelBtn);

        insertMemberGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertMemberGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberGoBtn.setText("Go");
        insertMemberGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertMemberGoBtn.setContentAreaFilled(false);
        insertMemberGoBtn.setFocusable(false);
        insertMemberGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMemberGoBtnActionPerformed(evt);
            }
        });
        jPanel19.add(insertMemberGoBtn);

        insertMemberFrame.getContentPane().add(jPanel19, java.awt.BorderLayout.SOUTH);

        insertMemberFrame.setLocationRelativeTo(null);

        insertAuthorFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertAuthorFrame.setMinimumSize(new java.awt.Dimension(495, 496));
        insertAuthorFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertAuthorFrameWindowClosed(evt);
            }
        });

        insertMemberTitlePanel1.setBackground(new java.awt.Color(93, 64, 55));
        insertMemberTitlePanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertMemberTitlePanel1.setForeground(new java.awt.Color(255, 255, 255));
        insertMemberTitlePanel1.setLayout(new java.awt.BorderLayout());

        insertAuthorTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertAuthorTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertAuthorTitleLabel.setText("Create new entry");
        insertMemberTitlePanel1.add(insertAuthorTitleLabel, java.awt.BorderLayout.NORTH);

        insertAuthorSubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertAuthorSubtitleLabel.setText("Author");
        insertMemberTitlePanel1.add(insertAuthorSubtitleLabel, java.awt.BorderLayout.SOUTH);

        insertAuthorFrame.getContentPane().add(insertMemberTitlePanel1, java.awt.BorderLayout.NORTH);

        jPanel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel16.setLayout(new java.awt.GridLayout(4, 1));

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel27.setLayout(new java.awt.BorderLayout());

        insertAuthorIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertAuthorIdField.setBorder(null);
        jPanel27.add(insertAuthorIdField, java.awt.BorderLayout.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("AUT");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jPanel27.add(jLabel6, java.awt.BorderLayout.WEST);

        jPanel16.add(jPanel27);

        insertAuthorNameField.setBackground(new java.awt.Color(240, 240, 240));
        insertAuthorNameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));
        insertAuthorNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAuthorNameFieldActionPerformed(evt);
            }
        });
        jPanel16.add(insertAuthorNameField);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Gender"));
        jPanel20.setLayout(new java.awt.GridLayout(1, 2));

        insertAuthorGenderRadioGroup.add(insertAuthorMaleRadio);
        insertAuthorMaleRadio.setText("Male");
        jPanel20.add(insertAuthorMaleRadio);

        insertAuthorGenderRadioGroup.add(insertAuthorFemaleRadio);
        insertAuthorFemaleRadio.setText("Female");
        jPanel20.add(insertAuthorFemaleRadio);

        jPanel16.add(jPanel20);

        insertAuthorCountryField.setBackground(new java.awt.Color(240, 240, 240));
        insertAuthorCountryField.setBorder(javax.swing.BorderFactory.createTitledBorder("Country"));
        insertAuthorCountryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAuthorCountryFieldActionPerformed(evt);
            }
        });
        jPanel16.add(insertAuthorCountryField);

        insertAuthorFrame.getContentPane().add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel21.setBackground(new java.awt.Color(93, 64, 55));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        insertAuthorCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertAuthorCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertAuthorCancelBtn.setText("Cancel");
        insertAuthorCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertAuthorCancelBtn.setContentAreaFilled(false);
        insertAuthorCancelBtn.setFocusable(false);
        insertAuthorCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAuthorCancelBtnActionPerformed(evt);
            }
        });
        jPanel21.add(insertAuthorCancelBtn);

        insertAuthorGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertAuthorGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertAuthorGoBtn.setText("Go");
        insertAuthorGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertAuthorGoBtn.setContentAreaFilled(false);
        insertAuthorGoBtn.setFocusable(false);
        insertAuthorGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertAuthorGoBtnActionPerformed(evt);
            }
        });
        jPanel21.add(insertAuthorGoBtn);

        insertAuthorFrame.getContentPane().add(jPanel21, java.awt.BorderLayout.SOUTH);

        insertAuthorFrame.setLocationRelativeTo(null);

        insertPublisherFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertPublisherFrame.setMinimumSize(new java.awt.Dimension(495, 496));
        insertPublisherFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertPublisherFrameWindowClosed(evt);
            }
        });

        insertPublisherTitlePanel.setBackground(new java.awt.Color(93, 64, 55));
        insertPublisherTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertPublisherTitlePanel.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherTitlePanel.setLayout(new java.awt.BorderLayout());

        insertPublisherTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertPublisherTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherTitleLabel.setText("Create new entry");
        insertPublisherTitlePanel.add(insertPublisherTitleLabel, java.awt.BorderLayout.NORTH);

        insertPublisherSubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherSubtitleLabel.setText("Publisher");
        insertPublisherTitlePanel.add(insertPublisherSubtitleLabel, java.awt.BorderLayout.SOUTH);

        insertPublisherFrame.getContentPane().add(insertPublisherTitlePanel, java.awt.BorderLayout.NORTH);

        jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel17.setLayout(new java.awt.GridLayout(5, 1));

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel28.setLayout(new java.awt.BorderLayout());

        insertPublisherIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertPublisherIdField.setBorder(null);
        jPanel28.add(insertPublisherIdField, java.awt.BorderLayout.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("PUB");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jPanel28.add(jLabel7, java.awt.BorderLayout.WEST);

        jPanel17.add(jPanel28);

        insertPublisherNameField.setBackground(new java.awt.Color(240, 240, 240));
        insertPublisherNameField.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));
        insertPublisherNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPublisherNameFieldActionPerformed(evt);
            }
        });
        jPanel17.add(insertPublisherNameField);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        jPanel22.setPreferredSize(new java.awt.Dimension(447, 200));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        insertPublisherAddressArea.setColumns(20);
        insertPublisherAddressArea.setRows(5);
        insertPublisherAddressArea.setPreferredSize(new java.awt.Dimension(164, 200));
        jScrollPane3.setViewportView(insertPublisherAddressArea);

        jPanel22.add(jScrollPane3);

        jPanel17.add(jPanel22);

        insertPublisherPhoneField.setBackground(new java.awt.Color(240, 240, 240));
        insertPublisherPhoneField.setBorder(javax.swing.BorderFactory.createTitledBorder("Phone Number"));
        insertPublisherPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPublisherPhoneFieldActionPerformed(evt);
            }
        });
        jPanel17.add(insertPublisherPhoneField);

        insertPublisherCountryField.setBackground(new java.awt.Color(240, 240, 240));
        insertPublisherCountryField.setBorder(javax.swing.BorderFactory.createTitledBorder("Country"));
        insertPublisherCountryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPublisherCountryFieldActionPerformed(evt);
            }
        });
        jPanel17.add(insertPublisherCountryField);

        insertPublisherFrame.getContentPane().add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel24.setBackground(new java.awt.Color(93, 64, 55));
        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        insertPublisherCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertPublisherCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherCancelBtn.setText("Cancel");
        insertPublisherCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertPublisherCancelBtn.setContentAreaFilled(false);
        insertPublisherCancelBtn.setFocusable(false);
        insertPublisherCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPublisherCancelBtnActionPerformed(evt);
            }
        });
        jPanel24.add(insertPublisherCancelBtn);

        insertPublisherGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertPublisherGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherGoBtn.setText("Go");
        insertPublisherGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertPublisherGoBtn.setContentAreaFilled(false);
        insertPublisherGoBtn.setFocusable(false);
        insertPublisherGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertPublisherGoBtnActionPerformed(evt);
            }
        });
        jPanel24.add(insertPublisherGoBtn);

        insertPublisherFrame.getContentPane().add(jPanel24, java.awt.BorderLayout.SOUTH);

        insertPublisherFrame.setLocationRelativeTo(null);

        insertBorrowingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        insertBorrowingFrame.setMinimumSize(new java.awt.Dimension(495, 600));
        insertBorrowingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                insertBorrowingFrameWindowClosed(evt);
            }
        });

        insertPublisherTitlePanel1.setBackground(new java.awt.Color(93, 64, 55));
        insertPublisherTitlePanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertPublisherTitlePanel1.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherTitlePanel1.setLayout(new java.awt.BorderLayout());

        insertPublisherTitleLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        insertPublisherTitleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherTitleLabel1.setText("Create new entry");
        insertPublisherTitlePanel1.add(insertPublisherTitleLabel1, java.awt.BorderLayout.NORTH);

        insertPublisherSubtitleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        insertPublisherSubtitleLabel1.setText("Borrowing");
        insertPublisherTitlePanel1.add(insertPublisherSubtitleLabel1, java.awt.BorderLayout.SOUTH);

        insertBorrowingFrame.getContentPane().add(insertPublisherTitlePanel1, java.awt.BorderLayout.NORTH);

        jPanel32.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel32.setLayout(new java.awt.GridLayout(6, 1));

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));
        jPanel46.setLayout(new java.awt.BorderLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("BOR");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 12, 1, 12));
        jPanel46.add(jLabel11, java.awt.BorderLayout.WEST);

        insertBorrowingIdField.setBackground(new java.awt.Color(240, 240, 240));
        insertBorrowingIdField.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        insertBorrowingIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBorrowingIdFieldActionPerformed(evt);
            }
        });
        jPanel46.add(insertBorrowingIdField, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel46);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder("Member ID"));
        jPanel34.setLayout(new java.awt.BorderLayout());

        insertBorrowingIdMemberBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel34.add(insertBorrowingIdMemberBox, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel34);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Book ID"));
        jPanel37.setLayout(new java.awt.BorderLayout());

        insertBorrowingIdBookBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel37.add(insertBorrowingIdBookBox, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel37);

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder("Borrowing Date"));
        jPanel35.setPreferredSize(new java.awt.Dimension(447, 200));
        jPanel35.setLayout(new java.awt.GridLayout(1, 3));

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Day"));
        jPanel38.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingBorrowingDayBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel38.add(insertBorrowingBorrowingDayBox);

        jPanel35.add(jPanel38);

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Month"));
        jPanel39.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingBorrowingMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel39.add(insertBorrowingBorrowingMonthBox);

        jPanel35.add(jPanel39);

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Year"));
        jPanel40.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingBorrowingYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel40.add(insertBorrowingBorrowingYearBox);

        jPanel35.add(jPanel40);

        jPanel32.add(jPanel35);

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Returning Date"));
        jPanel41.setPreferredSize(new java.awt.Dimension(447, 200));
        jPanel41.setLayout(new java.awt.GridLayout(1, 3));

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Day"));
        jPanel42.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingReturningDayBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel42.add(insertBorrowingReturningDayBox);

        jPanel41.add(jPanel42);

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Month"));
        jPanel43.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingReturningMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        insertBorrowingReturningMonthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBorrowingReturningMonthBoxActionPerformed(evt);
            }
        });
        jPanel43.add(insertBorrowingReturningMonthBox);

        jPanel41.add(jPanel43);

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Year"));
        jPanel44.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingReturningYearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel44.add(insertBorrowingReturningYearBox);

        jPanel41.add(jPanel44);

        jPanel32.add(jPanel41);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Borrowing Duration [Day(s)]"));
        jPanel45.setPreferredSize(new java.awt.Dimension(447, 200));
        jPanel45.setLayout(new java.awt.GridLayout(1, 1));

        insertBorrowingDurationSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel45.add(insertBorrowingDurationSpinner);

        jPanel32.add(jPanel45);

        insertBorrowingFrame.getContentPane().add(jPanel32, java.awt.BorderLayout.CENTER);

        jPanel36.setBackground(new java.awt.Color(93, 64, 55));
        jPanel36.setLayout(new java.awt.GridLayout(1, 0));

        insertBorrowingCancelBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertBorrowingCancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBorrowingCancelBtn.setText("Cancel");
        insertBorrowingCancelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertBorrowingCancelBtn.setContentAreaFilled(false);
        insertBorrowingCancelBtn.setFocusable(false);
        insertBorrowingCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBorrowingCancelBtnActionPerformed(evt);
            }
        });
        jPanel36.add(insertBorrowingCancelBtn);

        insertBorrowingGoBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        insertBorrowingGoBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBorrowingGoBtn.setText("Go");
        insertBorrowingGoBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        insertBorrowingGoBtn.setContentAreaFilled(false);
        insertBorrowingGoBtn.setFocusable(false);
        insertBorrowingGoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBorrowingGoBtnActionPerformed(evt);
            }
        });
        jPanel36.add(insertBorrowingGoBtn);

        insertBorrowingFrame.getContentPane().add(jPanel36, java.awt.BorderLayout.SOUTH);

        insertBorrowingFrame.setLocationRelativeTo(null);

        detailEntityFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        detailEntityFrame.setMinimumSize(new java.awt.Dimension(800, 650));
        detailEntityFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                detailEntityFrameWindowClosed(evt);
            }
        });

        insertCategoryTitlePanel1.setBackground(new java.awt.Color(93, 64, 55));
        insertCategoryTitlePanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        insertCategoryTitlePanel1.setForeground(new java.awt.Color(255, 255, 255));
        insertCategoryTitlePanel1.setLayout(new java.awt.BorderLayout());

        detailEntityTitleName.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        detailEntityTitleName.setForeground(new java.awt.Color(255, 255, 255));
        detailEntityTitleName.setText("Title");
        insertCategoryTitlePanel1.add(detailEntityTitleName, java.awt.BorderLayout.NORTH);

        detailEntitySubtitleName.setForeground(new java.awt.Color(255, 255, 255));
        detailEntitySubtitleName.setText("Subtitle");
        insertCategoryTitlePanel1.add(detailEntitySubtitleName, java.awt.BorderLayout.SOUTH);

        detailEntityFrame.getContentPane().add(insertCategoryTitlePanel1, java.awt.BorderLayout.NORTH);

        jPanel31.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        jPanel31.setLayout(new java.awt.BorderLayout());

        jPanel47.setLayout(new java.awt.BorderLayout());

        detailEntityIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detailEntityIconLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        detailEntityIconLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel47.add(detailEntityIconLabel, java.awt.BorderLayout.WEST);

        jPanel48.setLayout(new java.awt.GridLayout(2, 0));

        detailEntityTitle.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        detailEntityTitle.setText("Book Title");
        jPanel48.add(detailEntityTitle);

        detailEntitySubtitle.setText("Wrriten by");
        jPanel48.add(detailEntitySubtitle);

        jPanel47.add(jPanel48, java.awt.BorderLayout.CENTER);

        jPanel31.add(jPanel47, java.awt.BorderLayout.NORTH);

        jPanel49.setLayout(new java.awt.BorderLayout());

        detailEntityListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        detailEntityListTable.setEnabled(false);
        detailEntityListTable.setGridColor(new java.awt.Color(255, 255, 255));
        detailEntityListTable.setSelectionBackground(new java.awt.Color(80, 70, 55));
        detailEntityListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(detailEntityListTable);

        jPanel49.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        detailEntityTableName.setText("History");
        detailEntityTableName.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 1, 12, 1));
        jPanel49.add(detailEntityTableName, java.awt.BorderLayout.PAGE_START);

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel10.setText("This table is not editable");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 4, 1, 1));
        jPanel49.add(jLabel10, java.awt.BorderLayout.SOUTH);

        jPanel31.add(jPanel49, java.awt.BorderLayout.CENTER);

        detailEntityFrame.getContentPane().add(jPanel31, java.awt.BorderLayout.CENTER);

        jPanel33.setBackground(new java.awt.Color(93, 64, 55));
        jPanel33.setLayout(new java.awt.GridLayout(1, 0));

        detailBookBackBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        detailBookBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        detailBookBackBtn.setText("Back");
        detailBookBackBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        detailBookBackBtn.setContentAreaFilled(false);
        detailBookBackBtn.setFocusable(false);
        detailBookBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBookBackBtnActionPerformed(evt);
            }
        });
        jPanel33.add(detailBookBackBtn);

        detailEntityFrame.getContentPane().add(jPanel33, java.awt.BorderLayout.SOUTH);

        detailEntityFrame.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        mainTitlePanel.setBackground(new java.awt.Color(93, 64, 55));
        mainTitlePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24));
        mainTitlePanel.setLayout(new java.awt.GridLayout(2, 1));

        mainTitleLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        mainTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitleLabel.setText("Welcome to Library");
        mainTitlePanel.add(mainTitleLabel);

        mainSubtitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainSubtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainSubtitleLabel.setText("Hey, you, finally awake...");
        mainTitlePanel.add(mainSubtitleLabel);

        getContentPane().add(mainTitlePanel, java.awt.BorderLayout.NORTH);

        mainCenterPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("Resources/View/block.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_DEFAULT)));
        mainCenterPanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainCenterPanel, java.awt.BorderLayout.CENTER);

        mainBtnPanel.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(93, 64, 55));
        jPanel7.setLayout(new java.awt.GridLayout(1, 1));

        mainGetStartedBtn.setBackground(new java.awt.Color(93, 64, 55));
        mainGetStartedBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        mainGetStartedBtn.setForeground(new java.awt.Color(255, 255, 255));
        mainGetStartedBtn.setText("Get started");
        mainGetStartedBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        mainGetStartedBtn.setContentAreaFilled(false);
        mainGetStartedBtn.setFocusable(false);
        mainGetStartedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainGetStartedBtnActionPerformed(evt);
            }
        });
        jPanel7.add(mainGetStartedBtn);

        mainBtnPanel.add(jPanel7, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainBtnPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainGetStartedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainGetStartedBtnActionPerformed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
        mainFrame.setVisible(false);
    }//GEN-LAST:event_mainGetStartedBtnActionPerformed

    private void detailFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_detailFrameWindowClosed
        // TODO add your handling code here:
        mainFrame.setVisible(true);
    }//GEN-LAST:event_detailFrameWindowClosed

    private void insertBookFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertBookFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertBookFrameWindowClosed

    private void insertBookTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookTitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookTitleFieldActionPerformed

    private void detailCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailCreateBtnActionPerformed
        // TODO add your handling code here:
        String val = detailEntityBox.getSelectedItem().toString();
        switch (val) {
            case "Book":
                insertBookFrame.setVisible(true);

                DefaultComboBoxModel modelYear = new DefaultComboBoxModel();
                for (int i = 1900; i <= 2019; i++) {
                    modelYear.addElement(new String(String.valueOf(i)));
                }
                insertBookPublishedDateYearBox.setModel(modelYear);

                DefaultComboBoxModel modelAuthor = new DefaultComboBoxModel();
                ArrayList<Author> listAuthor = control.selectAllAuthor();
                for (int i = 0; i < listAuthor.size(); i++) {
                    modelAuthor.addElement(new String(listAuthor.get(i).getId() + "-" + listAuthor.get(i).getName()));
                }
                insertBookAuthorBox.setModel(modelAuthor);

                DefaultComboBoxModel modelPublisher = new DefaultComboBoxModel();
                ArrayList<Publisher> listPublisher = control.selectAllPublisher();
                for (int i = 0; i < listPublisher.size(); i++) {
                    modelPublisher.addElement(new String(listPublisher.get(i).getId() + "-" + listPublisher.get(i).getName()));
                }
                insertBookPublisherBox.setModel(modelPublisher);

                DefaultComboBoxModel modelCategory = new DefaultComboBoxModel();
                ArrayList<Category> listCategory = control.selectAllCategory();
                for (int i = 0; i < listCategory.size(); i++) {
                    modelCategory.addElement(new String(listCategory.get(i).getId() + "-" + listCategory.get(i).getName()));
                }
                insertBookCategoryBox.setModel(modelCategory);
                break;
            case "Category":
                insertCategoryFrame.setVisible(true);
                break;
            case "Member":
                insertMemberFrame.setVisible(true);
                break;
            case "Author":
                insertAuthorFrame.setVisible(true);
                break;
            case "Publisher":
                insertPublisherFrame.setVisible(true);
                break;
            case "Borrowing":
                insertBorrowingFrame.setVisible(true);

                DefaultComboBoxModel modelBorrowingDay = new DefaultComboBoxModel();
                for (int i = 1; i <= 31; i++) {
                    modelBorrowingDay.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingBorrowingDayBox.setModel(modelBorrowingDay);

                DefaultComboBoxModel modelBorrowingMonth = new DefaultComboBoxModel();
                for (int i = 1; i <= 12; i++) {
                    modelBorrowingMonth.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingBorrowingMonthBox.setModel(modelBorrowingMonth);

                DefaultComboBoxModel modelBorrowingYear = new DefaultComboBoxModel();
                for (int i = 1900; i <= 2019; i++) {
                    modelBorrowingYear.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingBorrowingYearBox.setModel(modelBorrowingYear);

                DefaultComboBoxModel modelReturningDay = new DefaultComboBoxModel();
                for (int i = 1; i <= 31; i++) {
                    modelReturningDay.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingReturningDayBox.setModel(modelReturningDay);

                DefaultComboBoxModel modelReturningMonth = new DefaultComboBoxModel();
                for (int i = 1; i <= 12; i++) {
                    modelReturningMonth.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingReturningMonthBox.setModel(modelReturningMonth);

                DefaultComboBoxModel modelReturningYear = new DefaultComboBoxModel();
                for (int i = 1900; i <= 2019; i++) {
                    modelReturningYear.addElement(new String(String.valueOf(i)));
                }
                insertBorrowingReturningYearBox.setModel(modelReturningYear);

                DefaultComboBoxModel modelMemberBorrowing = new DefaultComboBoxModel();
                ArrayList<Member> listMemberBorrowing = control.selectAllMember();
                for (int i = 0; i < listMemberBorrowing.size(); i++) {
                    modelMemberBorrowing.addElement(new String(listMemberBorrowing.get(i).getId() + "-" + listMemberBorrowing.get(i).getName()));
                }
                insertBorrowingIdMemberBox.setModel(modelMemberBorrowing);

                DefaultComboBoxModel modelBookBorrowing = new DefaultComboBoxModel();
                ArrayList<Book> listBookBorrowing = control.selectAllBook();
                for (int i = 0; i < listBookBorrowing.size(); i++) {
                    modelBookBorrowing.addElement(new String(listBookBorrowing.get(i).getId() + "-" + listBookBorrowing.get(i).getTitle()));
                }
                insertBorrowingIdBookBox.setModel(modelBookBorrowing);

                break;
            default:
                break;
        }
        detailFrame.setVisible(false);
    }//GEN-LAST:event_detailCreateBtnActionPerformed

    private void insertBookGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookGoBtnActionPerformed
        // TODO add your handling code here:
        String id = "B" + insertBookIdField.getText();
        String title = insertBookTitleField.getText();
        String publishedYear = insertBookPublishedDateYearBox.getSelectedItem().toString();
        String idCategory = insertBookCategoryBox.getSelectedItem().toString().split("-")[0];
        String category = insertBookCategoryBox.getSelectedItem().toString().split("-")[1];
        String idAuthor = insertBookAuthorBox.getSelectedItem().toString().split("-")[0];
        String author = insertBookAuthorBox.getSelectedItem().toString().split("-")[1];
        String idPublisher = insertBookPublisherBox.getSelectedItem().toString().split("-")[0];
        String publisher = insertBookPublisherBox.getSelectedItem().toString().split("-")[1];
        int totalPage = Integer.parseInt(insertBookTotalPageSpinner.getValue().toString());

        if (!id.equals("B") && !title.equals("")) {
            control.insertBook(id, title, publishedYear, idCategory, category, idAuthor, author, idPublisher, publisher, totalPage);
            resetTable();
            insertBookIdField.setText("");
            insertBookTitleField.setText("");
            insertBookTotalPageSpinner.setValue(1);
        } else {
            JOptionPane.showMessageDialog(null, "ID and Title cannot empty");
        }

    }//GEN-LAST:event_insertBookGoBtnActionPerformed

    private void insertCategoryLabelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCategoryLabelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCategoryLabelFieldActionPerformed

    private void insertCategoryGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCategoryGoBtnActionPerformed
        // TODO add your handling code here:
        String id = "CTG" + insertCategoryIdField.getText();
        String name = insertCategoryNameField.getText();
        String label = insertCategoryLabelField.getText();

        if (!id.equals("CTG") && !name.equals("") && !label.equals("")) {
            control.insertCategory(id, name, label);
            resetTable();
            insertCategoryIdField.setText("");
            insertCategoryNameField.setText("");
            insertCategoryLabelField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "ID, Name, and Label cannot empty");
        }

    }//GEN-LAST:event_insertCategoryGoBtnActionPerformed

    private void insertCategoryFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertCategoryFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertCategoryFrameWindowClosed

    private void insertCategoryNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCategoryNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCategoryNameFieldActionPerformed

    private void detailEntityBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailEntityBoxActionPerformed
        // TODO add your handling code here:
        String val = detailEntityBox.getSelectedItem().toString();
        type = val;
        resetTable();
    }//GEN-LAST:event_detailEntityBoxActionPerformed

    private void insertMemberNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMemberNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertMemberNameFieldActionPerformed

    private void insertMemberGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMemberGoBtnActionPerformed
        // TODO add your handling code here:
        String id = "M" + insertMemberIdField.getText();
        String name = insertMemberNameField.getText();
        String address = insertMemberAddressArea.getText();
        String phoneNumber = insertMemberPhoneField.getText();
        String gender;
        if (insertMemberMaleRadio.isSelected()) {
            gender = insertMemberMaleRadio.getText();
        } else {
            gender = insertMemberFemaleRadio.getText();
        }

        if (!id.equals("M") && !name.equals("") && !gender.equals("")) {
            control.insertMember(id, name, address, phoneNumber, gender);
            resetTable();
            insertMemberIdField.setText("");
            insertMemberNameField.setText("");
            insertMemberGenderRadioGroup.clearSelection();
            insertMemberAddressArea.setText("");
            insertMemberPhoneField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "ID, Name, and Gender cannot empty");
        }

    }//GEN-LAST:event_insertMemberGoBtnActionPerformed

    private void insertMemberFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertMemberFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertMemberFrameWindowClosed

    private void insertMemberPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMemberPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertMemberPhoneFieldActionPerformed

    private void insertAuthorNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAuthorNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertAuthorNameFieldActionPerformed

    private void insertAuthorCountryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAuthorCountryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertAuthorCountryFieldActionPerformed

    private void insertAuthorGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAuthorGoBtnActionPerformed
        // TODO add your handling code here:
        String id = "AUT" + insertAuthorIdField.getText();
        String name = insertAuthorNameField.getText();
        String gender;
        if (insertAuthorMaleRadio.isSelected()) {
            gender = insertAuthorMaleRadio.getText();
        } else {
            gender = insertAuthorFemaleRadio.getText();
        }
        String country = insertAuthorCountryField.getText();

        if (!id.equals("AUT") && !name.equals("") && !gender.equals("") && !country.equals("")) {
            control.insertAuthor(id, name, gender, country);
            resetTable();
            insertAuthorIdField.setText("");
            insertAuthorNameField.setText("");
            insertAuthorGenderRadioGroup.clearSelection();
            insertAuthorCountryField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "ID, Name, Gender, and Country cannot empty");
        }
    }//GEN-LAST:event_insertAuthorGoBtnActionPerformed

    private void insertAuthorFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertAuthorFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertAuthorFrameWindowClosed

    private void insertPublisherNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPublisherNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertPublisherNameFieldActionPerformed

    private void insertPublisherPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPublisherPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertPublisherPhoneFieldActionPerformed

    private void insertPublisherGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPublisherGoBtnActionPerformed
        // TODO add your handling code here:
        String id = "PUB" + insertPublisherIdField.getText();
        String name = insertPublisherNameField.getText();
        String address = insertPublisherAddressArea.getText();
        String phoneNumber = insertPublisherPhoneField.getText();
        String country = insertPublisherCountryField.getText();

        if (!id.equals("PUB") && !name.equals("") && !country.equals("")) {
            control.insertPublisher(id, name, address, phoneNumber, country);
            resetTable();
            insertPublisherIdField.setText("");
            insertPublisherNameField.setText("");
            insertPublisherCountryField.setText("");
            insertPublisherAddressArea.setText("");
            insertPublisherPhoneField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "ID, Name, Gender, and Country cannot empty");
        }
    }//GEN-LAST:event_insertPublisherGoBtnActionPerformed

    private void insertPublisherFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertPublisherFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertPublisherFrameWindowClosed

    private void insertPublisherCountryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPublisherCountryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertPublisherCountryFieldActionPerformed

    private void detailRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailRemoveBtnActionPerformed
        // TODO add your handling code here:
        int[] selected = detailMainTable.getSelectedRows();
        int check = JOptionPane.showConfirmDialog(null, "Are you sure want to remove " + selected.length + " selected item(s) ?");
        if (check == 0) {
            String val = detailEntityBox.getSelectedItem().toString();
            for (int id : selected) {
                switch (val) {
                    case "Member":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "member");
                        break;
                    case "Category":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "kategori");
                        break;
                    case "Author":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "penulis");
                        break;
                    case "Publisher":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "penerbit");
                        break;
                    case "Book":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "buku");
                        break;
                    case "Borrowing":
                        control.remove(detailMainTable.getValueAt(id, 0).toString(), "peminjaman");
                        break;
                    default:
                        break;
                }
            }
            resetTable();
        }
    }//GEN-LAST:event_detailRemoveBtnActionPerformed

    private void detailMainTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detailMainTableFocusLost
        // TODO add your handling code here:
//        tempBook = new Book();
//        tempBook.setId(detailMainTable.getValueAt(row, 0).toString());
//        tempBook.setTitle(detailMainTable.getValueAt(row, 1).toString());
//        tempBook.setPublishedYear(detailMainTable.getValueAt(row, 2).toString());
//        tempBook.setCategory(detailMainTable.getValueAt(row, 3).toString());
//        tempBook.setAuthor(detailMainTable.getValueAt(row, 5).toString());
//        tempBook.setPublisher(detailMainTable.getValueAt(row, 7).toString());
//        tempBook.setTotalPage(Integer.parseInt(detailMainTable.getValueAt(row, 9).toString()));

    }//GEN-LAST:event_detailMainTableFocusLost

    private void insertBookPublishedDateYearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookPublishedDateYearBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookPublishedDateYearBoxActionPerformed

    private void insertBookPublisherBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookPublisherBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookPublisherBoxActionPerformed

    private void insertBookCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookCancelBtnActionPerformed
        // TODO add your handling code here:
        insertBookFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertBookIdField.setText("");
        insertBookTitleField.setText("");
        insertBookTotalPageSpinner.setValue(1);
    }//GEN-LAST:event_insertBookCancelBtnActionPerformed

    private void insertCategoryCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCategoryCancelBtnActionPerformed
        // TODO add your handling code here:
        insertCategoryFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertCategoryIdField.setText("");
        insertCategoryNameField.setText("");
        insertCategoryLabelField.setText("");
    }//GEN-LAST:event_insertCategoryCancelBtnActionPerformed

    private void insertMemberCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMemberCancelBtnActionPerformed
        // TODO add your handling code here:
        insertMemberFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertMemberIdField.setText("");
        insertMemberNameField.setText("");
        insertMemberGenderRadioGroup.clearSelection();
        insertMemberAddressArea.setText("");
        insertMemberPhoneField.setText("");
    }//GEN-LAST:event_insertMemberCancelBtnActionPerformed

    private void insertAuthorCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertAuthorCancelBtnActionPerformed
        // TODO add your handling code here:
        insertAuthorFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertAuthorIdField.setText("");
        insertAuthorNameField.setText("");
        insertAuthorGenderRadioGroup.clearSelection();
        insertAuthorCountryField.setText("");
    }//GEN-LAST:event_insertAuthorCancelBtnActionPerformed

    private void insertPublisherCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertPublisherCancelBtnActionPerformed
        // TODO add your handling code here:
        insertPublisherFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertPublisherIdField.setText("");
        insertPublisherNameField.setText("");
        insertPublisherCountryField.setText("");
        insertPublisherAddressArea.setText("");
        insertPublisherPhoneField.setText("");
    }//GEN-LAST:event_insertPublisherCancelBtnActionPerformed

    private void detailSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailSearchFieldActionPerformed

    private void detailSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detailSearchFieldKeyReleased
        // TODO add your handling code here:
        query = detailSearchField.getText();
        resetTable();
    }//GEN-LAST:event_detailSearchFieldKeyReleased

    private void detailDetailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailDetailBtnActionPerformed
        // TODO add your handling code here:
        int[] selected = detailMainTable.getSelectedRows();
        if (selected.length == 1 && !type.equals("Borrowing")) {
            String id = detailMainTable.getValueAt(selected[0], 0).toString();
            String val = detailEntityBox.getSelectedItem().toString();
            switch (val) {
                case "Member":
                    DetailMember detailMember = control.selectDetailMember(id);
                    detailEntityTitle.setText("[#" + detailMember.getMember().getId() + "] " + detailMember.getMember().getName() + " (" + detailMember.getMember().getGender() + ")");
                    detailEntitySubtitle.setText("Address : " + detailMember.getMember().getAddress() + " || CP : " + detailMember.getMember().getPhoneNumber());
                    detailEntityTableName.setText("This member has borrowed " + detailMember.getTotalBook() + " Book(s)");
                    detailEntityListTable.setModel(control.setTableBorrowing(detailMember.getBorrowingList()));
                    detailEntityIconLabel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getClassLoader().getResource("Resources/View/150px-Creeper_Head.png")).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT)));
                    detailEntityTitleName.setText("Detail");
                    detailEntitySubtitleName.setText("Member");
                    hideDetailColumnBorrowing();
                    break;
                case "Category":
                    DetailCategory detailCategory = control.selectDetailCategory(id);
                    detailEntityTitle.setText("[#" + detailCategory.getCategory().getId() + "] " + detailCategory.getCategory().getName());
                    detailEntitySubtitle.setText("Label : " + detailCategory.getCategory().getLabel());
                    detailEntityTableName.setText("This category has " + detailCategory.getTotalBook() + " Book(s)");
                    detailEntityListTable.setModel(control.setTableBook(detailCategory.getBookList()));
                    detailEntityIconLabel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getClassLoader().getResource("Resources/View/Name_Tag.png")).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT)));
                    detailEntityTitleName.setText("Detail");
                    detailEntitySubtitleName.setText("Category");
                    hideDetailColumnBook();
                    break;
                case "Author":
                    DetailAuthor detailAuthor = control.selectDetailAuthor(id);
                    detailEntityTitle.setText("[#" + detailAuthor.getAuthor().getId() + "] " + detailAuthor.getAuthor().getName() + " (" + detailAuthor.getAuthor().getGender() + ")");
                    detailEntitySubtitle.setText("from " + detailAuthor.getAuthor().getCountry());
                    detailEntityTableName.setText("This author has written " + detailAuthor.getTotalBook() + " Book(s)");
                    detailEntityListTable.setModel(control.setTableBook(detailAuthor.getBookList()));
                    detailEntityIconLabel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getClassLoader().getResource("Resources/View/Skeleton_Skull.png")).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT)));
                    detailEntityTitleName.setText("Detail");
                    detailEntitySubtitleName.setText("Author");
                    hideDetailColumnBook();
                    break;
                case "Publisher":
                    DetailPublisher detailPublisher = control.selectDetailPublisher(id);
                    detailEntityTitle.setText("[#" + detailPublisher.getPublisher().getId() + "] " + detailPublisher.getPublisher().getName());
                    detailEntitySubtitle.setText("Address : " + detailPublisher.getPublisher().getAddress() + " || CP : " + detailPublisher.getPublisher().getPhoneNumber());
                    detailEntityTableName.setText("This publisher has published " + detailPublisher.getTotalBook() + " Book(s)");
                    detailEntityListTable.setModel(control.setTableBook(detailPublisher.getBookList()));
                    detailEntityIconLabel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getClassLoader().getResource("Resources/View/150px-Wither_Skeleton_Skull.png")).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT)));
                    detailEntityTitleName.setText("Detail");
                    detailEntitySubtitleName.setText("Publisher");
                    hideDetailColumnBook();
                    break;
                case "Book":
                    DetailBook detailBook = control.selectDetailBook(id);
                    detailEntityTitle.setText("[#" + detailBook.getBook().getId() + "] " + detailBook.getBook().getTitle() + " (" + detailBook.getBook().getPublishedYear() + ")");
                    detailEntitySubtitle.setText("Category : " + detailBook.getBook().getCategory() + " || Written by " + detailBook.getBook().getAuthor());
                    detailEntityTableName.setText("This book has been borrowed " + detailBook.getTotalBorrowing() + " time(s)");
                    detailEntityListTable.setModel(control.setTableBorrowing(detailBook.getBorrowingList()));
                    detailEntityIconLabel.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(this.getClass().getClassLoader().getResource("Resources/View/Written_Book.png")).getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_DEFAULT)));
                    detailEntityTitleName.setText("Detail");
                    detailEntitySubtitleName.setText("Book");
                    hideDetailColumnBorrowing();
                    break;
                default:
                    break;
            }
            detailEntityFrame.setVisible(true);
            detailFrame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please select only 1 entry and not from 'Borrowing' entry");
        }
    }//GEN-LAST:event_detailDetailBtnActionPerformed

    private void detailBookBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBookBackBtnActionPerformed
        // TODO add your handling code here:
        detailEntityFrame.setVisible(false);
        detailFrame.setVisible(true);
    }//GEN-LAST:event_detailBookBackBtnActionPerformed

    private void detailEntityFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_detailEntityFrameWindowClosed
        // TODO add your handling code here:
        detailEntityFrame.setVisible(false);
        detailFrame.setVisible(true);
    }//GEN-LAST:event_detailEntityFrameWindowClosed

    private void insertBorrowingCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBorrowingCancelBtnActionPerformed
        // TODO add your handling code here:
        insertBorrowingFrame.setVisible(false);
        detailFrame.setVisible(true);
        insertBorrowingIdField.setText("");
        insertBorrowingDurationSpinner.setValue(1);
    }//GEN-LAST:event_insertBorrowingCancelBtnActionPerformed

    private void insertBorrowingGoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBorrowingGoBtnActionPerformed
        // TODO add your handling code here:
        String id = insertBorrowingIdField.getText();
        String idMember = insertBorrowingIdMemberBox.getSelectedItem().toString().split("-")[0];
        String member = insertBorrowingIdMemberBox.getSelectedItem().toString().split("-")[1];
        String idBook = insertBorrowingIdBookBox.getSelectedItem().toString().split("-")[0];
        String book = insertBorrowingIdBookBox.getSelectedItem().toString().split("-")[1];
        String borrowingDate = insertBorrowingBorrowingYearBox.getSelectedItem().toString() + "-" + insertBorrowingBorrowingMonthBox.getSelectedItem().toString() + "-" + insertBorrowingBorrowingDayBox.getSelectedItem().toString();
        String returningDate = insertBorrowingReturningYearBox.getSelectedItem().toString() + "-" + insertBorrowingReturningMonthBox.getSelectedItem().toString() + "-" + insertBorrowingReturningDayBox.getSelectedItem().toString();
        int borrowingDuration = Integer.parseInt(insertBorrowingDurationSpinner.getValue().toString());

        if (!id.equals("")) {
            control.insertBorrowing(id, idMember, member, idBook, book, borrowingDate, returningDate, borrowingDuration);
            resetTable();
        }

        insertBorrowingIdField.setText("");
        insertBorrowingDurationSpinner.setValue(1);
    }//GEN-LAST:event_insertBorrowingGoBtnActionPerformed

    private void insertBorrowingFrameWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_insertBorrowingFrameWindowClosed
        // TODO add your handling code here:
        detailFrame.setVisible(true);
    }//GEN-LAST:event_insertBorrowingFrameWindowClosed

    private void insertBookAuthorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBookAuthorBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookAuthorBoxActionPerformed

    private void insertBorrowingReturningMonthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBorrowingReturningMonthBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBorrowingReturningMonthBoxActionPerformed

    private void insertBorrowingIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBorrowingIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBorrowingIdFieldActionPerformed

    private void insertBookTitleFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertBookTitleFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookTitleFieldKeyPressed

    private void insertBookTitleFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_insertBookTitleFieldPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_insertBookTitleFieldPropertyChange

    private void detailMainTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_detailMainTableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_detailMainTableFocusGained

    private void detailMainTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_detailMainTablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_detailMainTablePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                mainFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailBookBackBtn;
    private javax.swing.JButton detailCreateBtn;
    private javax.swing.JButton detailDetailBtn;
    private javax.swing.JComboBox<String> detailEntityBox;
    private javax.swing.JFrame detailEntityFrame;
    private javax.swing.JLabel detailEntityIconLabel;
    private javax.swing.JTable detailEntityListTable;
    private javax.swing.JLabel detailEntitySubtitle;
    private javax.swing.JLabel detailEntitySubtitleName;
    private javax.swing.JLabel detailEntityTableName;
    private javax.swing.JLabel detailEntityTitle;
    private javax.swing.JLabel detailEntityTitleName;
    private javax.swing.JFrame detailFrame;
    private javax.swing.JLabel detailMainPanel;
    private javax.swing.JTable detailMainTable;
    private javax.swing.JButton detailRemoveBtn;
    private javax.swing.JTextField detailSearchField;
    private javax.swing.JLabel detailTitleLabel;
    private javax.swing.JPanel detailTitlePanel;
    private javax.swing.JPanel detailTitlePanel1;
    private javax.swing.JButton insertAuthorCancelBtn;
    private javax.swing.JTextField insertAuthorCountryField;
    private javax.swing.JRadioButton insertAuthorFemaleRadio;
    private javax.swing.JFrame insertAuthorFrame;
    private javax.swing.ButtonGroup insertAuthorGenderRadioGroup;
    private javax.swing.JButton insertAuthorGoBtn;
    private javax.swing.JTextField insertAuthorIdField;
    private javax.swing.JRadioButton insertAuthorMaleRadio;
    private javax.swing.JTextField insertAuthorNameField;
    private javax.swing.JLabel insertAuthorSubtitleLabel;
    private javax.swing.JLabel insertAuthorTitleLabel;
    private javax.swing.JComboBox<String> insertBookAuthorBox;
    private javax.swing.JButton insertBookCancelBtn;
    private javax.swing.JComboBox<String> insertBookCategoryBox;
    private javax.swing.JFrame insertBookFrame;
    private javax.swing.JButton insertBookGoBtn;
    private javax.swing.JTextField insertBookIdField;
    private javax.swing.JComboBox<String> insertBookPublishedDateYearBox;
    private javax.swing.JComboBox<String> insertBookPublisherBox;
    private javax.swing.JLabel insertBookSubtitleLabel;
    private javax.swing.JTextField insertBookTitleField;
    private javax.swing.JSpinner insertBookTotalPageSpinner;
    private javax.swing.JLabel insertBooklTitleLabel;
    private javax.swing.JComboBox<String> insertBorrowingBorrowingDayBox;
    private javax.swing.JComboBox<String> insertBorrowingBorrowingMonthBox;
    private javax.swing.JComboBox<String> insertBorrowingBorrowingYearBox;
    private javax.swing.JButton insertBorrowingCancelBtn;
    private javax.swing.JSpinner insertBorrowingDurationSpinner;
    private javax.swing.JFrame insertBorrowingFrame;
    private javax.swing.JButton insertBorrowingGoBtn;
    private javax.swing.JComboBox<String> insertBorrowingIdBookBox;
    private javax.swing.JTextField insertBorrowingIdField;
    private javax.swing.JComboBox<String> insertBorrowingIdMemberBox;
    private javax.swing.JComboBox<String> insertBorrowingReturningDayBox;
    private javax.swing.JComboBox<String> insertBorrowingReturningMonthBox;
    private javax.swing.JComboBox<String> insertBorrowingReturningYearBox;
    private javax.swing.JButton insertCategoryCancelBtn;
    private javax.swing.JFrame insertCategoryFrame;
    private javax.swing.JButton insertCategoryGoBtn;
    private javax.swing.JTextField insertCategoryIdField;
    private javax.swing.JTextField insertCategoryLabelField;
    private javax.swing.JTextField insertCategoryNameField;
    private javax.swing.JLabel insertCategorySubtitleLabel;
    private javax.swing.JLabel insertCategoryTitleLabel;
    private javax.swing.JPanel insertCategoryTitlePanel;
    private javax.swing.JPanel insertCategoryTitlePanel1;
    private javax.swing.JTextArea insertMemberAddressArea;
    private javax.swing.JButton insertMemberCancelBtn;
    private javax.swing.JRadioButton insertMemberFemaleRadio;
    private javax.swing.JFrame insertMemberFrame;
    private javax.swing.ButtonGroup insertMemberGenderRadioGroup;
    private javax.swing.JButton insertMemberGoBtn;
    private javax.swing.JTextField insertMemberIdField;
    private javax.swing.JRadioButton insertMemberMaleRadio;
    private javax.swing.JTextField insertMemberNameField;
    private javax.swing.JTextField insertMemberPhoneField;
    private javax.swing.JLabel insertMemberSubtitleLabel;
    private javax.swing.JLabel insertMemberTitleLabel;
    private javax.swing.JPanel insertMemberTitlePanel;
    private javax.swing.JPanel insertMemberTitlePanel1;
    private javax.swing.JTextArea insertPublisherAddressArea;
    private javax.swing.JButton insertPublisherCancelBtn;
    private javax.swing.JTextField insertPublisherCountryField;
    private javax.swing.JFrame insertPublisherFrame;
    private javax.swing.JButton insertPublisherGoBtn;
    private javax.swing.JTextField insertPublisherIdField;
    private javax.swing.JTextField insertPublisherNameField;
    private javax.swing.JTextField insertPublisherPhoneField;
    private javax.swing.JLabel insertPublisherSubtitleLabel;
    private javax.swing.JLabel insertPublisherSubtitleLabel1;
    private javax.swing.JLabel insertPublisherTitleLabel;
    private javax.swing.JLabel insertPublisherTitleLabel1;
    private javax.swing.JPanel insertPublisherTitlePanel;
    private javax.swing.JPanel insertPublisherTitlePanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel mainBtnPanel;
    private javax.swing.JPanel mainCenterPanel;
    private javax.swing.JButton mainGetStartedBtn;
    private javax.swing.JLabel mainSubtitleLabel;
    private javax.swing.JLabel mainTitleLabel;
    private javax.swing.JPanel mainTitlePanel;
    // End of variables declaration//GEN-END:variables

    private static javax.swing.JFrame mainFrame;

}
