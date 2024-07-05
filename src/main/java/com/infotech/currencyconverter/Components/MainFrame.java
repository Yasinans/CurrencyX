package com.infotech.currencyconverter.Components;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    private String firstCurSymbol, secondCurSymbol;
    private double firstCur, secondCur;
    private ImageIcon scaledHomeImage, scaledSettingImage, scaledSwapImage, scaledDropImage,
            scaledHoveredSwapImage, scaledRedCircleImage, scaledGreenCircleImage, scaledIconImage, scaledWalletImage;
    private CurrencyRates currencyRates;
    private HashMap<JToggleButton, JPanel> buttonPanelBind;
    private JList<String> CurrencyList1, CurrencyList2;
    private JLabel StatusLabel, syncStatusLabel, RateLabel, LastUpdatedLabel;
    private JTextField firstCurrencyField, secondCurrencyField,firstCurrencyInput,amountInput,secondCurrencyInput;
    private JButton switchButton, secondCurListButton, firstCurListButton;
    private JToggleButton WalletButton, SettingButton, HomeButton;
    private JPanel WalletPanel, SettingPanel, HomePanel, CurrencySelectorPanel1, CurrencySelectorPanel2;
    private JTable walletTable, homeTable;
    public MainFrame() throws IOException {
        buttonPanelBind = new HashMap<>();
        firstCur = 0;
        secondCur = 0;
        firstCurSymbol = "PHP";
        secondCurSymbol = "USD";
        currencyRates = new CurrencyRates();
        initializeAssets();
        initComponents();
        initializeListeners();
        changeStatus(currencyRates.synchronizeData());
        updateJList();
        updateInputValues();
        CurrencySelectorPanel2.setVisible(false);
        CurrencySelectorPanel1.setVisible(false);
        WalletPanel.setVisible(false);
        SettingPanel.setVisible(false);
        syncStatusLabel.setVisible(false);
        buttonPanelBind.put(HomeButton, HomePanel);
        buttonPanelBind.put(WalletButton, WalletPanel);
        buttonPanelBind.put(SettingButton, SettingPanel);
        loadData();
    }

    /***
     * Initializes the components
     */
    private void initComponents() {
        //initialization and local declaration
        JPanel nav = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel resetPanel = new JPanel();
        JPanel syncPanel = new JPanel();
        JPanel operationPanel = new JPanel();
        JPanel tablePanel;
        JScrollPane currencyScroll2 = new JScrollPane();
        JScrollPane currencyScroll1 = new JScrollPane();
        JScrollPane walletScrollPane = new JScrollPane();
        JSeparator wSeparator2 = new JSeparator();
        JSeparator wSeparator1 = new JSeparator();
        JSeparator jSeparator3 = new JSeparator();
        JSeparator jSeparator2 = new JSeparator();
        JSeparator jSeparator1 = new JSeparator();
        JButton syncButton = new JButton();
        JButton resetButton = new JButton();
        JButton deleteButton = new JButton();
        JButton addButton = new JButton();
        homeTable = new JTable();
        amountInput = new JTextField();
        firstCurrencyInput = new JTextField();
        secondCurrencyInput = new JTextField();
        walletTable = new JTable();
        JLabel synchronizeLabel = new JLabel();
        JLabel headerLabel = new JLabel();
        JLabel resetLabel = new JLabel();
        JLabel operationLabel = new JLabel();
        syncStatusLabel = new JLabel();
        StatusLabel = new JLabel();
        RateLabel = new JLabel();
        LastUpdatedLabel = new JLabel();
        CurrencySelectorPanel2 = new JPanel();
        CurrencySelectorPanel1 = new JPanel();
        HomePanel = new JPanel();
        WalletPanel = new JPanel();
        SettingPanel = new JPanel();
        CurrencyList1 = new JList<>();
        CurrencyList2 = new JList<>();
        firstCurListButton = new JButton();
        secondCurListButton = new JButton();
        firstCurrencyField = new JTextField();
        secondCurrencyField = new JTextField();
        switchButton = new JButton();
        HomeButton = new JToggleButton();
        SettingButton = new JToggleButton();
        WalletButton = new JToggleButton();
        //main frame customizing
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConvertX");
        setBackground(new java.awt.Color(231, 215, 193));
        setMinimumSize(new java.awt.Dimension(730, 430));
        setPreferredSize(new java.awt.Dimension(730, 430));
        setResizable(false);
        setSize(new java.awt.Dimension(730, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //navigation bar
        nav.setBackground(new java.awt.Color(191, 67, 66));
        nav.setMaximumSize(new java.awt.Dimension(55, 400));
        nav.setMinimumSize(new java.awt.Dimension(55, 400));
        nav.setPreferredSize(new java.awt.Dimension(55, 400));
        nav.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        HomeButton.setBackground(new java.awt.Color(191, 67, 66));
        HomeButton.setIcon(scaledHomeImage);
        HomeButton.setSelected(true);
        HomeButton.setBorder(null);
        HomeButton.setBorderPainted(false);
        HomeButton.setMaximumSize(new java.awt.Dimension(55, 55));
        HomeButton.setMinimumSize(new java.awt.Dimension(55, 55));
        HomeButton.setPreferredSize(new java.awt.Dimension(55, 55));
        nav.add(HomeButton);

        WalletButton.setBackground(new java.awt.Color(191, 67, 66));
        WalletButton.setIcon(scaledWalletImage);
        WalletButton.setBorder(null);
        WalletButton.setBorderPainted(false);
        WalletButton.setMaximumSize(new java.awt.Dimension(55, 55));
        WalletButton.setMinimumSize(new java.awt.Dimension(55, 55));
        WalletButton.setPreferredSize(new java.awt.Dimension(55, 55));
        nav.add(WalletButton);

        SettingButton.setBackground(new java.awt.Color(191, 67, 66));
        SettingButton.setIcon(scaledSettingImage);
        SettingButton.setBorder(null);
        SettingButton.setBorderPainted(false);
        SettingButton.setMaximumSize(new java.awt.Dimension(55, 55));
        SettingButton.setMinimumSize(new java.awt.Dimension(55, 55));
        SettingButton.setOpaque(true);
        SettingButton.setPreferredSize(new java.awt.Dimension(55, 55));
        nav.add(SettingButton);

        getContentPane().add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainPanel.setBackground(new java.awt.Color(240, 234, 224));
        mainPanel.setMaximumSize(new java.awt.Dimension(670, 400));
        mainPanel.setMinimumSize(new java.awt.Dimension(670, 400));
        mainPanel.setName(""); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(670, 400));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HomePanel.setBackground(new java.awt.Color(241, 237, 232));
        HomePanel.setMaximumSize(new java.awt.Dimension(670, 400));
        HomePanel.setMinimumSize(new java.awt.Dimension(670, 400));
        HomePanel.setPreferredSize(new java.awt.Dimension(670, 400));
        HomePanel.setName("Home Panel");
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstCurListButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12)); // NOI18N
        firstCurListButton.setIcon(scaledDropImage);
        firstCurListButton.setText(firstCurSymbol);
        firstCurListButton.setBorder(null);
        firstCurListButton.setBorderPainted(false);
        firstCurListButton.setFocusPainted(false);
        firstCurListButton.setOpaque(true);
        firstCurListButton.addActionListener(this::firstCurListButtonActionPerformed);
        HomePanel.add(firstCurListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 50, 40));

        secondCurListButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12)); // NOI18N
        secondCurListButton.setIcon(scaledDropImage);
        secondCurListButton.setText(secondCurSymbol);
        secondCurListButton.setBorder(null);
        secondCurListButton.setBorderPainted(false);
        secondCurListButton.setFocusPainted(false);
        secondCurListButton.setOpaque(true);
        secondCurListButton.addActionListener(this::secondCurListButtonActionPerformed);
        HomePanel.add(secondCurListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 50, 40));

        firstCurrencyField.setFont(new java.awt.Font("Yu Gothic Medium", Font.PLAIN, 18)); // NOI18N
        firstCurrencyField.setHorizontalAlignment(JTextField.LEFT);
        firstCurrencyField.setText("0.0");
        firstCurrencyField.setToolTipText("");
        firstCurrencyField.setAlignmentX(0.0F);
        firstCurrencyField.setAlignmentY(0.0F);
        firstCurrencyField.setBorder(BorderFactory.createEmptyBorder(10, 5, 1, 1));
        firstCurrencyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstCurrencyField.setHighlighter(null);
        firstCurrencyField.setMargin(new java.awt.Insets(10, 10, 10, 10));
        firstCurrencyField.setMaximumSize(new java.awt.Dimension(100, 130));
        firstCurrencyField.setMinimumSize(new java.awt.Dimension(100, 130));
        firstCurrencyField.setOpaque(true);
        firstCurrencyField.addActionListener(this::firstCurrencyFieldActionPerformed);
        HomePanel.add(firstCurrencyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 130, 40));

        secondCurrencyField.setEditable(false);
        secondCurrencyField.setBackground(new java.awt.Color(255, 255, 255));
        secondCurrencyField.setFont(new java.awt.Font("Yu Gothic Medium", Font.PLAIN, 18)); // NOI18N
        secondCurrencyField.setHorizontalAlignment(JTextField.LEFT);
        secondCurrencyField.setText("0.0");
        secondCurrencyField.setToolTipText("");
        secondCurrencyField.setBorder(BorderFactory.createEmptyBorder(10, 5, 1, 1));
        secondCurrencyField.setMargin(new java.awt.Insets(10, 6, 2, 6));
        secondCurrencyField.addActionListener(this::secondCurrencyFieldActionPerformed);
        HomePanel.add(secondCurrencyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, 40));

        switchButton.setBackground(new java.awt.Color(227, 208, 194));
        switchButton.setIcon(scaledSwapImage);
        switchButton.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        switchButton.setBorderPainted(false);
        switchButton.setContentAreaFilled(false);
        switchButton.setFocusPainted(false);
        switchButton.setMaximumSize(new java.awt.Dimension(75, 30));
        switchButton.setMinimumSize(new java.awt.Dimension(75, 30));
        switchButton.setName(""); // NOI18N
        switchButton.setPreferredSize(new java.awt.Dimension(75, 30));
        switchButton.addActionListener(this::switchButtonActionPerformed);
        HomePanel.add(switchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 130, 40, 40));

        CurrencySelectorPanel2.setBackground(new java.awt.Color(255, 255, 255));
        CurrencySelectorPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        currencyScroll2.setBackground(new java.awt.Color(255, 255, 255));
        currencyScroll2.setBorder(null);

        CurrencyList2.setBorder(null);
        CurrencyList2.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12)); // NOI18N
        CurrencyList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currencyScroll2.setViewportView(CurrencyList2);

        CurrencySelectorPanel2.add(currencyScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 190));

        HomePanel.add(CurrencySelectorPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 50, 190));

        CurrencySelectorPanel1.setBackground(new java.awt.Color(255, 255, 255));
        CurrencySelectorPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        currencyScroll1.setBackground(new java.awt.Color(255, 255, 255));
        currencyScroll1.setBorder(null);

        CurrencyList1.setBorder(null);
        CurrencyList1.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12)); // NOI18N
        CurrencyList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currencyScroll1.setViewportView(CurrencyList1);

        CurrencySelectorPanel1.add(currencyScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 190));

        HomePanel.add(CurrencySelectorPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 50, 190));

        RateLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.PLAIN, 12)); // NOI18N
        RateLabel.setText("1 USD   =   1 JPN ");
        HomePanel.add(RateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        LastUpdatedLabel.setText("Last Updated: July 10, 2024");
        HomePanel.add(LastUpdatedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        StatusLabel.setIcon(scaledGreenCircleImage);
        StatusLabel.setText("Offline");
        HomePanel.add(StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, -1));

        JScrollPane homeTablePane = new JScrollPane();
        HomePanel.add(homeTablePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 670, 130));
        homeTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Base Currency", "Target Currency"
                }
        ));
        homeTablePane.setViewportView(homeTable);


        headerLabel.setBackground(new java.awt.Color(182, 202, 227));
        headerLabel.setFont(new java.awt.Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setIcon(scaledIconImage);
        headerLabel.setText("ConvertX");
        headerLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 55));
        headerLabel.setIconTextGap(2);
        headerLabel.setOpaque(true);
        HomePanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 670, 10));
        HomePanel.add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 55));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.add(HomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        // Wallet Panel
        WalletPanel = new javax.swing.JPanel();
        WalletPanel.setBackground(new java.awt.Color(241, 237, 232));
        WalletPanel.setMaximumSize(new java.awt.Dimension(670, 400));
        WalletPanel.setMinimumSize(new java.awt.Dimension(670, 400));
        WalletPanel.setName("Wallet"); // NOI18N
        WalletPanel.setPreferredSize(new java.awt.Dimension(670, 400));
        WalletPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        tablePanel = new javax.swing.JPanel();
        tablePanel.setBackground(new java.awt.Color(245, 244, 244));
        tablePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        tablePanel.setToolTipText("");
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        operationPanel.setBackground(new java.awt.Color(245, 244, 244));
        operationPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        operationPanel.setToolTipText("");
        operationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        operationLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        operationLabel.setText("Operation");

        wSeparator1.setBackground(new java.awt.Color(154, 88, 88));
        wSeparator1.setForeground(new java.awt.Color(154, 88, 88));
        wSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        wSeparator2.setBackground(new java.awt.Color(154, 88, 88));
        wSeparator2.setForeground(new java.awt.Color(154, 88, 88));
        wSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        amountInput.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        amountInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        amountInput.setText("0.0");
        amountInput.setToolTipText("");
        amountInput.setAlignmentX(0.0F);
        amountInput.setAlignmentY(0.0F);
        amountInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 1, 1));
        amountInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstCurrencyInput.setEditable(true);
        firstCurrencyInput.setBackground(new java.awt.Color(255, 255, 255));
        firstCurrencyInput.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        firstCurrencyInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstCurrencyInput.setText("USD");
        firstCurrencyInput.setToolTipText("");
        firstCurrencyInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 1, 1));
        firstCurrencyInput.setMargin(new java.awt.Insets(10, 6, 2, 6));
        secondCurrencyInput.setEditable(true);
        secondCurrencyInput.setBackground(new java.awt.Color(255, 255, 255));
        secondCurrencyInput.setFont(new java.awt.Font("Yu Gothic Medium", 0, 12)); // NOI18N
        secondCurrencyInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        secondCurrencyInput.setText("PHP");
        secondCurrencyInput.setToolTipText("");
        secondCurrencyInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 5, 1, 1));
        secondCurrencyInput.setMargin(new java.awt.Insets(10, 6, 2, 6));
        deleteButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        deleteButton.addActionListener(this::deleteButtonActionPerformed);
        deleteButton.setText("Delete");
        addButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);
        addButton.setToolTipText("");

        walletTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ID", "Base Currency", "Target Currency"
                }
        ));
        walletTable.getTableHeader().setReorderingAllowed(false);
        walletScrollPane.setViewportView(walletTable);
        tablePanel.add(walletScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 240));

        operationPanel.add(amountInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, 30));
        operationPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 70, 30));
        operationPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 70, 30));
        operationPanel.add(secondCurrencyInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 40, 30));
        operationPanel.add(firstCurrencyInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 40, 30));
        operationPanel.add(wSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 10, 100));
        operationPanel.add(wSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 10, 80));
        operationPanel.add(operationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));
        WalletPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 610, 240));
        WalletPanel.add(operationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 610, 100));
        mainPanel.add(WalletPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));


        // Setting Panel
        SettingPanel.setBackground(new java.awt.Color(241, 237, 232));
        SettingPanel.setMaximumSize(new java.awt.Dimension(670, 400));
        SettingPanel.setMinimumSize(new java.awt.Dimension(670, 400));
        SettingPanel.setName("Settings"); // NOI18N
        SettingPanel.setPreferredSize(new java.awt.Dimension(670, 400));
        SettingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        syncPanel.setBackground(new java.awt.Color(245, 244, 244));
        syncPanel.setBorder(new LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        syncPanel.setToolTipText("");
        syncPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        syncButton.setText("Sync");
        syncButton.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        syncButton.addActionListener(this::syncButtonActionPerformed);
        syncPanel.add(syncButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(154, 88, 88));
        syncPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 20));

        syncStatusLabel.setFont(new java.awt.Font("Yu Gothic UI", Font.PLAIN, 12)); // NOI18N
        syncStatusLabel.setText("Failed");
        syncPanel.add(syncStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 65, -1, -1));

        synchronizeLabel.setFont(new java.awt.Font("Yu Gothic UI", Font.BOLD, 18)); // NOI18N
        synchronizeLabel.setText("Synchronize Data");
        syncPanel.add(synchronizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        SettingPanel.add(syncPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 600, 100));

        resetPanel.setBackground(new java.awt.Color(245, 244, 244));
        resetPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        resetPanel.setToolTipText("");
        resetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resetButton.setText("Reset");
        resetButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        resetButton.addActionListener(this::resetButtonActionPerformed);
        resetPanel.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(154, 88, 88));
        resetPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 20));

        resetLabel.setFont(new java.awt.Font("Yu Gothic UI", Font.BOLD, 18)); // NOI18N
        resetLabel.setText("Reset Data");
        resetPanel.add(resetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        SettingPanel.add(resetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 600, 100));

        mainPanel.add(SettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 0, -1, -1));

        pack();
    }

    /***
     * Initializes the listeners
     */
    private void initializeListeners() {
        CurrencyList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                firstCurSymbol = CurrencyList1.getSelectedValue();
                firstCurListButton.setText(firstCurSymbol);
                updateInputValues();
            }
        });

        CurrencyList2.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                secondCurSymbol = CurrencyList2.getSelectedValue();
                secondCurListButton.setText(secondCurSymbol);
                updateInputValues();
            }
        });

        firstCurListButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                firstCurListButton.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                firstCurListButton.setForeground(Color.decode("0x313131"));
            }
        });

        switchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                switchButton.setIcon(scaledHoveredSwapImage);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                switchButton.setIcon(scaledSwapImage);
            }
        });

        HomeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                togglePanels(HomeButton, HomePanel);
            }
        });

        WalletButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                togglePanels(WalletButton, WalletPanel);
            }
        });

        SettingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                togglePanels(SettingButton, SettingPanel);
            }
        });
    }

    /***
     *
     * @param selectedButton The button that is being selected
     * @param showPanel The panel that will be shown after a click
     */
    private void togglePanels(JToggleButton selectedButton, JPanel showPanel) {
        selectedButton.setSelected(true);
        showPanel.setVisible(true);
        for(JToggleButton otherButton: buttonPanelBind.keySet()){
            if(selectedButton != otherButton) otherButton.setSelected(false);
        }
        for(JPanel otherPanel: buttonPanelBind.values()){
            if(showPanel != otherPanel) {
                otherPanel.setVisible(false);
            }
        }
    }

    /***
     * Updates the Currency List Components to match with the current Currency List data of the currencyRates variable.
     */
    private void updateJList(){
        String[] currencyList = currencyRates.getCurrencyList().toArray(new String[0]);
        CurrencyList1.setListData(currencyList);
        CurrencyList2.setListData(currencyList);
    }

    /***
     * Initalizes the assets
     */
    private void initializeAssets() throws IOException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/icon.png")));
        scaledHomeImage = scaleImage("/Icons/Home.png", 25, 25);
        scaledSwapImage = scaleImage("/Icons/Swap.png", 30, 30);
        scaledHoveredSwapImage = scaleImage("/Icons/HoveredSwap.png", 30, 30);
        scaledSettingImage = scaleImage("/Icons/Setting.png", 25, 25);
        scaledDropImage = scaleImage("/Icons/Drop.png", 10, 10);
        scaledRedCircleImage = scaleImage("/Icons/RedCircle.png", 7, 7);
        scaledGreenCircleImage = scaleImage("/Icons/GreenCircle.png", 7, 7);
        scaledIconImage = scaleImage("/Icons/icon.png", 40, 40);
        scaledWalletImage = scaleImage("/Icons/Wallet.png", 25,25);
    }

    private void saveData() {
        File data = new File("wallet.txt");
        try {
            data.createNewFile();
            FileWriter dataWriter = new FileWriter(data);
            DefaultTableModel model = (DefaultTableModel) walletTable.getModel();
            Vector<Vector> dataVector = model.getDataVector();
            for (Vector row : dataVector) {
                for (Object value : row) {
                    dataWriter.write(value.toString() + "\t");
                }
                dataWriter.write("\n");
            }
            dataWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) walletTable.getModel();
        try {
            File data = new File("wallet.txt");
            FileReader dataReader = new FileReader(data);
            Scanner sc = new Scanner(dataReader);
            Vector<Vector<String>> walletData = new Vector<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                Vector<String> row = new Vector<>();
                for (String value : values) {
                    row.add(value);
                }
                walletData.add(row);
            }
            dataReader.close();

            // Clear the existing data
            model.setRowCount(0);
            for (Vector<String> rowData : walletData) {
                model.addRow(rowData);
            }
            homeTable.setModel(model);
        } catch (Exception e) {
            //prob file doesnt exist
        }
    }
    //Method used to scale an image and return as a ImageIcon
    private ImageIcon scaleImage(String path, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(MainFrame.class.getResource(path)));
        return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private void addButtonActionPerformed(ActionEvent evt){
        String baseCurrency = firstCurrencyInput.getText() ;
        String secondCurrency = secondCurrencyInput.getText();
        String baseAmount = amountInput.getText();
        DefaultTableModel model = (DefaultTableModel) walletTable.getModel();
        int currentRowCount = walletTable.getRowCount()==0 ? 0 : Integer.parseInt(String.valueOf(walletTable.getValueAt(walletTable.getRowCount()-1,0)));
        model.addRow(new Object[]{currentRowCount+1, baseAmount+" "+baseCurrency, currencyRates.getRates(baseCurrency,secondCurrency, Double.parseDouble(baseAmount))+" "+secondCurrency});
        homeTable.setModel(model);
        saveData();
    }

    private void deleteButtonActionPerformed(ActionEvent evt){
        DefaultTableModel model = (DefaultTableModel) walletTable.getModel();
        int selectedRow = walletTable.getSelectedRow();
        model.removeRow(selectedRow);
        homeTable.setModel(model);
    }

    private void firstCurListButtonActionPerformed(ActionEvent evt) {
        CurrencySelectorPanel1.setVisible(!CurrencySelectorPanel1.isVisible());
    }
    private void secondCurListButtonActionPerformed(ActionEvent evt) {
        CurrencySelectorPanel2.setVisible(!CurrencySelectorPanel2.isVisible());
    }
    private void firstCurrencyFieldActionPerformed(ActionEvent evt) {
        updateInputValues();
    }
    private void secondCurrencyFieldActionPerformed(ActionEvent evt) {
        updateInputValues();
    }
    private void switchButtonActionPerformed(ActionEvent evt) {
        switchCurrencies();
    }
    private void resetButtonActionPerformed(ActionEvent evt) {
        resetData();
    }
    private void syncButtonActionPerformed(ActionEvent evt) {
        syncStatusLabel.setVisible(true);
        syncStatusLabel.setText("Syncing");
        boolean syncResult = currencyRates.synchronizeData();
        changeStatus(syncResult);
        syncStatusLabel.setText(syncResult ? "Success" : "Cannot connect to the API");
        updateJList();
    }

    /*
        The method that is being called after the user's click the switch button
     */
    private void switchCurrencies() {
        firstCurListButton.setText(secondCurSymbol);
        secondCurListButton.setText(firstCurSymbol);
        firstCurSymbol = firstCurListButton.getText();
        secondCurSymbol = secondCurListButton.getText();
        firstCurrencyField.setText(String.format("%.5f", secondCur));
        secondCurrencyField.setText(String.format("%.2f", firstCur));
        updateInputValues();
        int firstSelectedIndex = CurrencyList1.getSelectedIndex();
        CurrencyList1.setSelectedIndex(CurrencyList2.getSelectedIndex());
        CurrencyList2.setSelectedIndex(firstSelectedIndex);
    }

    /*
        The method used whenever the user's clicks the Reset Button. It is used to remove the locally stored data.
     */
    private void resetData() {
        try {
            currencyRates.deleteLocalData();
            currencyRates = new CurrencyRates();
            firstCurSymbol = "PHP";
            secondCurSymbol = "USD";
            updateJList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
        Updates the variable and does a check if ever the user's input is invalid
     */
    private void updateInputValues(){
        try {
            firstCur = Double.parseDouble(firstCurrencyField.getText());
            secondCur = currencyRates.getRates(firstCurSymbol, secondCurSymbol, firstCur);
            firstCurrencyField.setText(String.valueOf(firstCur));
            secondCurrencyField.setText(String.format("%.2f", secondCur));
            RateLabel.setText("1 " + firstCurSymbol + " = " + String.format("%.2f", currencyRates.getRates(firstCurSymbol, secondCurSymbol, 1)) + " " + secondCurSymbol);
            CurrencySelectorPanel1.setVisible(false);
            CurrencySelectorPanel2.setVisible(false);
        }catch (Exception e) {
            firstCurrencyField.setText(String.valueOf(firstCur));
            secondCurrencyField.setText(String.format("%.2f", secondCur));
        }
    }

    // Changes the API Connection Status Label
    private void changeStatus(boolean status) {
        LastUpdatedLabel.setText("Last Update: " + currencyRates.getPreviousUpdate());
        StatusLabel.setText(status ? "Online" : "Offline");
        StatusLabel.setIcon(status ? scaledGreenCircleImage : scaledRedCircleImage);
    }

}
