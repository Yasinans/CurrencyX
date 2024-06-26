package com.infotech.currencyconverter.Components;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {

    private String firstCurSymbol, secondCurSymbol;
    private double firstCur, secondCur;
    private ImageIcon scaledHomeImage, scaledSettingImage, scaledSwapImage, scaledDropImage,
            scaledHoveredSwapImage, scaledRedCircleImage, scaledGreenCircleImage, scaledIconImage;
    private CurrencyRates currencyRates;

    public MainFrame() throws IOException {
        firstCur = 0;
        secondCur = 0;
        currencyRates = new CurrencyRates();
        initializeAssets();
        initComponents();
        initializeListeners();
        changeStatus(currencyRates.synchronizeData());
        updateJList();
        updateInputValues();
        CurrencySelectorPanel2.setVisible(false);
        CurrencySelectorPanel1.setVisible(false);
        SettingPanel.setVisible(false);
        syncStatusLabel.setVisible(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nav = new JPanel();
        HomeButton = new JToggleButton();
        SettingButton = new JToggleButton();
        MainPanel = new JPanel();
        HomePanel = new JPanel();
        firstCurListButton = new JButton();
        secondCurListButton = new JButton();
        firstCurrencyField = new JTextField();
        secondCurrencyField = new JTextField();
        switchButton = new JButton();
        CurrencySelectorPanel2 = new JPanel();
        CurrencyScroll2 = new JScrollPane();
        CurrencyList2 = new JList<>();
        CurrencySelectorPanel1 = new JPanel();
        CurrencyScroll1 = new JScrollPane();
        CurrencyList1 = new JList<>();
        RateLabel = new JLabel();
        LastUpdatedLabel = new JLabel();
        StatusLabel = new JLabel();
        headerLabel = new JLabel();
        jSeparator3 = new JSeparator();
        SettingPanel = new JPanel();
        syncPanel = new JPanel();
        syncButton = new JButton();
        jSeparator2 = new JSeparator();
        syncStatusLabel = new JLabel();
        synchronizeLabel = new JLabel();
        resetPanel = new JPanel();
        resetButton = new JButton();
        jSeparator1 = new JSeparator();
        resetLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("CurrencyX");
        setBackground(new java.awt.Color(231, 215, 193));
        setMinimumSize(new java.awt.Dimension(730, 430));
        setPreferredSize(new java.awt.Dimension(730, 430));
        setResizable(false);
        setSize(new java.awt.Dimension(730, 430));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nav.setBackground(new java.awt.Color(191, 67, 66));
        Nav.setMaximumSize(new java.awt.Dimension(55, 400));
        Nav.setMinimumSize(new java.awt.Dimension(55, 400));
        Nav.setPreferredSize(new java.awt.Dimension(55, 400));
        Nav.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        HomeButton.setBackground(new java.awt.Color(191, 67, 66));
        HomeButton.setIcon(scaledHomeImage);
        HomeButton.setSelected(true);
        HomeButton.setBorder(null);
        HomeButton.setBorderPainted(false);
        HomeButton.setMaximumSize(new java.awt.Dimension(55, 55));
        HomeButton.setMinimumSize(new java.awt.Dimension(55, 55));
        HomeButton.setPreferredSize(new java.awt.Dimension(55, 55));
        Nav.add(HomeButton);

        SettingButton.setBackground(new java.awt.Color(191, 67, 66));
        SettingButton.setIcon(scaledSettingImage);
        SettingButton.setBorder(null);
        SettingButton.setBorderPainted(false);
        SettingButton.setMaximumSize(new java.awt.Dimension(55, 55));
        SettingButton.setMinimumSize(new java.awt.Dimension(55, 55));
        SettingButton.setOpaque(true);
        SettingButton.setPreferredSize(new java.awt.Dimension(55, 55));
        Nav.add(SettingButton);

        getContentPane().add(Nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MainPanel.setBackground(new java.awt.Color(240, 234, 224));
        MainPanel.setMaximumSize(new java.awt.Dimension(670, 400));
        MainPanel.setMinimumSize(new java.awt.Dimension(670, 400));
        MainPanel.setName(""); // NOI18N
        MainPanel.setPreferredSize(new java.awt.Dimension(670, 400));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HomePanel.setBackground(new java.awt.Color(241, 237, 232));
        HomePanel.setMaximumSize(new java.awt.Dimension(670, 400));
        HomePanel.setMinimumSize(new java.awt.Dimension(670, 400));
        HomePanel.setPreferredSize(new java.awt.Dimension(670, 400));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstCurListButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        firstCurListButton.setIcon(scaledDropImage);
        firstCurListButton.setText(firstCurSymbol);
        firstCurListButton.setBorder(null);
        firstCurListButton.setBorderPainted(false);
        firstCurListButton.setFocusPainted(false);
        firstCurListButton.setOpaque(true);
        firstCurListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstCurListButtonActionPerformed(evt);
            }
        });
        HomePanel.add(firstCurListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 50, 40));

        secondCurListButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        secondCurListButton.setIcon(scaledDropImage);
        secondCurListButton.setText(secondCurSymbol);
        secondCurListButton.setBorder(null);
        secondCurListButton.setBorderPainted(false);
        secondCurListButton.setFocusPainted(false);
        secondCurListButton.setOpaque(true);
        secondCurListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondCurListButtonActionPerformed(evt);
            }
        });
        HomePanel.add(secondCurListButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 50, 40));

        firstCurrencyField.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        firstCurrencyField.setHorizontalAlignment(JTextField.LEFT);
        firstCurrencyField.setText("0.0");
        firstCurrencyField.setToolTipText("");
        firstCurrencyField.setAlignmentX(0.0F);
        firstCurrencyField.setAlignmentY(0.0F);
        firstCurrencyField.setBorder(BorderFactory.createEmptyBorder(10, 5, 1, 1));
        firstCurrencyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        firstCurrencyField.setHighlighter(null);
        firstCurrencyField.setMargin(new java.awt.Insets(10, 10, 10, 10));
        firstCurrencyField.setMaximumSize(new java.awt.Dimension(100, 150));
        firstCurrencyField.setMinimumSize(new java.awt.Dimension(100, 150));
        firstCurrencyField.setOpaque(true);
        firstCurrencyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstCurrencyFieldActionPerformed(evt);
            }
        });
        HomePanel.add(firstCurrencyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 130, 40));

        secondCurrencyField.setEditable(false);
        secondCurrencyField.setBackground(new java.awt.Color(255, 255, 255));
        secondCurrencyField.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        secondCurrencyField.setHorizontalAlignment(JTextField.LEFT);
        secondCurrencyField.setText("0.0");
        secondCurrencyField.setToolTipText("");
        secondCurrencyField.setBorder(BorderFactory.createEmptyBorder(10, 5, 1, 1));
        secondCurrencyField.setMargin(new java.awt.Insets(10, 6, 2, 6));
        secondCurrencyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondCurrencyFieldActionPerformed(evt);
            }
        });
        HomePanel.add(secondCurrencyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 130, 40));

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
        switchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchButtonActionPerformed(evt);
            }
        });
        HomePanel.add(switchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 150, 40, 40));

        CurrencySelectorPanel2.setBackground(new java.awt.Color(255, 255, 255));
        CurrencySelectorPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        CurrencyScroll2.setBackground(new java.awt.Color(255, 255, 255));
        CurrencyScroll2.setBorder(null);

        CurrencyList2.setBorder(null);
        CurrencyList2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        CurrencyList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CurrencyScroll2.setViewportView(CurrencyList2);

        CurrencySelectorPanel2.add(CurrencyScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 190));

        HomePanel.add(CurrencySelectorPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 50, 190));

        CurrencySelectorPanel1.setBackground(new java.awt.Color(255, 255, 255));
        CurrencySelectorPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CurrencyScroll1.setBackground(new java.awt.Color(255, 255, 255));
        CurrencyScroll1.setBorder(null);

        CurrencyList1.setBorder(null);
        CurrencyList1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        CurrencyList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CurrencyScroll1.setViewportView(CurrencyList1);

        CurrencySelectorPanel1.add(CurrencyScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 190));



        HomePanel.add(CurrencySelectorPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 50, 190));

        RateLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        RateLabel.setText("1 USD   =   1 JPN ");
        HomePanel.add(RateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        LastUpdatedLabel.setText("Last Updated: July 10, 2024");
        HomePanel.add(LastUpdatedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        StatusLabel.setIcon(scaledGreenCircleImage);
        StatusLabel.setText("Offline");
        HomePanel.add(StatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        headerLabel.setBackground(new java.awt.Color(182, 202, 227));
        headerLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setIcon(scaledIconImage);
        headerLabel.setText("CurrencyX");
        headerLabel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 80));
        headerLabel.setIconTextGap(2);
        headerLabel.setOpaque(true);
        HomePanel.add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 80));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        HomePanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 670, 10));

        MainPanel.add(HomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        SettingPanel.setBackground(new java.awt.Color(241, 237, 232));
        SettingPanel.setMaximumSize(new java.awt.Dimension(670, 400));
        SettingPanel.setMinimumSize(new java.awt.Dimension(670, 400));
        SettingPanel.setName(""); // NOI18N
        SettingPanel.setPreferredSize(new java.awt.Dimension(670, 400));
        SettingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        syncPanel.setBackground(new java.awt.Color(245, 244, 244));
        syncPanel.setBorder(new LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        syncPanel.setToolTipText("");
        syncPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        syncButton.setText("Sync");
        syncButton.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        syncButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncButtonActionPerformed(evt);
            }
        });
        syncPanel.add(syncButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(154, 88, 88));
        syncPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 20));

        syncStatusLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        syncStatusLabel.setText("Failed");
        syncPanel.add(syncStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 65, -1, -1));

        synchronizeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        synchronizeLabel.setText("Synchronize Data");
        syncPanel.add(synchronizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        SettingPanel.add(syncPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 600, 100));

        resetPanel.setBackground(new java.awt.Color(245, 244, 244));
        resetPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(154, 88, 88), 1, true));
        resetPanel.setToolTipText("");
        resetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resetButton.setText("Reset");
        resetButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        resetPanel.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(154, 88, 88));
        resetPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 20));

        resetLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        resetLabel1.setText("Reset Data");
        resetPanel.add(resetLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        SettingPanel.add(resetPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 600, 100));

        MainPanel.add(SettingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 0, -1, -1));

        pack();
    }

    private void initializeListeners() {
        CurrencyList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    firstCurSymbol = CurrencyList1.getSelectedValue();
                    firstCurListButton.setText(firstCurSymbol);
                    updateInputValues();
                }
            }
        });

        CurrencyList2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    secondCurSymbol = CurrencyList2.getSelectedValue();
                    secondCurListButton.setText(secondCurSymbol);
                    updateInputValues();
                }
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
                togglePanels(HomeButton, SettingButton, HomePanel, SettingPanel);
            }
        });

        SettingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                togglePanels(SettingButton, HomeButton, SettingPanel, HomePanel);
            }
        });
    }

    private void togglePanels(JToggleButton selectedButton, JToggleButton otherButton,
                              JPanel showPanel, JPanel hidePanel) {
        if (otherButton.isSelected()) {
            syncStatusLabel.setVisible(false);
            selectedButton.setSelected(true);
            otherButton.setSelected(false);
            hidePanel.setVisible(false);
            showPanel.setVisible(true);
        } else {
            selectedButton.setSelected(true);
        }
    }

    private void updateJList(){
        String[] currencyList = currencyRates.getCurrencyList().toArray(new String[0]);
        CurrencyList1.setListData(currencyList);
        CurrencyList2.setListData(currencyList);
    }

    private void initializeAssets() throws IOException {
        firstCurSymbol = "PHP";
        secondCurSymbol = "USD";
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/icon.png")));
        scaledHomeImage = scaleImage("/Icons/Home.png", 25, 25);
        scaledSwapImage = scaleImage("/Icons/Swap.png", 30, 30);
        scaledHoveredSwapImage = scaleImage("/Icons/HoveredSwap.png", 30, 30);
        scaledSettingImage = scaleImage("/Icons/Setting.png", 25, 25);
        scaledDropImage = scaleImage("/Icons/Drop.png", 10, 10);
        scaledRedCircleImage = scaleImage("/Icons/RedCircle.png", 7, 7);
        scaledGreenCircleImage = scaleImage("/Icons/GreenCircle.png", 7, 7);
        scaledIconImage = scaleImage("/Icons/icon.png", 70, 70);
    }

    private ImageIcon scaleImage(String path, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(MainFrame.class.getResource(path));
        return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private void firstCurListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CurrencySelectorPanel1.setVisible(!CurrencySelectorPanel1.isVisible());
    }

    private void secondCurListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CurrencySelectorPanel2.setVisible(!CurrencySelectorPanel2.isVisible());
    }

    private void firstCurrencyFieldActionPerformed(java.awt.event.ActionEvent evt) {
        updateInputValues();
    }

    private void secondCurrencyFieldActionPerformed(java.awt.event.ActionEvent evt) {
        updateInputValues();
    }

    private void switchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switchCurrencies();
    }

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


    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        resetData();
    }

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

    private void syncButtonActionPerformed(java.awt.event.ActionEvent evt) {
        syncStatusLabel.setVisible(true);
        syncStatusLabel.setText("Syncing");
        boolean syncResult = currencyRates.synchronizeData();
        changeStatus(syncResult);
        syncStatusLabel.setText(syncResult ? "Success" : "Cannot connect to the API");
        updateJList();
    }

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

    private void changeStatus(boolean status) {
        LastUpdatedLabel.setText("Last Update: " + currencyRates.getPreviousUpdate());
        StatusLabel.setText(status ? "Online" : "Offline");
        StatusLabel.setIcon(status ? scaledGreenCircleImage : scaledRedCircleImage);
    }

    private JList<String> CurrencyList1;
    private JList<String> CurrencyList2;
    private JScrollPane CurrencyScroll1;
    private JScrollPane CurrencyScroll2;
    private JPanel CurrencySelectorPanel1;
    private JPanel CurrencySelectorPanel2;
    private JToggleButton HomeButton;
    private JPanel HomePanel;
    private JLabel LastUpdatedLabel;
    private JPanel MainPanel;
    private JPanel Nav;
    private JLabel RateLabel;

    private JToggleButton SettingButton;
    private JPanel SettingPanel;
    private JLabel StatusLabel;
    private JButton firstCurListButton;
    private JTextField firstCurrencyField;
    private JLabel headerLabel;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JButton resetButton;
    private JLabel resetLabel1;
    private JPanel resetPanel;
    private JButton secondCurListButton;
    private JTextField secondCurrencyField;
    private JButton switchButton;
    private JButton syncButton;
    private JPanel syncPanel;
    private JLabel syncStatusLabel;
    private JLabel synchronizeLabel;
}
