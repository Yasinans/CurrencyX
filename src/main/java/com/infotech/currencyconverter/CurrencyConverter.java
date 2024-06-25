
package com.infotech.currencyconverter;

import com.formdev.flatlaf.FlatLightLaf;
import com.infotech.currencyconverter.Components.MainFrame;
import java.io.IOException;

public class CurrencyConverter {
    
    
    public static void main(String[] args) throws IOException {
        FlatLightLaf.setup();
        new MainFrame().setVisible(true);
    }


}
