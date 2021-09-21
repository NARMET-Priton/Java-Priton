package com.WlanKasper.main;

import com.WlanKasper.Business.Business;

public class Main {

    public static void main(String[] args) {

        Business bus = new Business(args[0]);

        bus.initCrypto();

    }
}

